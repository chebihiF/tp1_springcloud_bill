package com.suptech.billservice.dto;

import com.suptech.billservice.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillResponseDTO {
    private Long id ;
    private LocalDate date ;
    private BigDecimal amount;
    private Customer customer;
}
