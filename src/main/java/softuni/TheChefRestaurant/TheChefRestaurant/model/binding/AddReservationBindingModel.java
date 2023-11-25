package softuni.TheChefRestaurant.TheChefRestaurant.model.binding;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.Category;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.enums.SectionNameEnum;

import java.time.LocalDateTime;
import java.util.Set;

public class AddReservationBindingModel {
    private String name;
    private Integer countPeople;
    private SectionNameEnum section;
    private LocalDateTime dateTime;
    private String phoneNumber;
    private String specialRequest;
    private Set<Category> categories;

    public AddReservationBindingModel() {
    }

    @Size(min = 3, max = 20, message = "Reservation Name must be between 3 and 20 characters!")
    @NotNull
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


//    @Size(min = 1, max = 65, message = "Maximum capacity of the restaurant is 60 people!")
    public Integer getCountPeople() {
        return countPeople;
    }
    public void setCountPeople(Integer countPeople) {
        this.countPeople = countPeople;
    }

    @NotNull
    public SectionNameEnum getSection() {
        return section;
    }
    public void setSection(SectionNameEnum section) {
        this.section = section;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @NumberFormat
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Size(min = 5)
    public String getSpecialRequest() {
        return specialRequest;
    }
    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }

    public Set<Category> getCategories() {
        return categories;
    }
    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
