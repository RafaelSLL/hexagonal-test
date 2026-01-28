package br.com.cloudnative.hexagonal.config;

import br.com.cloudnative.hexagonal.application.core.usecase.UpdateClientUseCase;
import br.com.cloudnative.hexagonal.application.ports.in.FindClientByIdInputPort;
import br.com.cloudnative.hexagonal.application.ports.in.UpdateClientInputPort;
import br.com.cloudnative.hexagonal.application.ports.out.FindClientByIdOutputPort;
import br.com.cloudnative.hexagonal.application.ports.out.UpdateClientOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateClientConfig {

    @Bean
    public UpdateClientInputPort updateClientInputPort(
            UpdateClientOutputPort updateClientOutputPort,
            FindClientByIdInputPort findClientByIdInputPort
    ){
        return new UpdateClientUseCase(findClientByIdInputPort, updateClientOutputPort);
    }
}
