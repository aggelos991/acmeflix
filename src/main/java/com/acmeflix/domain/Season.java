package com.acmeflix.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper=true)
@SuperBuilder
@Table(name = "SEASONS")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "idGenerator", sequenceName = "SEASONS_SEQ", initialValue = 1, allocationSize = 1)
public class Season extends BaseModel{

    @NotNull
    private String name;

    @NotNull
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private TvShow tvShow;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "season", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Episode> episodes;
}