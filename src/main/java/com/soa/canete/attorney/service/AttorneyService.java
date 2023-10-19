package com.soa.canete.attorney.service;

import com.soa.canete.attorney.domain.dto.AttorneyRequestDto;
import com.soa.canete.attorney.domain.dto.AttorneyResponseDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface AttorneyService {

    Mono<AttorneyResponseDto> findById(Integer id_attorney);
    Flux<AttorneyResponseDto> findAllDataAttorney();
    Flux<AttorneyResponseDto> findDataAttorneyActive();
    Flux<AttorneyResponseDto> findDataAttorneyInactive();
    Mono<AttorneyResponseDto> saveNewAttorney(AttorneyRequestDto request);
    Mono<AttorneyResponseDto> updateAttorney(AttorneyRequestDto request, Integer id_attorney);
    Mono<AttorneyResponseDto> deleteLogicalAttorney(Integer id_attorney);
    Mono<AttorneyResponseDto> reactiveLogicalAttorney(Integer id_attorney);
    Mono<Void> deleteAttorney(Integer id_attorney);

}
