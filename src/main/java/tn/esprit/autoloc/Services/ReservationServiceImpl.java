package tn.esprit.autoloc.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.Entities.Reservation;
import tn.esprit.autoloc.Entities.StatutReservation;
import tn.esprit.autoloc.Repositories.ReservationRepo;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements IReservation {
    private final ReservationRepo reservationRepo;

    @Override
    @Transactional
    public void terminerReservationsExpirees() {
        List<Reservation> reservations = reservationRepo.findByStatutAndDateFinBefore(StatutReservation.CONFIRMEE,LocalDate.now());
        for (Reservation reservation : reservations) {
            reservation.setStatut(StatutReservation.TERMINEE);
        }
        reservationRepo.saveAll(reservations);
    }

    @Scheduled(fixedRate = 30000)
    public void verifierReservations() {
        terminerReservationsExpirees();    }
}