package com.acmeflix.domain;

import com.acmeflix.domain.enumeration.Language;
import com.acmeflix.domain.enumeration.ProfileType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper=true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Profile extends BaseModel{

    private String name;
    private Language language;
    private ProfileType profileType;
    private Account account;
    private Integer totalWatchTime;
    private Set<Movie> watchedMovies;
    private Set<TvShow> watchedTvShows;
}
