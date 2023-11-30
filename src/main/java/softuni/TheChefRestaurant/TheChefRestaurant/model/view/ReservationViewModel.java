package softuni.TheChefRestaurant.TheChefRestaurant.model.view;

import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.UserEntity;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.enums.CategoryNameEnum;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.enums.SectionNameEnum;

import java.time.LocalDateTime;
import java.util.Set;

public class ReservationViewModel {
    private Long id;
    private String name;
    private String phoneNumber;
    private SectionNameEnum section;
    private LocalDateTime dateTime;
    private Integer countPeople;
    private String specialRequest;
    private UserEntity author;
//    private Set<CategoryNameEnum> categories;


    public ReservationViewModel() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public SectionNameEnum getSection() {
        return section;
    }

    public void setSection(SectionNameEnum section) {
        this.section = section;
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

//    public Set<CategoryNameEnum> getCategories() {
//        return categories;
//    }
//
//    public void setCategories(Set<CategoryNameEnum> categories) {
//        this.categories = categories;
//    }
    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }
}
