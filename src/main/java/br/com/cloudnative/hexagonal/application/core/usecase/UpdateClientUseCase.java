package br.com.cloudnative.hexagonal.application.core.usecase;

import br.com.cloudnative.hexagonal.application.core.domain.Client;
import br.com.cloudnative.hexagonal.application.ports.in.FindClientByIdInputPort;
import br.com.cloudnative.hexagonal.application.ports.in.UpdateClientInputPort;
import br.com.cloudnative.hexagonal.application.ports.out.UpdateClientOutputPort;

public class UpdateClientUseCase implements UpdateClientInputPort {

    private final FindClientByIdInputPort findClientByIdInputPort;

    private final UpdateClientOutputPort updateClientOutputPort;

    public UpdateClientUseCase(
            FindClientByIdInputPort findClientByIdInputPort,
            UpdateClientOutputPort updateClientOutputPort
    ){
        this.findClientByIdInputPort = findClientByIdInputPort;
        this.updateClientOutputPort = updateClientOutputPort;
    }

    @Override
    public void update(Client client) {
        Client clientUpdate = findClientByIdInputPort.find(client.getId());

        clientUpdate.setName(client.getName());
        clientUpdate.setEmail(client.getEmail());
        clientUpdate.setCpf(client.getCpf());

        updateClientOutputPort.update(clientUpdate);
    }
}
