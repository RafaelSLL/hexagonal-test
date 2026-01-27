package br.com.cloudnative.hexagonal.application.ports.in;

import br.com.cloudnative.hexagonal.application.core.domain.Client;

public interface FindClientByIdInputPort {

    Client find(Long id);
}
