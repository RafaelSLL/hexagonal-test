package br.com.cloudnative.hexagonal.adapters.out;

import br.com.cloudnative.hexagonal.adapters.out.repository.ClientRepository;
import br.com.cloudnative.hexagonal.adapters.out.repository.entity.ClientEntity;
import br.com.cloudnative.hexagonal.adapters.out.repository.mapper.ClientEntityMapper;
import br.com.cloudnative.hexagonal.application.core.domain.Client;
import br.com.cloudnative.hexagonal.application.ports.out.InsertClientOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertClientAdapter implements InsertClientOutputPort {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientEntityMapper clientEntityMapper;

    @Override
    public void insert(Client client) {
        ClientEntity clientEntity = clientEntityMapper.toClientEntity(client);
        System.out.println("ENTITY.name=" + clientEntity.getName());
        System.out.println("ENTITY.cpf=" + clientEntity.getCpf());
        System.out.println("ENTITY.email=" + clientEntity.getEmail());
        clientRepository.save(clientEntity);
    }
}
