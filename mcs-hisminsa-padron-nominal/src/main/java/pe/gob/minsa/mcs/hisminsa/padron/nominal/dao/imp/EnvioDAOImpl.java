package pe.gob.minsa.mcs.hisminsa.padron.nominal.dao.imp;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.minsa.mcs.hisminsa.padron.nominal.dao.IEnvioDAO;
import pe.gob.minsa.mcs.hisminsa.padron.nominal.entity.ActualizaEntity;
import pe.gob.minsa.mcs.hisminsa.padron.nominal.entity.ActualizaRowMapper;

@Repository
public class EnvioDAOImpl extends JdbcDaoSupport implements IEnvioDAO {

    @Autowired
    public void setDs(DataSource dataSource) {
         setDataSource(dataSource);
    }
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<ActualizaEntity> consultaAtenciones(String cantidad) {
		String sql = "SELECT ";
		sql = sql + "i_id AS id, ";
		sql = sql + "i_id_cita AS idCita, ";
		sql = sql + "v_numdoc AS numDoc, ";
		sql = sql + "v_apellido_paterno AS priApellido, ";
		sql = sql + "v_apellido_materno AS segApellido, ";
		sql = sql + "v_nombres AS preNombres, ";
		sql = sql + "replicate('0', 8 - len(i_codigo_eess)) + cast (i_codigo_eess as varchar) AS eessAtencion, ";
		sql = sql + "v_feccrea AS fecActualiza, ";
		sql = sql + "i_fg_estado AS fgEstado, ";
		sql = sql + "v_id_envio AS videnvio ";
		sql = sql + "FROM tbt_padron_nominal_ultima_aten "; 
		sql = sql + "WHERE i_fg_estado = 0 ";
		sql = sql + "ORDER BY i_id ";
		
		RowMapper<ActualizaEntity> rowMapper = new ActualizaRowMapper();
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	
	@Override
    public int registrarEnvio(ActualizaEntity envio) throws SQLException{
		int cantRegistros = 0;

		String sql = "UPDATE TBT_PADRON_NOMINAL_ULTIMA_ATEN SET " + 
				"V_FECACT = ?, I_FG_ESTADO=?, V_ID_ENVIO=?, V_FECENVIO =  ?, V_ENVIO_RESPUESTA = ? " + 
				"WHERE i_id = ?" ;
			int iInsert = this.jdbcTemplate.update(sql,envio.getFecActualiza(),envio.getFgEstado(),envio.getIdEnvio(),envio.getFecEnvio(),envio.getRepEnvio(),envio.getId());
			cantRegistros = iInsert;

		return cantRegistros;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int registrarEnvioBatch(List<ActualizaEntity> listaActualizaEntity) throws Exception{
		
		int chunkSize = 1000;
		AtomicInteger counter = new AtomicInteger();

		Collection<List<ActualizaEntity>> result = listaActualizaEntity.stream()
		    .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / chunkSize))
		    .values();
		
		return result.stream().map(lista -> {
			return insertaBloque(lista);
		}).reduce(0, Integer::sum);
	}

	private int insertaBloque(List<ActualizaEntity> listaActualizaEntity){
		int cantRegistros = 0;
		try {
		String sql = "UPDATE TBT_PADRON_NOMINAL_ULTIMA_ATEN SET " + 
				" V_FECACT = ?, I_FG_ESTADO=?, V_ID_ENVIO=?, V_FECENVIO =  ?, V_ENVIO_RESPUESTA = ? " + 
				" WHERE i_id = ?";
	

			int[] update = getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			
				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
								
					ActualizaEntity envio = listaActualizaEntity.get(i);

					ps.setString(1, envio.getFecActualiza());
					ps.setString(2, envio.getFgEstado());
					ps.setString(3, envio.getIdEnvio());
					ps.setString(4, envio.getFecEnvio());
					ps.setString(5, envio.getRepEnvio());
					ps.setString(6, envio.getId());					

				}

				@Override
				public int getBatchSize() {
					return listaActualizaEntity.size();
				}
			});
			
			cantRegistros = update.length;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		return cantRegistros;
	}


}
