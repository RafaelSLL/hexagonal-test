package br.com.cloudnative.hexagonal.application.ports.out;

import br.com.cloudnative.hexagonal.application.core.domain.Client;

public interface InsertClientOutputPort {

    void insert(Client client);
}
