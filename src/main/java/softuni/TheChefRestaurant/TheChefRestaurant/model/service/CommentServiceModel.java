package softuni.TheChefRestaurant.TheChefRestaurant.model.service;

public class CommentServiceModel {
    private Long reservationId;
    private String commentText;
    private String commentCreator;

    public Long getReservationId() {
        return reservationId;
    }

    public CommentServiceModel setReservationId(Long reservationId) {
        this.reservationId = reservationId;
        return this;
    }

    public String getCommentText() {
        return commentText;
    }

    public CommentServiceModel setCommentText(String commentText) {
        this.commentText = commentText;
        return this;
    }

    public String getCommentCreator() {
        return commentCreator;
    }

    public CommentServiceModel setCommentCreator(String commentCreator) {
        this.commentCreator = commentCreator;
        return this;
    }
}
