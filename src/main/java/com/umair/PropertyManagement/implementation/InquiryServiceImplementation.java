package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.dto.InquiryDTO;
import com.umair.PropertyManagement.mapper.InquiryMapper;
import com.umair.PropertyManagement.model.Inquiry;
import com.umair.PropertyManagement.model.Property;
import com.umair.PropertyManagement.model.User;
import com.umair.PropertyManagement.repository.InquiryRepository;
import com.umair.PropertyManagement.repository.PropertyRepository;
import com.umair.PropertyManagement.repository.UserRepository;
import com.umair.PropertyManagement.services.InquiryService;
import com.umair.PropertyManagement.services.InquiryService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InquiryServiceImplementation implements InquiryService {

    @Autowired
    InquiryRepository inquiryRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    PropertyRepository propertyRepository;


    @Override
    public List<InquiryDTO> findAllInquiries() {
        List<Inquiry> inquiries = inquiryRepository.findAll();
        return inquiries.stream().map(InquiryMapper::InquiryToInquiryDTO).collect(Collectors.toList());
    }

    @Override
    public InquiryDTO findInquiryById(Long inquiryId) {
        return InquiryMapper.InquiryToInquiryDTO(inquiryRepository.findById(inquiryId).orElseThrow(() -> new EntityNotFoundException("Inquiry doesn't exist")));
    }

    @Override
    public InquiryDTO createInquiry(InquiryDTO inquiryDTO) {
        User user = userRepository.findById(inquiryDTO.getUserId()).orElseThrow(() -> new EntityNotFoundException("User for Inquiry doesn't exist"));
        Property property = propertyRepository.findById(inquiryDTO.getPropertyId()).orElseThrow(() -> new EntityNotFoundException("Property for Inquiry doesn't exist"));

        Inquiry savedInquiry = inquiryRepository.save(
                Inquiry
                        .builder()
                        .message(inquiryDTO.getMessage())
                        .user(user)
                        .property(property)
                        .build()
        );

        return InquiryMapper.InquiryToInquiryDTO(savedInquiry);
    }

    @Override
    public InquiryDTO updateInquiry(InquiryDTO inquiryDTO) {
        Inquiry existingInquiry = inquiryRepository.findById(inquiryDTO.getId()).orElseThrow(() -> new RuntimeException("Inquiry doesn't exist"));

        User user = userRepository.findById(inquiryDTO.getUserId()).orElseThrow(() -> new RuntimeException("User for Inquiry doesn't exist"));
        Property property = propertyRepository.findById(inquiryDTO.getPropertyId()).orElseThrow(() -> new RuntimeException("Property for Inquiry doesn't exist"));



        Inquiry updatedInquiry = inquiryRepository.save(
                existingInquiry
                        .toBuilder()
                        .id(inquiryDTO.getId())
                        .message(inquiryDTO.getMessage())
                        .user(user)
                        .property(property)
                        .build()
        );

        return InquiryMapper.InquiryToInquiryDTO(updatedInquiry);
    }

    @Override
    public Boolean deleteInquiry(Long inquiryId) {
        inquiryRepository.deleteById(inquiryId);
        if (inquiryRepository.findById(inquiryId).orElse(null) == null)
            return true;
        return false;
    }
}
