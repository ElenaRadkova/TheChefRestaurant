package softuni.TheChefRestaurant.TheChefRestaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.Reservation;

import java.util.Optional;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findById(Long id);

}
