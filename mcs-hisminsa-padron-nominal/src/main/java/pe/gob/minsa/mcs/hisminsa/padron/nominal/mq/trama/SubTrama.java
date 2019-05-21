package pe.gob.minsa.mcs.hisminsa.padron.nominal.mq.trama;

import org.slf4j.Logger;
//import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Jose Luis Huaman Villar
 * @version 1.0.0
 */
public class SubTrama {

    int num_CamposSubTrama = 21;
    int longitud_SubTrama = 1000;
    String contenidoSubTrama = "";
    String codigoErrorSubtrama = "0000";
    Campos[] campoSubTrama = new Campos[120];

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void recibeContenidoSubTrama(String SubTramaEntradaTotal) {
        contenidoSubTrama = SubTramaEntradaTotal;
    }

    public String procesaSubTrama() {
        fijaLongitud();
        if (longitud_SubTrama <= contenidoSubTrama.length()) {
            for (int i = 0; i < num_CamposSubTrama; i++) {
                ///Crea la trama
                if (i == 0) {
                    campoSubTrama[i].ubicacionByte = 0;
                    campoSubTrama[i].orden = 1;
                } else {
                    campoSubTrama[i].ubicacionByte = campoSubTrama[i - 1].ubicacionByte + campoSubTrama[i - 1].longitud;
                    campoSubTrama[i].orden = i + 1;
                }
                longitud_SubTrama = campoSubTrama[i].ubicacionByte + campoSubTrama[i].longitud;
                campoSubTrama[i].llenaCampo(contenidoSubTrama);
            }
        } else {
            codigoErrorSubtrama = "5100";
            logger.error("--> [Error 5100]SubTrama.procesaSubTrama - Longitud SubTrama Invalida");
        }
        String tramaFinal = contenidoSubTrama;
        return tramaFinal;
    }

    public String returnComoString() {
        String cadena = "";
        for (int i1 = 0; i1 < num_CamposSubTrama; i1++) {
            cadena = cadena + campoSubTrama[i1].contenido;
        }
        return cadena;
    }

    public void imprimecampos() {
        int ini_ = 0;
        int fin_ = num_CamposSubTrama;
        for (int c_ont_aux = ini_; c_ont_aux < fin_; c_ont_aux++) {
            campoSubTrama[c_ont_aux].imprimeContenido();
        }
    }

    public void completaLongitud() {
        int ini_ = 0;
        int fin_ = num_CamposSubTrama;
        for (int c_ont_aux = ini_; c_ont_aux < fin_; c_ont_aux++) {
            campoSubTrama[c_ont_aux].completaLongitud();
        }
        //log.error(c_ont_aux);
    }

    public void fijaLongitud() {
        longitud_SubTrama = 0;
        for (int i = 0; i < num_CamposSubTrama; i++) {
            longitud_SubTrama = longitud_SubTrama + campoSubTrama[i].longitud;
        }
    }

    public String getCampoSubTrama(int pos) {
        return campoSubTrama[pos].contenido.trim();
    }

    public void setCodigoErrorSubtrama(String error) {
        this.codigoErrorSubtrama = error;
    }

    public String getCodigoErrorSubtrama() {
        return this.codigoErrorSubtrama;
    }
}
