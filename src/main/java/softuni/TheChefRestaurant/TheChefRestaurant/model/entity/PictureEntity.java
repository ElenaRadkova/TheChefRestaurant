package softuni.TheChefRestaurant.TheChefRestaurant.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="pictures")
public class PictureEntity extends BaseEntity{
    private String title;
    private String url;
    private UserEntity author;
    private ReservationEntity reservationEntity;

    public PictureEntity() {
    }
    @Column(nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Column(nullable = false, columnDefinition = "TEXT")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    @ManyToOne
    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }
    @ManyToOne
    public ReservationEntity getReservation() {
        return reservationEntity;
    }

    public void setReservation(ReservationEntity reservationEntity) {
        this.reservationEntity = reservationEntity;
    }
}
