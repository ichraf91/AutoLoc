package tn.esprit.autoloc.Services;

import tn.esprit.autoloc.Entities.Reservation;
import tn.esprit.autoloc.Entities.StatutReservation;

import java.time.LocalDate;
import java.util.List;

public interface IReservation {

    void terminerReservationsExpirees();
}
