package pe.gob.minsa.mcs.hisminsa.padron.nominal.dao;

import java.sql.SQLException;
import java.util.List;

import pe.gob.minsa.mcs.hisminsa.padron.nominal.entity.ActualizaEntity;

public interface IEnvioDAO {
	
	List<ActualizaEntity> consultaAtenciones(String cantidad);

	int registrarEnvio(ActualizaEntity empaquetado) throws SQLException;

	int registrarEnvioBatch(List<ActualizaEntity> listaActualizaEntity) throws Exception;
}
