package com.suptech.billservice.services;

import com.suptech.billservice.dto.BillRequestDTO;
import com.suptech.billservice.dto.BillResponseDTO;
import com.suptech.billservice.entities.Bill;
import com.suptech.billservice.entities.Customer;
import com.suptech.billservice.mappers.BillMapper;
import com.suptech.billservice.openfeign.CustomerRestClient;
import com.suptech.billservice.repositories.BillRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;
    private final BillMapper billMapper;
    private final CustomerRestClient customerRestClient;

    public BillServiceImpl(BillRepository billRepository, BillMapper billMapper, CustomerRestClient customerRestClient) {
        this.billRepository = billRepository;
        this.billMapper = billMapper;
        this.customerRestClient = customerRestClient;
    }

    @Override
    public BillResponseDTO save(BillRequestDTO billRequestDTO) {
        Bill bill = billMapper.fromBillRequestDTO(billRequestDTO);
        Bill saveBill = billRepository.save(bill);
        bill.setDate(LocalDate.now());
        return billMapper.fromBill(saveBill);
    }

    @Override
    public BillResponseDTO getBill(Long id) {
        Bill bill = billRepository.findById(id).get();
        Customer customer = customerRestClient.getCustomer(bill.getCustomerID());
        bill.setCustomer(customer);
        return billMapper.fromBill(bill);
    }

    @Override
    public List<BillResponseDTO> billByCustomerID(Long customerID) {
        List<Bill> bills = billRepository.findByCustomerID(customerID);
        return bills.stream().map(billMapper::fromBill).collect(Collectors.toList());
    }
}
