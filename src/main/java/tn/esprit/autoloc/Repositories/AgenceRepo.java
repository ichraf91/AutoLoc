package tn.esprit.autoloc.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.autoloc.Entities.Agence;


@Repository
public interface AgenceRepo extends JpaRepository<Agence,Long> {

}
