package tn.esprit.autoloc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.Entities.Maintenance;
import tn.esprit.autoloc.Entities.Paiement;

@Repository
public interface MaintenanceRepo extends JpaRepository<Maintenance,Long> {
}
