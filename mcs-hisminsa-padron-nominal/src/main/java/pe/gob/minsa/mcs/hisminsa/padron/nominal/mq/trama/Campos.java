package pe.gob.minsa.mcs.hisminsa.padron.nominal.mq.trama;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import org.apache.log4j.Logger;

/**
 *
 * @author Jose Luis Huaman Villar
 * @version 1.0.0
 */

public class Campos {
    String nombre="";
    String atributo="";
    int orden=0; //Orden de posicion en la trama
    int ubicacionByte=0; //posicion en la trama comenzando desde el byte 0
    int longitud=0;
    String descripcion="";

    String contenido="";
    String funcion="";

    //private final static Logger log = Logger.getLogger(Campos.class);
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    void imprimeContenido(){
        char bitIni='.';
        char bitFin='.';
        logger.debug("(" + orden + ")" + nombre +  "(" + atributo + ")" + "[" + ubicacionByte + "]"+ ":[" + longitud + "]" +  bitIni + contenido + bitFin);
        //System.out.println("(" + orden + ")" + nombre +  "(" + atributo + ")" + "[" + ubicacionByte + "]"+ ":[" + longitud + "]" +  bitIni + contenido + bitFin);
    }

    void llenaCampo(String TramaLlegada){
        contenido=TramaLlegada.substring(ubicacionByte,ubicacionByte+longitud);
    }
    
    void completaLongitud() {
        int longitudReal=0;
        char vacio=' ';
        
        if(contenido == null) longitudReal=0;
        else longitudReal=contenido.length();
        
        if (longitud < longitudReal || contenido == null) {
            if(atributo.equals("Numerico")) contenido= "0";
            else if(atributo.equals("Alfanumerico")) contenido= "";
        }
                   
        for (int c_ont_aux= 0; c_ont_aux < longitud - longitudReal; c_ont_aux++){
            if(atributo.equals("Numerico")){
                vacio='0';
                contenido= vacio+contenido;
            }else if(atributo.equals("Alfanumerico")){
                vacio=' ';
                contenido= contenido+vacio;
            }
        }       
    }
}
