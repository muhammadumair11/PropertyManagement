package com.umair.PropertyManagement.services;

import com.umair.PropertyManagement.dto.InquiryDTO;
import com.umair.PropertyManagement.model.Inquiry;

import java.util.List;

public interface InquiryService {
    List<InquiryDTO> findAllInquiries();

    InquiryDTO findInquiryById(Long inquiryId);

    InquiryDTO createInquiry(InquiryDTO inquiryDTO);

    InquiryDTO updateInquiry(InquiryDTO inquiryDTO);

    Boolean deleteInquiry(Long inquiryId);
}
