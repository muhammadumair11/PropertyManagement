package com.umair.PropertyManagement.implementation;

import com.umair.PropertyManagement.model.Inquiry;
import com.umair.PropertyManagement.services.InquiryService;
import com.umair.PropertyManagement.services.InquiryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquiryServiceImplementation implements InquiryService {
    @Override
    public List<Inquiry> findAllInquiries() {
        return List.of();
    }

    @Override
    public Inquiry findInquiryById(Long inquiryId) {
        return null;
    }

    @Override
    public Inquiry createInquiry(Inquiry inquiry) {
        return null;
    }

    @Override
    public Inquiry updateInquiry(Inquiry inquiry) {
        return null;
    }

    @Override
    public Boolean deleteInquiry(Long inquiryId) {
        return null;
    }
}
