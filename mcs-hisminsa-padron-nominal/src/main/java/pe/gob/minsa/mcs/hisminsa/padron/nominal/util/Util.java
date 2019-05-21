package pe.gob.minsa.mcs.hisminsa.padron.nominal.util;

public class Util {

    public String castFecha(String sFecha) throws Exception {
        String resFecha = "", sAnio = "", sMes = "", sDia = "";
        if (sFecha.trim() != null) {
            sAnio = sFecha.substring(0, 4);
            sMes = sFecha.substring(5, 7);
            sDia = sFecha.substring(8, 10);
            resFecha = sDia + "/" + sMes + "/" + sAnio;
        }
        return resFecha;
    }

    public String validarNumeroEnvio(String sNumeroEnvio) throws Exception {
        String validaCampo;
        if (sNumeroEnvio == null || sNumeroEnvio.length() != 2 || sNumeroEnvio.equals("")) {
            validaCampo = "0001";
        } else {
            validaCampo = "0000";
        }
        return validaCampo;
    }

    public String castFechaHora(String sFechaHora) throws Exception {
        String resFecha = "", sAnio = "", sMes = "", sDia = "", resHora = "", resFechaHora = "";
        if (sFechaHora.trim() != null) {
            //dando forma fecha
            sAnio = sFechaHora.substring(0, 4);
            sMes = sFechaHora.substring(5, 7);
            sDia = sFechaHora.substring(8, 10);
            resFecha = sDia + "/" + sMes + "/" + sAnio;
            //dando forma hora
            resHora = sFechaHora.substring(11, 16);
            //--
            resFechaHora = resFecha + " " + resHora;
        }
        return resFechaHora;
    }

    /*public String validarLongitudDatos(EnvioBean envioBean) throws Exception {
        String validaCampo;
        //cabecera
        if (envioBean.getCabecera().getVersion().length()> 4) { validaCampo = "0010";
        } else if (envioBean.getCabecera().getLonCabecera().length()> 4) { validaCampo = "0020";
        } else if (envioBean.getCabecera().getTipServicio().length()> 3) { validaCampo = "0030";
        } else if (envioBean.getCabecera().getLonTotalTrama().length()> 9) { validaCampo = "0040";
        } else if (envioBean.getCabecera().getFragmentacion().length()> 22) { validaCampo = "0050";
        } else if (envioBean.getCabecera().getTtl().length()> 9) { validaCampo = "0060";
        } else if (envioBean.getCabecera().getTipAtencionEESS().length()> 1) { validaCampo = "0070";
        } else if (envioBean.getCabecera().getCarVerificacion().length()> 16) { validaCampo = "0080";
        } else if (envioBean.getCabecera().getCodInstitucionSolicitante().length()> 10) { validaCampo = "0090";
        } else if (envioBean.getCabecera().getCodServidorReniec().length()> 10) { validaCampo = "0100";
        } else if (envioBean.getCabecera().getSisIntitucionSolicitante().length()> 10) { validaCampo = "0110";
        } else if (envioBean.getCabecera().getUsuFinalInstitucionSOlicitante().length()> 10) { validaCampo = "0120";
        } else if (envioBean.getCabecera().getNomEquipoInstitucionSolictante().length()> 10) { validaCampo = "0130";
        } else if (envioBean.getCabecera().getReservadoCabecera().length()> 10) { validaCampo = "0140";
        // datos
        } else if (envioBean.getDatosConsulta().getNumDNI().length()> 8) { validaCampo = "0150";
        } else if (envioBean.getDatosConsulta().getPriApellido().length()> 40) { validaCampo = "0160";
        } else if (envioBean.getDatosConsulta().getSegApellido().length()> 40) { validaCampo = "0170";
        } else if (envioBean.getDatosConsulta().getPrenombres().length()> 60) { validaCampo = "0180";
        } else if (envioBean.getDatosConsulta().getEessAtencion().length()> 8) { validaCampo = "0190";
        } else if (envioBean.getDatosConsulta().getFecActualizacion().length()> 8) { validaCampo = "0200";
        } else if (envioBean.getDatosConsulta().getReservadoConsulta().length()> 6) { validaCampo = "0210";
        } else { validaCampo = "0000";
    	}
    	return validaCampo ;
	}*/
}
