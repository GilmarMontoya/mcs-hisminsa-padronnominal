package pe.gob.minsa.mcs.hisminsa.padron.nominal.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ActualizaRowMapper implements RowMapper<ActualizaEntity> {

	@Override
	public ActualizaEntity mapRow(ResultSet row, int rowNum) throws SQLException {
		ActualizaEntity actualiza = new ActualizaEntity();
		actualiza.setId((String)(row.getString("id")));
		actualiza.setIdCita((String)(row.getString("idCita")));
		actualiza.setNumDni((String)(row.getString("numDoc")));
		actualiza.setPriApellido((String)(row.getString("priApellido")));
		actualiza.setSegApellido((String)(row.getString("segApellido")));
		actualiza.setPreNombres((String)(row.getString("preNombres")));
		actualiza.setEessAtencion((String)(row.getString("eessAtencion")));
		actualiza.setFecActualiza((String)(row.getString("fecActualiza")));
		actualiza.setFgEstado((String)(row.getString("fgEstado")));
		actualiza.setIdEnvio((String)(row.getString("videnvio")));
		return actualiza;
	}
	
}
