package softuni.TheChefRestaurant.TheChefRestaurant.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import java.time.LocalDateTime;


@Component
@SessionScope
public class YourReservation {
    private Long id;
    private String name;
    private LocalDateTime dateTime;
    private Integer countPeople;
    private String specialRequest;


    public YourReservation() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    public Integer getCountPeople() {
        return countPeople;
    }
    public void setCountPeople(Integer countPeople) {
        this.countPeople = countPeople;
    }
    public String getSpecialRequest() {
        return specialRequest;
    }
    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }

}
