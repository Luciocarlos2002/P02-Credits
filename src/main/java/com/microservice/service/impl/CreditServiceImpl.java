package com.microservice.service.impl;

import com.microservice.model.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditServiceImpl {

    Flux<Credit> getAllCredits();

    Mono<Credit> getByIdCredit(String id);

    Mono<Credit> createCredit(Credit credit);

}
