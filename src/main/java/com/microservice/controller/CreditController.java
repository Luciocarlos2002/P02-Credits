package com.microservice.controller;

import com.microservice.model.Credit;
import com.microservice.service.CreditService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/credit")
public class CreditController {

    private final CreditService creditService;

    private static final String CREDIT = "credit";

    @GetMapping(value = "/allCredits")
    public Flux<Credit> getAllCredits(){
        return creditService.getAllCredits();
    }

    @GetMapping(value = "/{id}")
    public Mono<Credit> getCreditById(@PathVariable String id){
        return creditService.getByIdCredit(id);
    }

    @PostMapping(value = "/create")
    @CircuitBreaker(name = CREDIT, fallbackMethod = "credit")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Credit> createCredit(@RequestBody Credit credit){
        return creditService.createCredit(credit);
    }

}
