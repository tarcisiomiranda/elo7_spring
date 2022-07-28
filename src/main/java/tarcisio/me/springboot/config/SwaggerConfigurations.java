package tarcisio.me.springboot.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            // .host("https://sonda.tarcisio.me")
            .groupName("Sonda Trip")
            .select()
            .apis(RequestHandlerSelectors.basePackage("tarcisio.me.springboot"))
            .paths(PathSelectors.ant("/**"))
            .build();
    }
    
}
