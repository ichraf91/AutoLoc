package tn.esprit.autoloc.Services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.DTO.ClientRequestDto;
import tn.esprit.autoloc.DTO.ClientResponseDto;
import tn.esprit.autoloc.Entities.Client;
import tn.esprit.autoloc.Repositories.ClientRepo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClient{

   private final ClientRepo clientRepo;
   private final IClientMapper clientMapper;

    @Override
    public Client ajouterClient(Client cl) {
        return clientRepo.save(cl);
    }

    @Override
    public void supprimerClient(long idClient) {
        clientRepo.deleteById(idClient);

    }

    @Override
    public List<Client> recupererClients() {
        return clientRepo.findAll();
    }

    @Override
    public Set<Client> findClients() {
        return new HashSet<>(clientRepo.findAll());
    }



    @Override
    public Client recupererClientByid(long idClient) {
        return clientRepo.findById(idClient).get();
    }

    @Override
    public Client updateClient(Client cl) {
        return clientRepo.save(cl);
    }

    @Override
    public ClientResponseDto ajouterClient(ClientRequestDto dto) {

        // Conversion DTO vers Entity
        Client client = clientMapper.toEntity(dto);

        // Enregistrement dans la base de données
        Client savedClient = clientRepo.save(client);

        // Conversion Entity vers ResponseDTO
        return clientMapper.toDto(savedClient);
    }

    @Override
    public ClientResponseDto recupererClient(Long idClient) {

        Client client = clientRepo.findById(idClient)
                .orElseThrow(() ->
                        new RuntimeException("Client introuvable"));

        return clientMapper.toDto(client);
    }
}
