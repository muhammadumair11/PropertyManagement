package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.model.ListingStatus;
import com.umair.PropertyManagement.repository.ListingStatusRepository;
import com.umair.PropertyManagement.services.ListingStatusService;
import com.umair.PropertyManagement.services.ListingStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingStatusServiceImplementation implements ListingStatusService {

    @Autowired
    ListingStatusRepository listingStatusRepository;

    @Override
    public List<ListingStatus> findAllListingStatuses() {
        return listingStatusRepository.findAll();
    }

    @Override
    public ListingStatus findListingStatusById(Long listingStatusId) {
        return listingStatusRepository.findById(listingStatusId).orElse(null);
    }

    @Override
    public ListingStatus createListingStatus(ListingStatus listingStatus) {
        return listingStatusRepository.save(listingStatus);
    }

    @Override
    public ListingStatus updateListingStatus(ListingStatus listingStatus) {
        ListingStatus listingStatus1 = findListingStatusById(listingStatus.getId());

        if(listingStatus1 != null) {
            listingStatus.setId(listingStatus.getId());
            return listingStatusRepository.save(listingStatus);
        }
        return null;
    }

    @Override
    public Boolean deleteListingStatus(Long listingStatusId) {
        listingStatusRepository.deleteById(listingStatusId);
        if(findListingStatusById(listingStatusId) == null)
            return true;
        return false;
    }
}
