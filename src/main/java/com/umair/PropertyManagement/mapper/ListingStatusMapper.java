package com.umair.PropertyManagement.mapper;


import com.umair.PropertyManagement.Enums.ListingStatusesEnum;
import com.umair.PropertyManagement.Enums.PropertyTypeEnum;
import com.umair.PropertyManagement.model.ListingStatus;
import com.umair.PropertyManagement.model.PropertyType;
import com.umair.PropertyManagement.model.dto.ListingStatusesDTO;

public class ListingStatusMapper {
    public static ListingStatusesDTO ListingStatusToListingStatusesDTO(ListingStatus listingStatus) {
        if (listingStatus == null) return null;

        ListingStatusesDTO listingStatusesDTO = new ListingStatusesDTO();
        listingStatusesDTO.setName(listingStatus.getName().name());
        return listingStatusesDTO;
    }

    public static ListingStatus ListingStatusesDTOToListingStatus(ListingStatusesDTO listingStatusesDTO) {
        if (listingStatusesDTO == null) return null;

        ListingStatus listingStatus = new ListingStatus();
        listingStatus.setName(
                ListingStatusesEnum
                        .valueOf(
                                listingStatusesDTO
                                        .getName()
                                        .toUpperCase()));

        return listingStatus;
    }


}
