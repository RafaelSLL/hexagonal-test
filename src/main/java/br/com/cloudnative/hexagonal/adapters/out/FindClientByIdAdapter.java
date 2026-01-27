package br.com.cloudnative.hexagonal.adapters.out;

import br.com.cloudnative.hexagonal.adapters.out.repository.ClientRepository;
import br.com.cloudnative.hexagonal.adapters.out.repository.entity.ClientEntity;
import br.com.cloudnative.hexagonal.adapters.out.repository.mapper.ClientEntityMapper;
import br.com.cloudnative.hexagonal.application.core.domain.Client;
import br.com.cloudnative.hexagonal.application.ports.out.FindClientByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindClientByIdAdapter implements FindClientByIdOutputPort {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientEntityMapper clientEntityMapper;

    @Override
    public Optional<Client> find(Long id) {
            return clientRepository.findById(id)
                    .map(clientEntityMapper::toClient);
    }
}
