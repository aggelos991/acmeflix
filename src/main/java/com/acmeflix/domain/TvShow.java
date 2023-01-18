package com.acmeflix.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
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
