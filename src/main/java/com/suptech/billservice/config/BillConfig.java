package com.suptech.billservice.config;

import com.suptech.billservice.dto.BillRequestDTO;
import com.suptech.billservice.services.BillService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class BillConfig {

    private final BillService billService;

    public BillConfig(BillService billService) {
        this.billService = billService;
    }

    @Bean
    public CommandLineRunner init_bills(){
        return args -> {
            billService.save(new BillRequestDTO(BigDecimal.valueOf(92000),1L));
            billService.save(new BillRequestDTO(BigDecimal.valueOf(102001),1L));
            billService.save(new BillRequestDTO(BigDecimal.valueOf(2000),12L));
        };
    }
}
