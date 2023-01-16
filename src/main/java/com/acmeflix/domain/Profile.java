package com.acmeflix.domain;

import com.acmeflix.domain.enumeration.Language;
import com.acmeflix.domain.enumeration.ProfileType;
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
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JsonIgnore
    private Account account;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "profile_type")
    private ProfileType profileType;

    @Column(name = "total_watch_time")
    private Integer totalWatchTime;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "profile_content_items",joinColumns = {@JoinColumn(name = "profile_id")}
            ,inverseJoinColumns = {@JoinColumn(name = "content_item_id")})
    @JsonIgnore
    private Set<ContentItem> watchedContent;
}
