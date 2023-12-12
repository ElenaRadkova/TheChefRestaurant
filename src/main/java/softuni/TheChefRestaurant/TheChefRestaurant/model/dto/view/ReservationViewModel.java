package softuni.TheChefRestaurant.TheChefRestaurant.model.dto.view;

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
    private Set<CategoryNameEnum> categories;
    private String pictureUrl;


    public ReservationViewModel() {
    }

    public Long getId() {
        return id;
    }

    public ReservationViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ReservationViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ReservationViewModel setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public SectionNameEnum getSection() {
        return section;
    }

    public ReservationViewModel setSection(SectionNameEnum section) {
        this.section = section;
        return this;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public ReservationViewModel setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public Integer getCountPeople() {
        return countPeople;
    }

    public ReservationViewModel setCountPeople(Integer countPeople) {
        this.countPeople = countPeople;
        return this;
    }

    public String getSpecialRequest() {
        return specialRequest;
    }

    public ReservationViewModel setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
        return this;
    }

    public Set<CategoryNameEnum> getCategories() {
        return categories;
    }

    public ReservationViewModel setCategories(Set<CategoryNameEnum> categories) {
        this.categories = categories;
        return this;
    }
    public UserEntity getAuthor() {
        return author;
    }

    public ReservationViewModel setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
