package br.com.cloudnative.hexagonal.config;

import br.com.cloudnative.hexagonal.application.core.usecase.DeleteClientUseCase;
import br.com.cloudnative.hexagonal.application.ports.in.DeleteClientInputPort;
import br.com.cloudnative.hexagonal.application.ports.in.FindClientByIdInputPort;
import br.com.cloudnative.hexagonal.application.ports.out.DeleteClientOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteClientConfig {

    @Bean
    public DeleteClientInputPort deleteClientInputPort(
            FindClientByIdInputPort findClientByIdInputPort,
            DeleteClientOutputPort deleteClientOutputPort
    ){
        return new DeleteClientUseCase(findClientByIdInputPort, deleteClientOutputPort);
    }
}
