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
    private String author;

    public Long getCommentId() {
        return commentId;
    }

    public CommentViewModel setCommentId(Long commentId) {
        this.commentId = commentId;
        return this;
    }

    public boolean isApproved() {
        return approved;
    }

    public CommentViewModel setApproved(boolean approved) {
        this.approved = approved;
        return this;
    }

    public boolean isDelete() {
        return delete;
    }

    public CommentViewModel setDelete(boolean delete) {
        this.delete = delete;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public CommentViewModel setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public CommentViewModel setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public CommentViewModel setAuthor(String author) {
        this.author = author;
        return this;
    }
}
