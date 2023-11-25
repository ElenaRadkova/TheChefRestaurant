package softuni.TheChefRestaurant.TheChefRestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.Reservation;
import softuni.TheChefRestaurant.TheChefRestaurant.util.YourReservation;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {


}
