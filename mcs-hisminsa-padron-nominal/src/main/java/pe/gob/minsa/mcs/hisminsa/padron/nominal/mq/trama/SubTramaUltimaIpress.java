package pe.gob.minsa.mcs.hisminsa.padron.nominal.mq.trama;

/**
 *
 * @author jhuamanv
 */
public class SubTramaUltimaIpress extends SubTrama {

    public SubTramaUltimaIpress() {

        super.num_CamposSubTrama = 16;

        super.campoSubTrama[0] = new Campos();
        super.campoSubTrama[1] = new Campos();
        super.campoSubTrama[2] = new Campos();
        super.campoSubTrama[3] = new Campos();
        super.campoSubTrama[4] = new Campos();
        super.campoSubTrama[5] = new Campos();
        super.campoSubTrama[6] = new Campos();
        super.campoSubTrama[7] = new Campos();
        super.campoSubTrama[8] = new Campos();
        super.campoSubTrama[9] = new Campos();
        super.campoSubTrama[10] = new Campos();
        super.campoSubTrama[11] = new Campos();
        super.campoSubTrama[12] = new Campos();
        super.campoSubTrama[13] = new Campos();
        super.campoSubTrama[14] = new Campos();
        super.campoSubTrama[15] = new Campos();
//        super.campoSubTrama[16] = new Campos();
//        super.campoSubTrama[17] = new Campos();
//        super.campoSubTrama[18] = new Campos();
//        super.campoSubTrama[19] = new Campos();
//        super.campoSubTrama[20] = new Campos();
        /**
         * ************cabecera************
         */
        super.campoSubTrama[0].orden = 1;
        super.campoSubTrama[0].nombre = "version";
        super.campoSubTrama[0].atributo = "Alfanumerico";
        super.campoSubTrama[0].ubicacionByte = 0;
        super.campoSubTrama[0].longitud = 4;
        super.campoSubTrama[0].descripcion = "Version del servicio MQ";
        super.campoSubTrama[0].contenido = "";

        super.campoSubTrama[1].orden = 2;
        super.campoSubTrama[1].nombre = "lonCabecera";
        super.campoSubTrama[1].atributo = "Numerico";
        super.campoSubTrama[1].ubicacionByte = 0;
        super.campoSubTrama[1].longitud = 4;
        super.campoSubTrama[1].descripcion = "Longitud de la cabecera";
        super.campoSubTrama[1].contenido = "";
        
        super.campoSubTrama[2].orden = 3;
        super.campoSubTrama[2].nombre = "lonTotalTrama";
        super.campoSubTrama[2].atributo = "Numerico";
        super.campoSubTrama[2].ubicacionByte = 0;
        super.campoSubTrama[2].longitud = 9;
        super.campoSubTrama[2].descripcion = "Longitud total de la trama";
        super.campoSubTrama[2].contenido = "";

        super.campoSubTrama[3].orden = 4;
        super.campoSubTrama[3].nombre = "tipServicio";
        super.campoSubTrama[3].atributo = "Alfanumerico";
        super.campoSubTrama[3].ubicacionByte = 0;
        super.campoSubTrama[3].longitud = 1;
        super.campoSubTrama[3].descripcion = "Tipo de servicio";
        super.campoSubTrama[3].contenido = "";

//        super.campoSubTrama[4].orden = 5;
//        super.campoSubTrama[4].nombre = "fragmentacion";
//        super.campoSubTrama[4].atributo = "Alfanumerico";
//        super.campoSubTrama[4].ubicacionByte = 0;
//        super.campoSubTrama[4].longitud = 22;
//        super.campoSubTrama[4].descripcion = "Fragmentacion";
//        super.campoSubTrama[4].contenido = "";
//
//        super.campoSubTrama[5].orden = 6;
//        super.campoSubTrama[5].nombre = "ttl";
//        super.campoSubTrama[5].atributo = "Numerico";
//        super.campoSubTrama[5].ubicacionByte = 0;
//        super.campoSubTrama[5].longitud = 9;
//        super.campoSubTrama[5].descripcion = "Tiempo de vida del mensaje en la cola de respuesta";
//        super.campoSubTrama[5].contenido = "";

        super.campoSubTrama[4].orden = 5;
        super.campoSubTrama[4].nombre = "carVerificacion";
        super.campoSubTrama[4].atributo = "Alfanumerico";
        super.campoSubTrama[4].ubicacionByte = 0;
        super.campoSubTrama[4].longitud = 16;
        super.campoSubTrama[4].descripcion = "Caracteres de verificacion";
        super.campoSubTrama[4].contenido = "";
       
        super.campoSubTrama[5].orden = 6;
        super.campoSubTrama[5].nombre = "codInstitucionSolicitante";
        super.campoSubTrama[5].atributo = "Alfanumerico";
        super.campoSubTrama[5].ubicacionByte = 0;
        super.campoSubTrama[5].longitud = 10;
        super.campoSubTrama[5].descripcion = "Codigo de MINSA proporcionado por RENIEC";
        super.campoSubTrama[5].contenido = "";
        
        super.campoSubTrama[6].orden = 7;
        super.campoSubTrama[6].nombre = "codServidorReniec";
        super.campoSubTrama[6].atributo = "Alfanumerico";
        super.campoSubTrama[6].ubicacionByte = 0;
        super.campoSubTrama[6].longitud = 10;
        super.campoSubTrama[6].descripcion = "Codigo del servidor RENIEC que atendera la actualizacion";
        super.campoSubTrama[6].contenido = "";
        
        super.campoSubTrama[7].orden = 8;
        super.campoSubTrama[7].nombre = "tipActualizaEESS";
        super.campoSubTrama[7].atributo = "Alfanumerico";
        super.campoSubTrama[7].ubicacionByte = 0;
        super.campoSubTrama[7].longitud = 10;
        super.campoSubTrama[7].descripcion = "Codigo del establecimiento de salud de atencion que envia el HIS-MINSA";
        super.campoSubTrama[7].contenido = "";

        super.campoSubTrama[8].orden = 9;
        super.campoSubTrama[8].nombre = "reservadoCabecera";
        super.campoSubTrama[8].atributo = "Alfanumerico";
        super.campoSubTrama[8].ubicacionByte = 0;
        super.campoSubTrama[8].longitud = 10;
        super.campoSubTrama[8].descripcion = "Reservado";
        super.campoSubTrama[8].contenido = "";
        
//        super.campoSubTrama[10].orden = 11;
//        super.campoSubTrama[10].nombre = "sisIntitucionSolicitante";
//        super.campoSubTrama[10].atributo = "Alfanumerico";
//        super.campoSubTrama[10].ubicacionByte = 0;
//        super.campoSubTrama[10].longitud = 10;
//        super.campoSubTrama[10].descripcion = "Sistema que envia la actualizacion del establecimiento de salud de atencion del menor";
//        super.campoSubTrama[10].contenido = "";
//
//        super.campoSubTrama[11].orden = 12;
//        super.campoSubTrama[11].nombre = "usuFinalInstitucionSolicitante";
//        super.campoSubTrama[11].atributo = "Alfanumerico";
//        super.campoSubTrama[11].ubicacionByte = 0;
//        super.campoSubTrama[11].longitud = 10;
//        super.campoSubTrama[11].descripcion = "Usuario final de la institucion solicitante que realizo la actualizacion del EESS-Atencion";
//        super.campoSubTrama[11].contenido = "";
//
//        super.campoSubTrama[12].orden = 13;
//        super.campoSubTrama[12].nombre = "nomEquipoInstitucionSolictante";
//        super.campoSubTrama[12].atributo = "Alfanumerico";
//        super.campoSubTrama[12].ubicacionByte = 0;
//        super.campoSubTrama[12].longitud = 10;
//        super.campoSubTrama[12].descripcion = "Nombre del equipo del usuario final, donde se realizo la actualización del EESS-Atencion";
//        super.campoSubTrama[12].contenido = "";
//
//        

        /**
         * ******************consulta******************
         */
        super.campoSubTrama[9].orden = 10;
        super.campoSubTrama[9].nombre = "numDNI";
        super.campoSubTrama[9].atributo = "Alfanumerico";
        super.campoSubTrama[9].ubicacionByte = 0;
        super.campoSubTrama[9].longitud = 8;
        super.campoSubTrama[9].descripcion = "DNI del menor";
        super.campoSubTrama[9].contenido = "";

        super.campoSubTrama[10].orden = 11;
        super.campoSubTrama[10].nombre = "priApellido";
        super.campoSubTrama[10].atributo = "Alfanumerico";
        super.campoSubTrama[10].ubicacionByte = 0;
        super.campoSubTrama[10].longitud = 40;
        super.campoSubTrama[10].descripcion = "Apellido paterno";
        super.campoSubTrama[10].contenido = "";

        super.campoSubTrama[11].orden = 12;
        super.campoSubTrama[11].nombre = "segApellido";
        super.campoSubTrama[11].atributo = "Alfanumerico";
        super.campoSubTrama[11].ubicacionByte = 0;
        super.campoSubTrama[11].longitud = 40;
        super.campoSubTrama[11].descripcion = "Apellido materno";
        super.campoSubTrama[11].contenido = "";

        super.campoSubTrama[12].orden = 13;
        super.campoSubTrama[12].nombre = "prenombres";
        super.campoSubTrama[12].atributo = "Alfanumerico";
        super.campoSubTrama[12].ubicacionByte = 0;
        super.campoSubTrama[12].longitud = 60;
        super.campoSubTrama[12].descripcion = "Primer o segundo prenombre";
        super.campoSubTrama[12].contenido = "";
        
        super.campoSubTrama[13].orden = 14;
        super.campoSubTrama[13].nombre = "eessAtencion";
        super.campoSubTrama[13].atributo = "Alfanumerico";
        super.campoSubTrama[13].ubicacionByte = 0;
        super.campoSubTrama[13].longitud = 8;
        super.campoSubTrama[13].descripcion = "Codigo del establecimiento de salud de atencion";
        super.campoSubTrama[13].contenido = "";

        super.campoSubTrama[14].orden = 15;
        super.campoSubTrama[14].nombre = "fecActualizacion";
        super.campoSubTrama[14].atributo = "Alfanumerico";
        super.campoSubTrama[14].ubicacionByte = 0;
        super.campoSubTrama[14].longitud = 8;
        super.campoSubTrama[14].descripcion = "Fecha de actualizacion del registro";
        super.campoSubTrama[14].contenido = "";

        super.campoSubTrama[15].orden = 16;
        super.campoSubTrama[15].nombre = "reservadoConsulta";
        super.campoSubTrama[15].atributo = "Alfanumerico";
        super.campoSubTrama[15].ubicacionByte = 0;
        super.campoSubTrama[15].longitud = 6;
        super.campoSubTrama[15].descripcion = "Reservado para uso futuro";
        super.campoSubTrama[15].contenido = "";
    }

    public void generaSubTramaIn(String version, String lonCabecera, String tipServicio, String lonTotalTrama, String fragmentacion, String ttl,
                                 String tipAtencionEESS,String carVerificacion,String codInstitucionSolicitante,String codServidorReniec,
                                 String sisIntitucionSolicitante, String usuFinalInstitucionSOlicitante,String nopEquipoInstitucionSolictante,
                                 String reservadoCabecera, String numDNI, String priApellido, String segApellido, String prenombres, String eessAtencion,
                                 String fecActualizacion,String reservadoConsulta) {
        super.campoSubTrama[0].contenido = version;
        super.campoSubTrama[1].contenido = lonCabecera;
        super.campoSubTrama[2].contenido = lonTotalTrama;
        super.campoSubTrama[3].contenido = tipServicio;
//        super.campoSubTrama[4].contenido = fragmentacion;
//        super.campoSubTrama[5].contenido = ttl;
        super.campoSubTrama[4].contenido = carVerificacion;
        super.campoSubTrama[5].contenido = codInstitucionSolicitante;
        super.campoSubTrama[6].contenido = codServidorReniec;
        super.campoSubTrama[7].contenido = sisIntitucionSolicitante;
//        super.campoSubTrama[10].contenido = tipAtencionEESS;
//        super.campoSubTrama[11].contenido = usuFinalInstitucionSOlicitante;
//        super.campoSubTrama[12].contenido = nopEquipoInstitucionSolictante;
        super.campoSubTrama[8].contenido = reservadoCabecera;
        super.campoSubTrama[9].contenido = numDNI;
        super.campoSubTrama[10].contenido = priApellido;
        super.campoSubTrama[11].contenido = segApellido;
        super.campoSubTrama[12].contenido = prenombres;
        super.campoSubTrama[13].contenido = eessAtencion;
        super.campoSubTrama[14].contenido = fecActualizacion;
        super.campoSubTrama[15].contenido = reservadoConsulta;
    }
}
