package pe.gob.minsa.mcs.hisminsa.padron.nominal.mq.service.imp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.minsa.mcs.hisminsa.padron.nominal.entity.ActualizaEntity;
import pe.gob.minsa.mcs.hisminsa.padron.nominal.mq.config.MQBeanClient;
import pe.gob.minsa.mcs.hisminsa.padron.nominal.mq.service.MQActualiza;
import pe.gob.minsa.mcs.hisminsa.padron.nominal.mq.trama.SubTramaUltimaIpress;
import pe.gob.minsa.mcs.hisminsa.padron.nominal.mq.util.ManagerMQ;
import pe.gob.minsa.mcs.hisminsa.padron.nominal.mq.util.ManagerMQPadron;

@Service("MQActualiza")
public class MQActualizaImpl implements MQActualiza {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ManagerMQ managerMQ;
	@Autowired
	private ManagerMQPadron managerMQPadron;

	@Override
	public String enviaUltimaIpress(ActualizaEntity request) {
        String sFragmentacion = "                      ", sResCabecera = " ", sResConsulta = " ";
        String sTiAtencionEESS = "1", sisIntitucionSolicitante = "HIS-MINSA", usuFinalInstitucionSolicitante = "MINSA", noEquipoInstitucionSolictante = "MINSA-PC15";
        SubTramaUltimaIpress subTramaUltimaIpress = new SubTramaUltimaIpress();
        subTramaUltimaIpress.generaSubTramaIn(managerMQPadron.getNuVersion(), managerMQPadron.getLoCabecera(), managerMQPadron.getTiServicio(),
        									  managerMQPadron.getLoTotTrama(), sFragmentacion, managerMQPadron.getDeTtl(), sTiAtencionEESS,
        									  managerMQPadron.getCaVerificacion(), managerMQPadron.getCoInstitucion(), managerMQPadron.getCoSerReniec(),
        									  sisIntitucionSolicitante, usuFinalInstitucionSolicitante, noEquipoInstitucionSolictante, sResCabecera,
        									  request.getNumDni(), request.getPriApellido(), request.getSegApellido(), request.getPreNombres(),
        									  request.getEessAtencion(), request.getFecActualiza(), sResConsulta);
        subTramaUltimaIpress.completaLongitud();
        String sTramaEnvio = subTramaUltimaIpress.returnComoString();
        logger.debug("Trama envio:"+sTramaEnvio);
        
        if (sTramaEnvio.length() < 244) {
            logger.error("La trama ingresada es muy corta. Menor a 244");
            return null;
        } 
        String sTramaRespuesta = consulta(sTramaEnvio);
        logger.debug("Trama respuesta:"+sTramaRespuesta);
        return sTramaRespuesta;
	}

    String consulta(String sTramaEnvio) {
        
        logger.debug("Valores:"+managerMQ.getMqManager()+"-"+managerMQ.getHost()+"-"+managerMQ.getCanal()+"-"+managerMQ.getPuerto()+"-"+managerMQ.getUserID()+"-"+managerMQ.getPass()+"-"+managerMQ.getColaEntrada()+"-"+managerMQ.getColaSalida());
        MQBeanClient MiClaseMQ = new MQBeanClient(managerMQ.getMqManager(),managerMQ.getHost(),managerMQ.getCanal(),managerMQ.getPuerto(),managerMQ.getUserID(),managerMQ.getPass());
        //MQBeanClient MiClaseMQ = new MQBeanClient(managerMQ.getMqManager(),managerMQ.getHost(),managerMQ.getCanal(),managerMQ.getPuerto());

        MiClaseMQ.setQueue(managerMQ.getColaEntrada(),0);
        logger.debug("Se ingreso a la cola de entrada");
        MiClaseMQ.putMessage(sTramaEnvio);
        logger.debug("Se envio mensaje ...");

        MiClaseMQ.setQueue(managerMQ.getColaSalida(),1);
        logger.debug("Se conecto a la cola de salida");
        String sTramaRespuesta = MiClaseMQ.getMessage(managerMQ.getWait());
        logger.debug("Se recibio mensaje ...");
        
        MiClaseMQ.finalize();
        return sTramaRespuesta;
    }
	
}
