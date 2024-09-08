package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.dto.ListingStatusesDTO;
import com.umair.PropertyManagement.mapper.ListingMapper;
import com.umair.PropertyManagement.mapper.ListingStatusMapper;
import com.umair.PropertyManagement.mapper.PropertyTypeMapper;
import com.umair.PropertyManagement.model.ListingStatus;
import com.umair.PropertyManagement.model.PropertyType;
import com.umair.PropertyManagement.repository.ListingStatusRepository;
import com.umair.PropertyManagement.services.ListingStatusService;
import com.umair.PropertyManagement.services.ListingStatusService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListingStatusServiceImplementation implements ListingStatusService {

    @Autowired
    ListingStatusRepository listingStatusRepository;


    @Override
    public List<ListingStatusesDTO> findAllListingStatuses() {
        List<ListingStatus> listingStatuses = listingStatusRepository.findAll();
        return listingStatuses.stream().map(ListingStatusMapper::ListingStatusToListingStatusesDTO).collect(Collectors.toList());

    }

    @Override
    public ListingStatusesDTO findListingStatusById(Long listingStatusId) {
        ListingStatus listingStatus = listingStatusRepository.findById(listingStatusId)
                .orElseThrow(() -> new RuntimeException("Listing Status doesn't exist"));

        return ListingStatusMapper.ListingStatusToListingStatusesDTO(listingStatus);
    }

    @Override
    public ListingStatusesDTO createListingStatus(ListingStatusesDTO listingStatusesDTO) {
        ListingStatus savedListingStatus = listingStatusRepository.save(
                ListingStatus
                        .builder()
                        .name(listingStatusesDTO.getName().toUpperCase())
                        .build()
        );

        return ListingStatusMapper.ListingStatusToListingStatusesDTO(savedListingStatus);
    }

    @Override
    public ListingStatusesDTO updateListingStatus(ListingStatusesDTO listingStatusesDTO) {
        ListingStatus existingListingStatus = listingStatusRepository
                .findById(
                        listingStatusesDTO
                                .getId()
                )
                .orElseThrow(() -> new RuntimeException(("Listing Status doesn't exist")));

        if (existingListingStatus != null) {
            existingListingStatus.setId(listingStatusesDTO.getId());
            ListingStatus updatedListingStatus = listingStatusRepository.save(
                    existingListingStatus
                            .toBuilder()
                            .id(listingStatusesDTO.getId())
                            .name(listingStatusesDTO.getName().toUpperCase())
                            .build()
            );
            return ListingStatusMapper.ListingStatusToListingStatusesDTO(updatedListingStatus);
        }
        return null;
    }

    @Override
    public Boolean deleteListingStatus(Long listingStatusId) {
        listingStatusRepository.deleteById(listingStatusId);
        if(listingStatusRepository.findById(listingStatusId).orElse(null) == null)
            return true;
        return false;
    }
}
