package br.com.cloudnative.hexagonal.application.ports.out;

import br.com.cloudnative.hexagonal.application.core.domain.Client;

import java.util.Optional;

public interface FindClientByIdOutputPort {

    Optional<Client> find(Long id);
}
