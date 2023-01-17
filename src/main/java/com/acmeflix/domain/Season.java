package com.acmeflix.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
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

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JsonIgnore
    private TvShow tvShow;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "season", cascade = CascadeType.ALL, orphanRemoval = true)
    private final Set<Episode> seasons = new HashSet<>();

}