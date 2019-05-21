package pe.gob.minsa.mcs.hisminsa.padron.nominal.mq.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

/**
 *
 * @author jhuamanv
 */
@Component
//@PropertySource("classpath:application.properties")
@PropertySources({
    @PropertySource("mcs-hisminsa-padron-nominal.properties"),
    @PropertySource(value = "file:/opt/data/mcs-minsa/properties/mcs-hisminsa-padron-nominal.properties", ignoreResourceNotFound = true)
})
public class ManagerMQ {
	@Value("${mq.hostname}")
    private String host;
	@Value("${mq.channel}")
    private String canal;
    @Value("${mq.queuemanager}")
    private String mqManager;
    @Value("${mq.input}")
    private String colaEntrada;
    @Value("${mq.output}")
    private String colaSalida;
    @Value("${mq.port}")
    private int puerto;
    @Value("${mq.userid}")
    private String userID;
    @Value("${mq.pass}")
    private String pass;
    @Value("${mq.wait}")
    private int wait;

    public ManagerMQ() {
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getMqManager() {
        return mqManager;
    }

    public void setMqManager(String mqManager) {
        this.mqManager = mqManager;
    }

    public String getColaEntrada() {
        return colaEntrada;
    }

    public void setColaEntrada(String colaEntrada) {
        this.colaEntrada = colaEntrada;
    }

    public String getColaSalida() {
        return colaSalida;
    }

    public void setColaSalida(String colaSalida) {
        this.colaSalida = colaSalida;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getWait() {
        return wait;
    }

    public void setWait(int wait) {
        this.wait = wait;
    }
}
