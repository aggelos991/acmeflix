package com.acmeflix.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper=true)
@SuperBuilder
@Table(name = "EPISODES")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "idGenerator", sequenceName = "EPISODES_SEQ", initialValue = 1, allocationSize = 1)
public class Episode extends BaseModel {

    @NotNull
    private String title;

    @NotNull
    private Integer duration;

    @NotNull
    private String description;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JsonIgnore
    private Season season;
}
