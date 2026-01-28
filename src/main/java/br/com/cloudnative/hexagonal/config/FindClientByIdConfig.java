package br.com.cloudnative.hexagonal.config;

import br.com.cloudnative.hexagonal.application.core.usecase.FindClientByIdUseCase;
import br.com.cloudnative.hexagonal.application.ports.in.FindClientByIdInputPort;
import br.com.cloudnative.hexagonal.application.ports.out.FindClientByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindClientByIdConfig {

    @Bean
    public FindClientByIdInputPort findClientByIdInputPort(
            FindClientByIdOutputPort findClientByIdOutputPort
    ){
        return new FindClientByIdUseCase(findClientByIdOutputPort);
    }
}
