package com.acmeflix.service;

import com.acmeflix.domain.Account;
import com.acmeflix.domain.ContentItem;
import com.acmeflix.domain.Profile;

import java.util.Map;
import java.util.Set;

public interface ProfileService extends BaseService<Profile,Long> {

    Integer searchProfileNumberOfViews(Profile profile);

    Set<ContentItem> searchProfileViewingHistory(Profile profile);

}
