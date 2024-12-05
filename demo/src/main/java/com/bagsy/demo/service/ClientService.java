package com.bagsy.demo.service;

import com.bagsy.demo.domain.clients.Client;
import com.bagsy.demo.domain.clients.ClientRepository;
import com.bagsy.demo.domain.clients.CreateClientDTO;
import com.bagsy.demo.domain.clients.UpdateClientDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public UUID createClient(CreateClientDTO createClientDTO) {
        var entity = new Client(
                UUID.randomUUID(),
                createClientDTO.nome(),
                createClientDTO.email(),
                createClientDTO.telefone(),
                createClientDTO.endereco(),
                null,
                null
        );
        var savedClient = clientRepository.save(entity);
        return savedClient.getClienteId();
    }

    public Optional<Client> getClientById(String clientId) {
        return clientRepository.findById(UUID.fromString(clientId));
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public void deleteClientById(String clientId) {
        var id = UUID.fromString(clientId);
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        }
    }

    public void updateClientById(String clientId, UpdateClientDTO updateClientDTO) {
        var id = UUID.fromString(clientId);
        var clientEntity = clientRepository.findById(id);

        if (clientEntity.isPresent()) {
            var updatedClient = clientEntity.get();

            if (updateClientDTO.nome() != null) {
                updatedClient.setNome(updateClientDTO.nome());
            }
            if (updateClientDTO.email() != null) {
                updatedClient.setEmail(updateClientDTO.email());
            }
            if (updateClientDTO.telefone() != null) {
                updatedClient.setTelefone(updateClientDTO.telefone());
            }
            if (updateClientDTO.endereco() != null) {
                updatedClient.setEndereco(updateClientDTO.endereco());
            }

            clientRepository.save(updatedClient);
        }
    }
}
