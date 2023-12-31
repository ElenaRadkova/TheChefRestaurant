package softuni.TheChefRestaurant.TheChefRestaurant.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.ReservationEntity;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.UserEntity;
import softuni.TheChefRestaurant.TheChefRestaurant.repository.CommentRepository;
import softuni.TheChefRestaurant.TheChefRestaurant.repository.ReservationRepository;
import softuni.TheChefRestaurant.TheChefRestaurant.repository.UserRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class CommentRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    private UserEntity testUser;

    @BeforeEach
    void setUp() {
        testUser =new UserEntity();
        testUser.setUsername("elena");
        testUser.setPassword("imHappy");
        testUser.setFullName("elena kanazireva");
        testUser.setEmail("elena@elena.bg");

        testUser = userRepository.save(testUser);
    }

    @AfterEach
    void tearDown() {
        reservationRepository.deleteAll();
        userRepository.deleteAll();
    }
    @Test
    void testGetComments() {

    }
    private void initReservation() {
        ReservationEntity testReservation = new ReservationEntity();
        testReservation.setName("Test Reservation");
        testReservation.setPhoneNumber("359885111222");
        testReservation.setSpecialRequest("Test Request");

        reservationRepository.save(testReservation);
    }
}
