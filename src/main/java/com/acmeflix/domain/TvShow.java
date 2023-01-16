package com.acmeflix.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper=true)
@SuperBuilder
@Table(name = "TV_SHOWS")
@Entity
@AllArgsConstructor
@SequenceGenerator(name = "idGenerator", sequenceName = "TVSHOWS_SEQ", initialValue = 1, allocationSize = 1)
public class TvShow extends ContentItem{


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tvShow", cascade = CascadeType.ALL, orphanRemoval = true)
    private final Set<Season> seasons = new HashSet<>();
}
