package com.acmeflix.service;

import com.acmeflix.domain.Account;
import com.acmeflix.domain.ContentItem;
import com.acmeflix.domain.Profile;
import com.acmeflix.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public Set<ContentItem> searchProfileViewingHistory(Profile profile){
        return profile.getWatchedContent();
    }

}


