package br.com.cloudnative.hexagonal.application.core.usecase;

import br.com.cloudnative.hexagonal.application.ports.in.DeleteClientInputPort;
import br.com.cloudnative.hexagonal.application.ports.in.FindClientByIdInputPort;
import br.com.cloudnative.hexagonal.application.ports.out.DeleteClientOutputPort;

public class DeleteClientUseCase implements DeleteClientInputPort {

    private final FindClientByIdInputPort findClientByIdInputPort;

    private final DeleteClientOutputPort deleteClientOutputPort;

    public DeleteClientUseCase(
            FindClientByIdInputPort findClientByIdInputPort,
            DeleteClientOutputPort deleteClientOutputPort
    ){
        this.findClientByIdInputPort = findClientByIdInputPort;
        this.deleteClientOutputPort = deleteClientOutputPort;
    }

    @Override
    public void delete(Long id) {
        findClientByIdInputPort.find(id);
        deleteClientOutputPort.delete(id);
    }
}
