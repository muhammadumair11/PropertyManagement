package com.umair.PropertyManagement.mapper;

import com.umair.PropertyManagement.model.Inquiry;
import com.umair.PropertyManagement.dto.InquiryDTO;

public class InquiryMapper {

    public static InquiryDTO InquiryToInquiryDTO(Inquiry inquiry) {
        if (inquiry == null) return null;

        InquiryDTO inquiryDTO = new InquiryDTO();
        inquiryDTO.setId(inquiry.getId());
        inquiryDTO.setMessage(inquiry.getMessage());
        inquiryDTO.setUserId(inquiry.getUser().getId());
        inquiryDTO.setPropertyId(inquiry.getProperty().getId());

        return inquiryDTO;
    }

    public static Inquiry InquiryDTOToInquiry(InquiryDTO inquiryDTO) {
        if (inquiryDTO == null) return null;

        Inquiry inquiry = new Inquiry();
        inquiry.setMessage(inquiryDTO.getMessage());

        return inquiry;
    }
}
