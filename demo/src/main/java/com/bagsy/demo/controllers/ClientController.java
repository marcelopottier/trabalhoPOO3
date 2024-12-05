package com.bagsy.demo.controllers;

import com.bagsy.demo.domain.clients.Client;
import com.bagsy.demo.domain.clients.CreateClientDTO;
import com.bagsy.demo.domain.clients.UpdateClientDTO;
import com.bagsy.demo.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        var clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getClientById(@PathVariable("clientId") String clientId) {
        var client = clientService.getClientById(clientId);
        if (client.isPresent()) {
            return ResponseEntity.ok(client.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> createClient(@RequestBody CreateClientDTO createClientDTO) {
        var clientId = clientService.createClient(createClientDTO);
        return ResponseEntity.created(URI.create("/client/" + clientId)).build();
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Void> updateClientById(@PathVariable("clientId") String clientId, @RequestBody UpdateClientDTO updateClientDTO) {
        clientService.updateClientById(clientId, updateClientDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClientById(@PathVariable("clientId") String clientId) {
        clientService.deleteClientById(clientId);
        return ResponseEntity.noContent().build();
    }
}
