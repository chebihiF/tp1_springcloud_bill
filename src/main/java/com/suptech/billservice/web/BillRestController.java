package com.suptech.billservice.web;

import com.suptech.billservice.dto.BillResponseDTO;
import com.suptech.billservice.services.BillService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class BillRestController {

    private final BillService billService;

    public BillRestController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/bills/{id}")
    public BillResponseDTO getBill(@PathVariable(name = "id") Long id){
        return billService.getBill(id);
    }

    @GetMapping("/billsByCustomer/{id}")
    public List<BillResponseDTO> getBillsByCustomer(@PathVariable(name = "id") Long customerId){
        return billService.billByCustomerID(customerId);
    }
}
