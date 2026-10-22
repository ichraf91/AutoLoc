package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.Vehicule;

import java.util.List;

public interface IVehicule {
    Vehicule ajouterVehicule(Vehicule vehicule);

    List<Vehicule> afficherVehicules();

    Vehicule afficherVehicule(Long id);

    Vehicule modifierVehicule(Long id, Vehicule vehicule);

    void supprimerVehicule(Long id);
    public Vehicule affecterVehicule(Long idVehicule, Long idAgence);

}
