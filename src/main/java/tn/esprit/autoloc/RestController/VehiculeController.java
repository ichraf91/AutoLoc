package tn.esprit.autoloc.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Employe;
import tn.esprit.autoloc.Entities.Vehicule;
import tn.esprit.autoloc.Services.IVehicule;

import java.util.List;

@RestController
@Tag(name="Gestion Vehicule")
@RequestMapping("/api/Vehicule")
@RequiredArgsConstructor
public class VehiculeController {
    private final IVehicule iVehicule;
    @Operation(summary="ajouter vehicule dans la BD")
    @PostMapping("/addVehicule")
    public ResponseEntity<Vehicule> ajouter(
            @Valid @RequestBody Vehicule vehicule) {

        Vehicule nouveau =
                iVehicule.ajouterVehicule(vehicule);

        return ResponseEntity.status(
                HttpStatus.CREATED)
                .body(nouveau);
    }

    @GetMapping("/GetAll")
    public ResponseEntity<List<Vehicule>> afficherTous() {
        return ResponseEntity.ok(
                iVehicule.afficherVehicules());
    }

    @GetMapping("/GetById/{id}")
    public ResponseEntity<Vehicule> afficherParId(
            @Parameter(description ="l'identifiant du vehicule")
            @PathVariable Long id) {
        return ResponseEntity.ok(
                iVehicule.afficherVehicule(id));
    }

    @PutMapping("/PutById/{id}")
    public ResponseEntity<Vehicule> modifier(
            @PathVariable Long id,
            @Valid @RequestBody Vehicule vehicule) {

        return ResponseEntity.ok(
                iVehicule.modifierVehicule(id, vehicule));
    }

    @DeleteMapping("/Delete/{id}")
    public void supprimer(
            @PathVariable Long id) {

        iVehicule.supprimerVehicule(id);

    }
    @PutMapping("/affecterVehicule/{idVehicule}/{idAgence}")
    public Vehicule affecterVehicule(@PathVariable Long idVehicule,
                                  @PathVariable Long idAgence){
        return iVehicule.affecterVehicule(idVehicule,idAgence);
    }
}
