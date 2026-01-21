package br.com.cloudnative.hexagonal.config;

import br.com.cloudnative.hexagonal.application.core.usecase.InsertClientUseCase;
import br.com.cloudnative.hexagonal.application.ports.in.InsertClientInputPort;
import br.com.cloudnative.hexagonal.application.ports.out.InsertClientOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertClientConfig {

    @Bean
    public InsertClientInputPort insertClientInputPort(InsertClientOutputPort outputPort) {
        return new InsertClientUseCase(outputPort);
    }
}
