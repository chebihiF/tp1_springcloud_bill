package com.suptech.billservice.mappers;

import com.suptech.billservice.dto.BillRequestDTO;
import com.suptech.billservice.dto.BillResponseDTO;
import com.suptech.billservice.entities.Bill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "string")
public interface BillMapper {
    Bill fromBillRequestDTO(BillRequestDTO billRequestDTO);
    BillResponseDTO fromBill(Bill bill);
}
