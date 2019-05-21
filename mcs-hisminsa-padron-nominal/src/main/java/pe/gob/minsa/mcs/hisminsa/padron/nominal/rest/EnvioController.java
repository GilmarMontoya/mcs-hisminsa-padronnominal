package pe.gob.minsa.mcs.hisminsa.padron.nominal.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pe.gob.minsa.mcs.hisminsa.padron.nominal.entity.ActualizaEntity;
import pe.gob.minsa.mcs.hisminsa.padron.nominal.service.imp.EnvioServiceImpl;

@RestController
@RequestMapping("/actualizacion/v1.0")
@Api(tags = {"Padron Nominal"})
@SwaggerDefinition(tags = {
    @Tag(name = "Ultima IPRESS de Atencion", description = "Envia la ultima IPRESS de Atencion registrado en el HISMINSA")
})
public class EnvioController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private EnvioServiceImpl envioServiceImpl;

    @ApiOperation(value = "Ultima IPRESS de Atencion")
    @GetMapping(value = "/ultima-ipress-atencion", produces = "application/json; charset=UTF-8")
    public ResponseEntity<String> ultimaIpressAtencion(){
    	HttpStatus httpStatus = HttpStatus.OK;
    	String sRespuesta = envioServiceImpl.ActualizaIpress();
        return new ResponseEntity<String>(sRespuesta, httpStatus);
    }

    @ApiOperation(value = "Ultima IPRESS de Atencion")
    @PostMapping(value = "/ultima-ipress-atencion", produces = "application/json; charset=UTF-8")
    public ResponseEntity<String> ultimaIpressAtencionOld(@RequestBody ActualizaEntity request) throws IOException {
    	HttpStatus httpStatus = HttpStatus.OK;
    	String sRespuesta = envioServiceImpl.ActualizaIpressProperties(request);
        return new ResponseEntity<String>(sRespuesta, httpStatus);
    }
    
	@ApiOperation(value = "Realiza una consulta dammy",response = String.class)
	@GetMapping(value="/demo", produces = "application/json; charset=UTF-8")
	public ResponseEntity<String> consultaDemo(){
		logger.debug("Llego al dummy");
		HttpStatus httpStatus = HttpStatus.OK;
		String sRespuesta = "Llego al servicio";
		return new ResponseEntity<String>(sRespuesta, httpStatus);
	}

}
