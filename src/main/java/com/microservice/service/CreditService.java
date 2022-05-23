package com.microservice.service;

import com.microservice.model.Credit;
import com.microservice.repository.CreditRepository;
import com.microservice.service.impl.CreditServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreditService implements CreditServiceImpl {

    private final CreditRepository creditRepository;


    @Override
    public Flux<Credit> getAllCredits() {
        return creditRepository.findAll();
    }

    @Override
    public Mono<Credit> getByIdCredit(String id) {
        return creditRepository.findById(id);
    }

    @Override
    public Mono<Credit> createCredit(Credit credit) {
        return creditRepository.save(credit);
    }
}
