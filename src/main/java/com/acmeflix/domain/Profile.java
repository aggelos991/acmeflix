package com.acmeflix.domain;

import com.acmeflix.domain.enumeration.Language;
import com.acmeflix.domain.enumeration.ProfileType;
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
@Table(name = "PROFILES")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "idGenerator", sequenceName = "PROFILES_SEQ", initialValue = 1, allocationSize = 1)
public class Profile extends BaseModel{

    @NotNull
    @Column(length = 30 , nullable = false)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Language language;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "profile_type")
    private ProfileType profileType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Account account;

    @Column(name = "total_watch_time")
    private Integer totalWatchTime;
}
