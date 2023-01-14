package com.acmeflix.service;

import com.acmeflix.domain.Profile;
import com.acmeflix.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl extends BaseServiceImpl<Profile> implements ProfileService {

    private final ProfileRepository profileRepository;

    @Override
    JpaRepository<Profile, Long> getRepository() {
        return profileRepository;
    }

    public Integer searchProfileNumberOfViews(Profile profile){
        return profile.getTotalWatchTime();
    }

    /*public Set<ContentItem> searchProfileViewingHistory(Profile profile){
        return profile.getWatchedContent();
    }*/

}

