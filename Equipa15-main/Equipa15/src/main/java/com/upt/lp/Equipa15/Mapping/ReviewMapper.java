package com.upt.lp.Equipa15.Mapping;
import com.upt.lp.Equipa15.DTO.ReviewDTO;
import com.upt.lp.Equipa15.entity.*;
import java.time.LocalDate;

public class ReviewMapper {
    public static ReviewDTO toDTO(Review review) {
        return new ReviewDTO(
                review.getId(),
                review.getComment(),
                review.getRating(),
                review.getCreationDate(),
                review.getMediaType(),
                review.getLike_count(),
                review.getMedia() != null ? review.getMedia().getId() : null,
                review.getUser() != null ? review.getUser().getId() : null
        );
    }         

    public static Review toEntity (ReviewDTO dto, User user, Media media) {
        Review review = new Review();
        review.setComment(dto.getComment());
        review.setRating(dto.getRating());
        review.setMediaType(dto.getMediaType());
        review.setMedia(media);
        review.setUser(user);
        return review;
    }
}
