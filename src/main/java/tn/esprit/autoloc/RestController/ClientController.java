package tn.esprit.autoloc.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.DTO.ClientDto;
import tn.esprit.autoloc.DTO.ClientRequestDto;
import tn.esprit.autoloc.DTO.ClientResponseDto;
import tn.esprit.autoloc.Entities.Client;
import tn.esprit.autoloc.Services.ClientMapperService;
import tn.esprit.autoloc.Services.IClient;
import tn.esprit.autoloc.Services.IClientMapper;

import java.util.List;

@RestController
@Tag(name="Gestion Client")
@RequestMapping("/api/Client")
@RequiredArgsConstructor
public class ClientController {
   private final ClientMapperService clientMapperService;
    private final IClient iClient;
    @GetMapping("/getClientdto/{idClient}")
    public ClientResponseDto recupererClientDTO(@PathVariable Long idClient)
    {
        return clientMapperService.toDto(idClient);
    }
    @Operation(description="ajouter un client dans la base ")
    @PostMapping("/AddClient")
    public Client ajouterClient(@RequestBody Client client) {
        return iClient.ajouterClient(client);

    }
    @Operation(description="récuperer tous les clients")
    @GetMapping("/GetAll")
    public List<Client> getAll() {
        return iClient.recupererClients();
    }

    @PutMapping("/updateClient")
    public Client updateClient(@RequestBody Client client) {
        return iClient.updateClient(client);
    }
    @DeleteMapping("/deleteClient/{idclient}")
    public void deleteClient(@PathVariable("idclient") Long id)
    {
        iClient.supprimerClient(id);
    }

    // Ajouter un client
    @PostMapping("/addClientDTO")
    public ClientResponseDto ajouterClient(
            @Valid @RequestBody ClientRequestDto dto) {

        return iClient.ajouterClient(dto);
    }

    // Récupérer un client par son identifiant
    @GetMapping("/getClientDTO/{idClient}")
    public ClientResponseDto recupererClient(
            @PathVariable Long idClient) {

        return iClient.recupererClient(idClient);
    }
}