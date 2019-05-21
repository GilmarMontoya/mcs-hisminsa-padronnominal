package pe.gob.minsa.mcs.hisminsa.padron.nominal.mq.config;

import java.io.*;
import com.ibm.mq.*;
import com.ibm.mq.constants.MQConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MQBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private MQQueueManager QManager;
    private MQQueue Queue;
    private MQMessage mqmessage1 = null;
    private MQMessage mqmessage = null;
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void closeQManager() {
        try {
            QManager.disconnect(); // Cerramos las conexion al QManager
        } catch (MQException mqe) {
            logger.error("Error closeQManager:"+mqe.getMessage());
        }
    }
    
    public void closeQueue(){
        try {
            Queue.close(); // Cerramos la Cola
        } catch (MQException mqe) {
            logger.error("Error closeQueue:"+mqe.getMessage());
        }
    }

    public String getMessage(int pWait) {
        logger.debug("Inicio de obtener mensaje");
        try {
            mqmessage1 = new MQMessage(); // Crear el Mensaje para leer un formato UTF
            MQGetMessageOptions gmo = new MQGetMessageOptions();
            gmo.matchOptions = MQConstants.MQMO_MATCH_MSG_ID;
            gmo.options = MQConstants.MQGMO_WAIT;
            
            if(pWait==0) gmo.waitInterval = MQConstants.MQWI_UNLIMITED;
            else gmo.waitInterval = pWait;
            
            //mqmessage1.messageId = mqmessage.messageId;
            Queue.get(mqmessage1, gmo); // Obtener el mensaje de la Cola con las opciones indicadas
            String mensaje = mqmessage1.readStringOfByteLength(mqmessage1.getDataLength());
            mqmessage1 = null;
            return mensaje;
            
        } catch (MQException e) {
            if (e.reasonCode==2033){
                logger.error("No se obtuvo respuesta durante el tiempo de espera");
                return null;
            } else {
                logger.error("Error de MQ #" + new Integer(e.reasonCode).toString()+ " al tratar de recoger el mensaje");
                return null;
            }
        } catch (Exception e) {
            logger.error("Error getMessage:"+e.getMessage());
            return null;
        } finally {
            logger.debug("Fin de obtener mensaje");
        }
    }

    public void setClientEnv(String thehostname, String thechannel, int theport) {
        MQEnvironment.hostname = thehostname;
        MQEnvironment.channel = thechannel;
        MQEnvironment.port = theport; //1418;

        int certif=0;
        if(certif==1) MQEnvironment.sslCipherSuite="SSL_RSA_WITH_NULL_MD5";
    }
    
    public void setClientEnv(String thehostname, String thechannel, int theport, String theuser, String thepass) {
        logger.debug("Inicio seteo de parametros del host, canal, puerto, usuario, password");
        MQEnvironment.hostname = thehostname;
        MQEnvironment.channel = thechannel;
        MQEnvironment.port = theport;
        MQEnvironment.userID = theuser;
        MQEnvironment.password = thepass;

        int certif=0;
        if(certif==1) MQEnvironment.sslCipherSuite="SSL_RSA_WITH_NULL_MD5";
        logger.debug("Fin seteo de parametros del host, canal, puerto, usuario, password");
    }

    public void setQManager(String qmanager) {
        logger.debug("Inicio de seteo de qmanager");
        try {
            QManager = new MQQueueManager(qmanager); // Crea una conexion al QManager
        } catch (MQException mqe) {
            logger.error("Error setQManager:"+mqe.getMessage());
        }
        logger.debug("Fin de seteo de qmanager");
    }
    
    public void setQueue(String queue, int flag) {
        logger.debug("Inicio de seteo de cola "+queue);
        try {
            int openOptions = 0; //int openOptions = MQConstants.MQOO_INPUT_AS_Q_DEF | MQConstants.MQOO_OUTPUT;
            if (flag==0) {
                openOptions = MQConstants.MQOO_OUTPUT;
            }else if(flag==1){
                openOptions = MQConstants.MQOO_INPUT_AS_Q_DEF;
            }
            Queue = QManager.accessQueue(queue, openOptions); // Especificar la Cola que deseamos Abrir y las Opciones
        } catch (MQException mqe) {
            logger.error("Error setQueue:"+mqe);
        }
        logger.debug("Fin de seteo de cola "+queue);
    }
        
    public void setQueueRemote(String queue) {
        try {
            int openOptions = MQConstants.MQOO_OUTPUT; // int openOptions = MQConstants.MQOO_INPUT_AS_Q_DEF | MQConstants.MQOO_OUTPUT;
            Queue = QManager.accessQueue(queue, openOptions); // Especificar la Cola que deseamos abrir y las opciones
        } catch (MQException mqe) {
            logger.error("Error setQueueRemote:"+mqe);
        }
    }

    public void putMessage(String message) {
        logger.debug("Inicio de colocar mensaje");
        try {
            mqmessage = null; // Crear el Mensaje y escribir uno  
            mqmessage = new MQMessage();
            //mqmessage.format = MQConstants.MQFMT_STRING;
            mqmessage.writeString(message);
            mqmessage.messageId = MQConstants.MQSID_NONE;
            MQPutMessageOptions pmo = new MQPutMessageOptions();
            Queue.put(mqmessage, pmo);
        } catch (IOException | MQException e) {
            logger.error("Error putMessage:"+e);
        }
        logger.debug("Fin de colocar mensaje");
    }
}
