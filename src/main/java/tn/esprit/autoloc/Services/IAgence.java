package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.Agence;

import java.util.List;
import java.util.Set;

public interface IAgence {
    Agence addAgence(Agence agence);
    void deleteAgence(long id);
    Set<Agence> retrieveAgence();
    List<Agence> retrieveAgences();
    Agence retrieveById( long id);
    Agence updateAgence(Agence agence);


}
