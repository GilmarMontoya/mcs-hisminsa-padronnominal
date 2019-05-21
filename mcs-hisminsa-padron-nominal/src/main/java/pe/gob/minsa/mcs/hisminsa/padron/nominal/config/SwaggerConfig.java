package pe.gob.minsa.mcs.hisminsa.padron.nominal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import springfox.documentation.spring.web.plugins.Docket;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket defApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                   .select()                 
                   .apis(RequestHandlerSelectors.basePackage("pe.gob.minsa.mcs.hisminsa.padron.nominal"))
                   .paths(regex("/actualizacion/v1.0.*"))
                   .build()
                   .apiInfo(metaData());
    }
    private ApiInfo metaData() {
        return new ApiInfoBuilder()
        		.title("Servicio de integracion HISMINSA - Padron Nominal")
                .description("Ultima IPRESS de Atención en el HISMINSA")
                .termsOfServiceUrl("Terminos del servicio")
                .version("1.0.0")
                .contact(new Contact("OIDT-OGTI/MINSA", "http://www.minsa.gob.pe", "jhuamanv@minsa.gob.pe"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
}
