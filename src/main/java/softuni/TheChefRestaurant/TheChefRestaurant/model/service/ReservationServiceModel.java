package softuni.TheChefRestaurant.TheChefRestaurant.model.service;

import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.UserEntity;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.enums.CategoryNameEnum;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.enums.SectionNameEnum;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class ReservationServiceModel {
    private Long id;
    private String name;
    private String phoneNumber;
    private SectionNameEnum section;
    private UserEntity author;
    private LocalDateTime dateTime;
    private Integer countPeople;
    private String specialRequest;
    private Set<CategoryNameEnum> categories;


    public ReservationServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public ReservationServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ReservationServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public ReservationServiceModel setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public SectionNameEnum getSection() {
        return section;
    }

    public ReservationServiceModel setSection(SectionNameEnum section) {
        this.section = section;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public ReservationServiceModel setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public ReservationServiceModel setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public Integer getCountPeople() {
        return countPeople;
    }

    public ReservationServiceModel setCountPeople(Integer countPeople) {
        this.countPeople = countPeople;
        return this;
    }

    public String getSpecialRequest() {
        return specialRequest;
    }

    public ReservationServiceModel setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
        return this;
    }

    public Set<CategoryNameEnum> getCategories() {
        return categories;
    }
    public ReservationServiceModel setCategories(Set<CategoryNameEnum> categories) {
        this.categories = categories;
        return this;
    }
}
