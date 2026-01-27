package br.com.cloudnative.hexagonal.adapters.in.controller;

import br.com.cloudnative.hexagonal.adapters.in.controller.mapper.ClientMapper;
import br.com.cloudnative.hexagonal.adapters.in.controller.request.ClientRequest;
import br.com.cloudnative.hexagonal.adapters.in.controller.response.ClientResponse;
import br.com.cloudnative.hexagonal.application.core.domain.Client;
import br.com.cloudnative.hexagonal.application.ports.in.DeleteClientInputPort;
import br.com.cloudnative.hexagonal.application.ports.in.FindClientByIdInputPort;
import br.com.cloudnative.hexagonal.application.ports.in.InsertClientInputPort;
import br.com.cloudnative.hexagonal.application.ports.in.UpdateClientInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/clients")
public class ClientController {

    @Autowired
    private InsertClientInputPort insertClientInputPort;
    @Autowired
    private FindClientByIdInputPort findClientByIdInputPort;
    @Autowired
    private UpdateClientInputPort updateClientInputPort;
    @Autowired
    private DeleteClientInputPort deleteClientInputPort;

    @Autowired
    private ClientMapper clientMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody ClientRequest clientRequest){
        Client client = clientMapper.toClient(clientRequest);
        insertClientInputPort.insert(client);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> findById(@PathVariable final Long id){
        Client client = findClientByIdInputPort.find(id);
        ClientResponse clientResponse = clientMapper.toClientResponse(client);
        return ResponseEntity.ok().body(clientResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update (@PathVariable final Long id,
                                        @Valid @RequestBody ClientRequest clientRequest
    ){
        Client client = clientMapper.toClient(clientRequest);
        client.setId(id);
        updateClientInputPort.update(client);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Void> delete (@PathVariable final Long id){
        deleteClientInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }

}
