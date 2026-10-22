package tn.esprit.autoloc.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Agence;
import tn.esprit.autoloc.Services.IAgence;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@Tag(name="Gestion Agence")
@RequestMapping("/api/agence")
@RequiredArgsConstructor
public class AgenceController {
   private final IAgence iAgence;
@Operation(description = "ajouter un objet agence dans la BD")
    @PostMapping("/addAgence")
    public Agence ajouterAgence(@RequestBody Agence a){
        return iAgence.addAgence(a);
    }
    @Operation(description = "récuperer la liste des agences depuis la BD")
    //GetALL,type de retour Set
    @GetMapping("/getAll")
    public Set<Agence> retrieveAgence(){
        return new HashSet<>(iAgence.retrieveAgence());
    }
    //GetALL,type de retour List
    @GetMapping("/getAllAgences")
    public List<Agence> recupererAgence(){
        return iAgence.retrieveAgences();
    }
    @PutMapping("/updateAgence")
    public Agence updateAgence(@RequestBody Agence a){
        return iAgence.updateAgence(a);
    }
    @DeleteMapping("/deleteAgenceById/{id}")
    public void updateAgence(@PathVariable Long id){
        iAgence.deleteAgence(id);
    }

}
