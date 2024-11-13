package ua.com.project.payments.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.com.project.payments.entity.Client;
import ua.com.project.payments.repository.ClientRepository;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Flux<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Mono<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public Mono<Client> createClient(Client client) {
        return clientRepository.save(client);
    }

    public Mono<Client> updateClient(Long id, Client client) {
        return clientRepository.findById(id)
                .flatMap(existingClient -> {
                    existingClient.setFirstName(client.getFirstName());
                    existingClient.setLastName(client.getLastName());
                    existingClient.setAccounts(client.getAccounts());
                    return clientRepository.save(existingClient);
                });
    }

    public Mono<Void> deleteClient(Long id) {
        return clientRepository.deleteById(id);
    }
}
