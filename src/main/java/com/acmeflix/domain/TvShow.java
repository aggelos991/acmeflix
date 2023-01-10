package com.acmeflix.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper=true)
@SuperBuilder
@Table(name = "TV_SHOWS")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "idGenerator", sequenceName = "TVSHOWS_SEQ", initialValue = 1, allocationSize = 1)
public class TvShow extends ContentItem{

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tvShow", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Season> seasons;
}
