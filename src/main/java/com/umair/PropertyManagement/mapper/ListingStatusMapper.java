package com.umair.PropertyManagement.mapper;


import com.umair.PropertyManagement.Enums.ListingStatusesEnum;
import com.umair.PropertyManagement.model.ListingStatus;
import com.umair.PropertyManagement.dto.ListingStatusesDTO;

public class ListingStatusMapper {
    public static ListingStatusesDTO ListingStatusToListingStatusesDTO(ListingStatus listingStatus) {
        if (listingStatus == null) return null;

        ListingStatusesDTO listingStatusesDTO = new ListingStatusesDTO();
        listingStatusesDTO.setId(listingStatus.getId());
        listingStatusesDTO.setName(listingStatus.getName());
        return listingStatusesDTO;
    }

    public static ListingStatus ListingStatusesDTOToListingStatus(ListingStatusesDTO listingStatusesDTO) {
        if (listingStatusesDTO == null) return null;

        ListingStatus listingStatus = new ListingStatus();
        listingStatus.setName(
                                listingStatusesDTO
                                        .getName()
                                        .toUpperCase());

        return listingStatus;
    }


}
