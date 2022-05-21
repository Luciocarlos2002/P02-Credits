package com.microservice.service;

import com.microservice.model.Credit;
import com.microservice.repository.CreditRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreditService {

    private final CreditRepository creditRepository;

    public Flux<Credit> getAllCredit(){
        return creditRepository.findAll();
    }

    public Mono<Credit> getCreditById(String id){
        return creditRepository.findById(id);
    }

    public Mono<Credit> createCredit(Credit credit){
        return creditRepository.save(credit);
    }

}
