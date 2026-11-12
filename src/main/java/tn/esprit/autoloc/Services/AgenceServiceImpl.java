package tn.esprit.autoloc.Services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Agence;
import tn.esprit.autoloc.Entities.Employe;
import tn.esprit.autoloc.Entities.Vehicule;
import tn.esprit.autoloc.Repositories.AgenceRepo;
import tn.esprit.autoloc.Repositories.EmployeRepo;
import tn.esprit.autoloc.Repositories.VehiculeRepo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AgenceServiceImpl implements IAgence {
   private final AgenceRepo agenceRepo;
   private final VehiculeRepo vehiculeRepo;

    @Override
    public Agence addAgence(Agence agence) {
        return agenceRepo.save(agence);
    }

    @Override
    public void deleteAgence(long id) {
        agenceRepo.deleteById(id);
    }

    @Override
    public Set<Agence> retrieveAgence() {
       // return agenceRepo.findAll().stream().collect(Collectors.toSet());
        return new HashSet<>(agenceRepo.findAll());
    }

    @Override
    public List<Agence> retrieveAgences() {
        return agenceRepo.findAll();
    }

    @Override
    public Agence retrieveById(long id) {
        return agenceRepo.findById(id).orElseThrow(null);
    }

    @Override
    public Agence updateAgence(Agence agence) {
        return agenceRepo.save(agence);
    }

//    @Scheduled(fixedRate = 5000)
//    public void fixedDelayMethod() {
//        log.info("Method with fixed Delay");
//    }


}
