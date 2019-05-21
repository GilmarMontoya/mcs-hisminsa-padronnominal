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
public class ManagerMQPadron {
	@Value("${reniec.nuversion}")
    private String nuVersion;
	@Value("${reniec.locabecera}")
    private String loCabecera;
	@Value("${reniec.tiservicio}")
    private String tiServicio;
	@Value("${reniec.lotottrama}")
    private String loTotTrama;
	@Value("${reniec.ttl}")
    private String deTtl;
	@Value("${reniec.caverificacion}")
    private String caVerificacion;
    @Value("${reniec.coinstitucion}")
    private String coInstitucion;
    @Value("${reniec.coserreniec}")
    private String coSerReniec;

    public ManagerMQPadron() {
    }

    public String getNuVersion() {
        return nuVersion;
    }

    public void setNuVersion(String nuVersion) {
        this.nuVersion = nuVersion;
    }

    public String getLoCabecera() {
        return loCabecera;
    }

    public void setLoCabecera(String loCabecera) {
        this.loCabecera = loCabecera;
    }

    public String getTiServicio() {
        return tiServicio;
    }

    public void setTiServicio(String tiServicio) {
        this.tiServicio = tiServicio;
    }

    public String getLoTotTrama() {
        return loTotTrama;
    }

    public void setLoTotTrama(String loTotTrama) {
        this.loTotTrama = loTotTrama;
    }

    public String getDeTtl() {
        return deTtl;
    }

    public void setDeTtl(String deTtl) {
        this.deTtl = deTtl;
    }

    public String getCaVerificacion() {
        return caVerificacion;
    }

    public void setCaVerificacion(String caVerificacion) {
        this.caVerificacion = caVerificacion;
    }

    public String getCoInstitucion() {
        return coInstitucion;
    }

    public void setCoInstitucion(String coInstitucion) {
        this.coInstitucion = coInstitucion;
    }

    public String getCoSerReniec() {
        return coSerReniec;
    }

    public void setCoSerReniec(String coSerReniec) {
        this.coSerReniec = coSerReniec;
    }

	@Override
	public String toString() {
		return "ManagerMQPadron [nuVersion=" + nuVersion + ", loCabecera=" + loCabecera + ", tiServicio=" + tiServicio
				+ ", loTotTrama=" + loTotTrama + ", deTtl=" + deTtl + ", caVerificacion=" + caVerificacion
				+ ", coInstitucion=" + coInstitucion + ", coSerReniec=" + coSerReniec + "]";
	}

}
