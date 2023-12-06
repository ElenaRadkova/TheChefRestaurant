package softuni.TheChefRestaurant.TheChefRestaurant.model.dto.view;

import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.CategoryEntity;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.PictureEntity;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.enums.SectionNameEnum;

import java.time.LocalDateTime;
import java.util.Set;

public class YourReservationViewModel {
    private Long id;
    private String name;
    private SectionNameEnum section;
    private LocalDateTime dateTime;
    private Integer countPeople;
    private String specialRequest;
    private Set<CategoryEntity> categories;
    private Set<PictureEntity> pictures;

    public YourReservationViewModel() {
    }

    public String getName() {
        return name;
    }

    public YourReservationViewModel setName(String name) {
        this.name = name;
        return this;
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

    public Set<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryEntity> categories) {
        this.categories = categories;
    }

    public Set<PictureEntity> getPictures() {
        return pictures;
    }

    public void setPictures(Set<PictureEntity> pictures) {
        this.pictures = pictures;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
