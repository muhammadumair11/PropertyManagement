package com.umair.PropertyManagement.services;


import com.umair.PropertyManagement.dto.listingdtos.ListingDTO;
import com.umair.PropertyManagement.dto.listingdtos.ListingRequestDTO;
import com.umair.PropertyManagement.model.User;

import java.util.List;

public interface FavoriteService {
    User addFavorite(Long userId, Long propertyId);
    User removeFavorite(Long userId, Long propertyId);
}

