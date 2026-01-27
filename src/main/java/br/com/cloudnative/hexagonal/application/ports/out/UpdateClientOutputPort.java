package br.com.cloudnative.hexagonal.application.ports.out;

import br.com.cloudnative.hexagonal.application.core.domain.Client;

public interface UpdateClientOutputPort {

    void update(Client client);
}
