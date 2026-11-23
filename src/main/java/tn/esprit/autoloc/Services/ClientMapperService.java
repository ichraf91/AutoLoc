package tn.esprit.autoloc.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.DTO.ClientDto;
import tn.esprit.autoloc.DTO.ClientResponseDto;
import tn.esprit.autoloc.Entities.Client;
import tn.esprit.autoloc.Repositories.ClientRepo;

@Service
@AllArgsConstructor
public class ClientMapperService {

    private final ClientRepo clientRepo;
    private final IClientMapper clientMapper;

    public ClientResponseDto toDto(Long id) {

        Client client = clientRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        return clientMapper.toDto(client);
    }

}
