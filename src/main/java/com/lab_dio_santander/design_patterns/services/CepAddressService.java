package com.lab_dio_santander.design_patterns.services;

import com.lab_dio_santander.design_patterns.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

    @FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
    public interface CepAddressService {

        @GetMapping("/{cep}/json/")
        Address checkCep(@PathVariable("cep") String cep);
    }

