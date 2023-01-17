package com.acmeflix.domain;

import com.acmeflix.domain.enumeration.MaturityRating;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ContentItem extends BaseModel {
    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "release_year")
    private Integer releaseYear;

    @NotNull
    private BigDecimal rating;

    @Column(name = "number_Of_views")
    private Integer numberOfViews;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "maturity_rating")
    private MaturityRating maturityRating;

    @NotNull
    @ManyToOne
    private Category category;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "content_item_persons",joinColumns = {@JoinColumn(name = "content_item_id")}
    ,inverseJoinColumns = {@JoinColumn(name = "person_id")})
    private Set<Person> persons;
}
