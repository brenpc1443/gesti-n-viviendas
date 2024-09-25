package com.gestion.viviendas.domain.service;

import com.gestion.viviendas.domain.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentService {

    @Autowired
    private RentRepository rentRepository;
}
