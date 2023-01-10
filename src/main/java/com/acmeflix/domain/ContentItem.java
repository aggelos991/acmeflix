package com.acmeflix.domain;

import com.acmeflix.domain.enumeration.Genre;
import com.acmeflix.domain.enumeration.MaturityRating;
import com.acmeflix.domain.enumeration.Rating;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class ContentItem extends BaseModel {
    @NotNull
    private String title;

    private String description;

    @NotNull
    @Column(name = "release_year")
    private Integer releaseYear;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Rating rating;

    @Column(name = "number_Of_views")
    private Integer numberOfViews;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "maturity_rating")
    private MaturityRating maturityRating;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Set<Genre> genres;

    @OneToMany
    @JoinColumn(name = "content_item_id")
    private Set<Person> persons;
}
