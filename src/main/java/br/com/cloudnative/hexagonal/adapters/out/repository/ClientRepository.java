package br.com.cloudnative.hexagonal.adapters.out.repository;

import br.com.cloudnative.hexagonal.adapters.out.repository.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}
