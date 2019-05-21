package pe.gob.minsa.mcs.hisminsa.padron.nominal;

import java.io.IOException;
//import org.apache.log4j.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class McsPadronNominalApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(McsPadronNominalApplication.class, args);
    }
}
