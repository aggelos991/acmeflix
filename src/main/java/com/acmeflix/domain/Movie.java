package com.acmeflix.domain;

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
@Entity
@Table(name = "MOVIES")
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "idGenerator", sequenceName = "MOVIES_SEQ", initialValue = 1, allocationSize = 1)
public class Movie extends ContentItem {
    @NotNull
    private Integer duration;

    @NotNull
    @Column(name = "has_sequel")
    private Boolean hasSequel;

}
