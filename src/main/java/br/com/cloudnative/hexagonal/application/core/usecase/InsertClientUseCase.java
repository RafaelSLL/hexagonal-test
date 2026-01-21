package br.com.cloudnative.hexagonal.application.core.usecase;

import br.com.cloudnative.hexagonal.application.core.domain.Client;
import br.com.cloudnative.hexagonal.application.ports.in.InsertClientInputPort;
import br.com.cloudnative.hexagonal.application.ports.out.InsertClientOutputPort;

public class InsertClientUseCase implements InsertClientInputPort {

    private final InsertClientOutputPort insertClientOutputPort;

    public InsertClientUseCase(InsertClientOutputPort insertClientOutputPort){
        this.insertClientOutputPort = insertClientOutputPort;
    }

    @Override
    public void insert(Client client) {
        insertClientOutputPort.insert(client);
    }
}
