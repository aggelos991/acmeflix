package com.acmeflix.domain;

import com.acmeflix.domain.enumeration.Country;
import com.acmeflix.domain.enumeration.SubscriptionTier;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseModel{
    private String email;
    private String firstName;
    private String lastName;
    private Country country;
    private SubscriptionTier subscriptionTier;
    private Set<Profile> profiles;
}
