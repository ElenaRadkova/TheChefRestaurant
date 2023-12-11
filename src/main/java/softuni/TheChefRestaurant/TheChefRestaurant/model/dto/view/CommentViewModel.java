package softuni.TheChefRestaurant.TheChefRestaurant.model.dto.view;

import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.ReservationEntity;
import softuni.TheChefRestaurant.TheChefRestaurant.model.entity.UserEntity;

import java.time.LocalDateTime;

public class CommentViewModel {
    private Long commentId;
    private boolean approved;
    private boolean delete;
    private String textContent;
    private LocalDateTime created;
    private UserEntity author;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }
}
