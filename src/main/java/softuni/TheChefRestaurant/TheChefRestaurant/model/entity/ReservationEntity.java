package softuni.TheChefRestaurant.TheChefRestaurant.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.enums.SectionNameEnum;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="reservations")
public class ReservationEntity extends BaseEntity{
    private String name;
    private String phoneNumber;
    private SectionNameEnum section;
    private UserEntity author;
    private LocalDateTime dateTime;
    private Integer countPeople;
    private String specialRequest;
    private Set<CategoryEntity> categories;
    private Set<PictureEntity> pictures;




    public ReservationEntity() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false, unique = true)
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Enumerated(EnumType.STRING)
    public SectionNameEnum getSection() {
        return section;
    }
    public void setSection(SectionNameEnum section) {
        this.section = section;
    }

    @ManyToOne
    public UserEntity getAuthor() {
        return author;
    }
    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    @Column
    @NotNull
    public Integer getCountPeople() {
        return countPeople;
    }
    public void setCountPeople(Integer countPeople) {
        this.countPeople = countPeople;
    }

    @Column(nullable = false)
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Column(columnDefinition = "TEXT")
    public String getSpecialRequest() {
        return specialRequest;
    }
    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<CategoryEntity> getCategories() {
        return categories;
    }
    public void setCategories(Set<CategoryEntity> categories) {
        this.categories = categories;
    }

    @OneToMany(mappedBy = "reservation", fetch = FetchType.EAGER)
    public Set<PictureEntity> getPictures() {
        return pictures;
    }
    public void setPictures(Set<PictureEntity> pictures) {
        this.pictures = pictures;
    }
}
