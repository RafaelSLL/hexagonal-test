package br.com.cloudnative.hexagonal.adapters.out;

import br.com.cloudnative.hexagonal.adapters.out.repository.ClientRepository;
import br.com.cloudnative.hexagonal.adapters.out.repository.entity.ClientEntity;
import br.com.cloudnative.hexagonal.adapters.out.repository.mapper.ClientEntityMapper;
import br.com.cloudnative.hexagonal.application.core.domain.Client;
import br.com.cloudnative.hexagonal.application.ports.out.UpdateClientOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateClientAdapter implements UpdateClientOutputPort {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientEntityMapper clientEntityMapper;

    @Override
    public void update(Client client) {
        ClientEntity clientEntity = clientEntityMapper.toClientEntity(client);
        clientRepository.save(clientEntity);
    }
}
