package tn.esprit.autoloc.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.Entities.Vehicule;
import tn.esprit.autoloc.Services.IVehicule;

import java.util.List;

@RestController
@RequestMapping("/api/Vehicule")
@RequiredArgsConstructor
public class VehiculeController {
    private final IVehicule iVehicule;
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

    @GetMapping("/GetById{id}")
    public ResponseEntity<Vehicule> afficherParId(
            @PathVariable Long id) {
        return ResponseEntity.ok(
                iVehicule.afficherVehicule(id));
    }

    @PutMapping("/PutById{id}")
    public ResponseEntity<Vehicule> modifier(
            @PathVariable Long id,
            @Valid @RequestBody Vehicule vehicule) {

        return ResponseEntity.ok(
                iVehicule.modifierVehicule(id, vehicule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(
            @PathVariable Long id) {

        iVehicule.supprimerVehicule(id);
        return ResponseEntity.noContent().build();
    }
}
