package br.com.cloudnative.hexagonal.adapters.in.controller.mapper;

import br.com.cloudnative.hexagonal.adapters.in.controller.request.ClientRequest;
import br.com.cloudnative.hexagonal.adapters.in.controller.response.ClientResponse;
import br.com.cloudnative.hexagonal.application.core.domain.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toClient(ClientRequest request);

    ClientResponse toClientResponse(Client client);
}
