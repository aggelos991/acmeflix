package com.acmeflix.domain;

import com.acmeflix.domain.enumeration.Country;
import com.acmeflix.domain.enumeration.SubscriptionTier;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper = true)
@SuperBuilder
@Table(name = "ACCOUNTS")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "idGenerator", sequenceName = "ACCOUNTS_SEQ", initialValue = 1, allocationSize = 1)
public class Account extends BaseModel{

    @NotNull
    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(name = "first_name", length = 20 , nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "last_name", length = 30 , nullable = false)
    private String lastName;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Country country;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "subscription_tier")
    private SubscriptionTier subscriptionTier;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Profile> profiles;
}
