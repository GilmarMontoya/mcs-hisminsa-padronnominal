package pe.gob.minsa.mcs.hisminsa.padron.nominal.mq.config;

    
public class MQBeanClient extends MQBean {
            
	private static final long serialVersionUID = 1L;

	public MQBeanClient(String theQM) {
        setQManager(theQM);
    }

    public MQBeanClient(String theQM, String theHostname, String theChannel, int thePort) {
        setClientEnv(theHostname, theChannel, thePort);
        setQManager(theQM);
    }
    
    public MQBeanClient(String theQM, String theHostname, String theChannel, int thePort, String theUser, String thePass) {
        setClientEnv(theHostname, theChannel, thePort, theUser, thePass);
        setQManager(theQM);
    }
            
    @Override
    public void putMessage(String message) {
        super.putMessage(message);
    }

    @Override
    public String getMessage(int pWait) {
        String mensaje = super.getMessage(pWait);
        return mensaje;
    }

    public String transferir(String message, String inQ, String outQ, int pWait) {
        this.setQueue(inQ,0);
        this.putMessage(message);
        this.setQueue(outQ,1);
        return getMessage(pWait);
     }

    public  void finalize() { 
        closeQueue();
        closeQManager();
    }
}
