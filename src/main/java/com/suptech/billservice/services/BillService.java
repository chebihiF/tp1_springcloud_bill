package com.suptech.billservice.services;

import com.suptech.billservice.dto.BillRequestDTO;
import com.suptech.billservice.dto.BillResponseDTO;

import java.util.List;

public interface BillService {
    BillResponseDTO save(BillRequestDTO billRequestDTO);
    BillResponseDTO getBill(Long id);
    List<BillResponseDTO> billByCustomerID(Long customerID);
}
