package br.com.cloudnative.hexagonal.adapters.out;

import br.com.cloudnative.hexagonal.adapters.out.repository.ClientRepository;
import br.com.cloudnative.hexagonal.application.ports.out.DeleteClientOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteClientAdapter implements DeleteClientOutputPort {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
