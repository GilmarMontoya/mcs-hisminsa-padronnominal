package pe.gob.minsa.mcs.hisminsa.padron.nominal.service.imp;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

//import pe.gob.minsa.mcs.hisminsa.padron.nominal.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.minsa.mcs.hisminsa.padron.nominal.dao.imp.EnvioDAOImpl;
import pe.gob.minsa.mcs.hisminsa.padron.nominal.entity.ActualizaEntity;
import pe.gob.minsa.mcs.hisminsa.padron.nominal.mq.service.MQActualiza;
import pe.gob.minsa.mcs.hisminsa.padron.nominal.service.EnvioService;

@Service
public class EnvioServiceImpl implements EnvioService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    private MQActualiza mqActualiza;
    
    @Autowired
    private EnvioDAOImpl envioDao;
    
    @Override
	public String ActualizaIpress() {
		logger.debug("Servicio basico");
		List<ActualizaEntity> listaActualiza = envioDao.consultaAtenciones(null);		
		String mensaje  = listaActualiza.stream().map(a -> 
		{
			return procesarAtencion(a);
		}
				).collect(Collectors.joining( "," ) );
		try {
			envioDao.registrarEnvioBatch(listaActualiza);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{\"error\":\"" + e.getMessage()+"\"}";
		}
		return "{\"tramas\" : [" + mensaje +"]}";
	}
    
    private String procesarAtencion(ActualizaEntity actualiza) {
    	String tramaRespuesta = "";
    	try {		
    		tramaRespuesta = mqActualiza.enviaUltimaIpress(actualiza);    	
			String codRespuesta = tramaRespuesta.substring(tramaRespuesta.length()-4);
			LocalDate fechaEnvio = LocalDate.now();
			if(actualiza.getIdEnvio()==null || actualiza.getIdEnvio().isEmpty()) {
				actualiza.setFecEnvio(fechaEnvio.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
			}
			actualiza.setFecActualiza(fechaEnvio.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
			if(codRespuesta.equals("6500") || codRespuesta.equals("6600")) {
				actualiza.setFgEstado("1");			
			}else {
				actualiza.setFgEstado("2");
			}
			actualiza.setRepEnvio(codRespuesta);
			
		}catch(Exception e) {
    		return "{\"id\":\""+actualiza.getId()+"\",\"error\":\"" + e.getMessage()+"\"}";
    	}
		
		return "{\"id\":\""+actualiza.getId()+"\",\"tramaRespuesta\":\"" + tramaRespuesta+"\"}";
    }
	
	@Override
	public String ActualizaIpressProperties(ActualizaEntity request) {
		logger.debug("Servicio basico");
		String tramaRespuesta = mqActualiza.enviaUltimaIpress(request);
		return tramaRespuesta;
	}
}
