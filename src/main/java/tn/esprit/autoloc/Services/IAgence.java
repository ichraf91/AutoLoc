package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.DTO.AgenceDto;
import tn.esprit.autoloc.Entities.Agence;
import tn.esprit.autoloc.Entities.Vehicule;

import java.util.List;
import java.util.Set;

public interface IAgence {
    Agence addAgence(Agence agence);
    void deleteAgence(long id);
    Set<Agence> retrieveAgence();
    List<Agence> retrieveAgences();
    Agence retrieveById( long id);
    Agence updateAgence(Agence agence);
    AgenceDto recupererAgenceDto(Long id);
    List<AgenceDto>recuperertteslesagences();
    AgenceDto addAgenceDto(AgenceDto agenceDto);

}
