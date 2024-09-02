package com.umair.PropertyManagement.mapper;

import com.umair.PropertyManagement.model.Inquiry;
import com.umair.PropertyManagement.model.dto.InquiryDTO;

public class InquiryMapper {

    public static InquiryDTO InquiryToInquiryDTO(Inquiry inquiry) {
        if (inquiry == null) return null;

        InquiryDTO inquiryDTO = new InquiryDTO();
        inquiryDTO.setMessage(inquiry.getMessage());

        return inquiryDTO;
    }

    public static Inquiry InquiryDTOToInquiry(InquiryDTO inquiryDTO) {
        if (inquiryDTO == null) return null;

        Inquiry inquiry = new Inquiry();
        inquiry.setMessage(inquiryDTO.getMessage());

        return inquiry;
    }
}
