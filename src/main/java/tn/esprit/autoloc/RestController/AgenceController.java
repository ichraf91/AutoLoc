package tn.esprit.autoloc.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Agence;
import tn.esprit.autoloc.Services.IAgence;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/agence")
@RequiredArgsConstructor
public class AgenceController {
   private final IAgence iAgence;

    @PostMapping("/addAgence")
    public Agence ajouterAgence(@RequestBody Agence a){
        return iAgence.addAgence(a);
    }
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
    @DeleteMapping("/deleteAgenceById/{ID}")
    public void updateAgence(@PathVariable long id){
        iAgence.deleteAgence(id);
    }

}
