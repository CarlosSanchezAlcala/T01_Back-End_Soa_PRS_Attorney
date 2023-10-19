package com.soa.canete.attorney.service.impl;

import com.soa.canete.attorney.domain.dto.AttorneyResponseDto;
import com.soa.canete.attorney.domain.mapper.AttorneyMapper;
import com.soa.canete.attorney.domain.model.Attorney;
import com.soa.canete.attorney.repository.AttorneyRepository;
import com.soa.canete.attorney.service.AttorneyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@Slf4j
@Service
@RequiredArgsConstructor
public class AttorneyImpl implements AttorneyService {

    final AttorneyRepository attorneyRepository;

    @Override
    public Mono<AttorneyResponseDto> findById(Integer id_attorney) {
        return this.attorneyRepository.findById(id_attorney)
                .map(AttorneyMapper::toDto);
    }

    @Override
    public Flux<AttorneyResponseDto> findAllDataAttorney() {
        return this.attorneyRepository.findAll()
                .sort(Comparator.comparing(Attorney::getId_attorney).reversed())
                .map(AttorneyMapper::toDto);
    }
}
