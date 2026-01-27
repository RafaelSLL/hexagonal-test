package br.com.cloudnative.hexagonal.application.core.usecase;

import br.com.cloudnative.hexagonal.application.core.domain.Client;
import br.com.cloudnative.hexagonal.application.ports.in.FindClientByIdInputPort;
import br.com.cloudnative.hexagonal.application.ports.out.FindClientByIdOutputPort;
import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class FindClientByIdUseCase implements FindClientByIdInputPort {

    private final FindClientByIdOutputPort findClientByIdOutputPort;

    public FindClientByIdUseCase(FindClientByIdOutputPort findClientByIdOutputPort){
        this.findClientByIdOutputPort = findClientByIdOutputPort;
    }

    public Client find(Long id) {
        return findClientByIdOutputPort.find(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }
}
