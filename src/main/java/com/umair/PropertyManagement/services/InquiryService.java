package com.umair.PropertyManagement.services;

import com.umair.PropertyManagement.model.Inquiry;

import java.util.List;

public interface InquiryService {
    List<Inquiry> findAllInquiries();
    Inquiry findInquiryById(Long inquiryId);
    Inquiry createInquiry(Inquiry inquiry);
    Inquiry updateInquiry(Inquiry inquiry);
    Boolean deleteInquiry(Long inquiryId);
}
