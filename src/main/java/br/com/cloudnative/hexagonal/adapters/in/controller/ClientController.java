package br.com.cloudnative.hexagonal.adapters.in.controller;

import br.com.cloudnative.hexagonal.adapters.in.controller.mapper.ClientMapper;
import br.com.cloudnative.hexagonal.adapters.in.controller.request.ClientRequest;
import br.com.cloudnative.hexagonal.application.core.domain.Client;
import br.com.cloudnative.hexagonal.application.ports.in.InsertClientInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/clients")
public class ClientController {

    @Autowired
    private InsertClientInputPort insertClientInputPort;

    @Autowired
    private ClientMapper clientMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody ClientRequest clientRequest){
        System.out.println("request.name=" + clientRequest.name());
        System.out.println("request.cpf=" + clientRequest.cpf());
        System.out.println("request.email=" + clientRequest.email());
        System.out.println("REQ: " + clientRequest);
        Client client = clientMapper.toClient(clientRequest);
        System.out.println("DOMAIN: " + client);
        insertClientInputPort.insert(client);
        return ResponseEntity.ok().build();
    }
}
