package com.soa.canete.attorney.service;

import com.soa.canete.attorney.domain.dto.AttorneyResponseDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface AttorneyService {

    Mono<AttorneyResponseDto> findById(Integer id_attorney);
    Flux<AttorneyResponseDto> findAllDataAttorney();

}
