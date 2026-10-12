package tn.esprit.autoloc.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.Entities.Vehicule;
import tn.esprit.autoloc.Repositories.VehiculeRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class VehiculeServiceImpl implements IVehicule{
    private final VehiculeRepo  vehiculeRepo;

    @Override
    public Vehicule ajouterVehicule(Vehicule vehicule) {
        return vehiculeRepo.save(vehicule);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vehicule> afficherVehicules() {
        return vehiculeRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Vehicule afficherVehicule(Long id) {
        return vehiculeRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Véhicule introuvable avec l'identifiant : " + id
                        ));
    }

    @Override
    public Vehicule modifierVehicule(Long id, Vehicule vehicule) {

        Vehicule vehiculeExistant = vehiculeRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Véhicule introuvable avec l'identifiant : " + id
                        ));

        vehiculeExistant.setImmatriculation(
                vehicule.getImmatriculation());
        vehiculeExistant.setMarque(vehicule.getMarque());
        vehiculeExistant.setModele(vehicule.getModele());
        vehiculeExistant.setCategorie(vehicule.getCategorie());
        vehiculeExistant.setTarifJournalier(
                vehicule.getTarifJournalier());
        vehiculeExistant.setStatut(vehicule.getStatut());

        return vehiculeRepo.save(vehiculeExistant);
    }

    @Override
    public void supprimerVehicule(Long id) {

        Vehicule vehicule = vehiculeRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Véhicule introuvable avec l'identifiant : " + id
                        ));


    }}
