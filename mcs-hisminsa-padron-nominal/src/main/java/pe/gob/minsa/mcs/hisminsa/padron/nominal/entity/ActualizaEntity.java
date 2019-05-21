package pe.gob.minsa.mcs.hisminsa.padron.nominal.entity;

import java.io.Serializable;

public class ActualizaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String idCita;
	private String numDni;
    private String priApellido;
    private String segApellido;
    private String preNombres;
    private String eessAtencion;
    private String fecActualiza;
	private String fgEstado;
	private String idEnvio;
	private String fecEnvio;
	private String repEnvio;
    
	public ActualizaEntity() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdCita() {
		return idCita;
	}

	public void setIdCita(String idCita) {
		this.idCita = idCita;
	}

	public String getNumDni() {
		return numDni;
	}

	public void setNumDni(String numDni) {
		this.numDni = numDni;
	}

	public String getPriApellido() {
		return priApellido;
	}

	public void setPriApellido(String priApellido) {
		this.priApellido = priApellido;
	}

	public String getSegApellido() {
		return segApellido;
	}

	public void setSegApellido(String segApellido) {
		this.segApellido = segApellido;
	}

	public String getPreNombres() {
		return preNombres;
	}

	public void setPreNombres(String preNombres) {
		this.preNombres = preNombres;
	}

	public String getEessAtencion() {
		return eessAtencion;
	}

	public void setEessAtencion(String eessAtencion) {
		this.eessAtencion = eessAtencion;
	}

	public String getFecActualiza() {
		return fecActualiza;
	}

	public void setFecActualiza(String fecActualiza) {
		this.fecActualiza = fecActualiza;
	}

	public String getFgEstado() {
		return fgEstado;
	}

	public void setFgEstado(String fgEstado) {
		this.fgEstado = fgEstado;
	}

	public String getIdEnvio() {
		return idEnvio;
	}

	public void setIdEnvio(String idEnvio) {
		this.idEnvio = idEnvio;
	}

	public String getFecEnvio() {
		return fecEnvio;
	}

	public void setFecEnvio(String fecEnvio) {
		this.fecEnvio = fecEnvio;
	}

	public String getRepEnvio() {
		return repEnvio;
	}

	public void setRepEnvio(String repEnvio) {
		this.repEnvio = repEnvio;
	}

	@Override
	public String toString() {
		return "ActualizaRequest [id=" + id + ", idCita=" + idCita + ", numDni=" + numDni + ", priApellido="
				+ priApellido + ", segApellido=" + segApellido + ", preNombres=" + preNombres + ", eessAtencion="
				+ eessAtencion + ", fecActualiza=" + fecActualiza + ", fgEstado=" + fgEstado + ", idEnvio=" + idEnvio
				+ ", fecEnvio=" + fecEnvio + ", repEnvio=" + repEnvio + "]";
	}
}
