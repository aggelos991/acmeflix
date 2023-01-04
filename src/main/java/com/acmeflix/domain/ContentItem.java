package com.acmeflix.domain;

import com.acmeflix.domain.enumeration.Genre;
import com.acmeflix.domain.enumeration.MaturityRating;
import com.acmeflix.domain.enumeration.Rating;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ContentItem extends BaseModel {

    private String title;
    private String description;
    private Integer releaseYear;
    private Rating rating;
    private Integer numberOfViews;
    private MaturityRating maturityRating;
    private Set<Genre> genres;
    private Set<Actor> actors;
    private Set<Director> directors;
    private Set<Writer> writers;
}
