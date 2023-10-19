package com.soa.canete.attorney.service.impl;

import com.soa.canete.attorney.domain.dto.AttorneyRequestDto;
import com.soa.canete.attorney.domain.dto.AttorneyResponseDto;
import com.soa.canete.attorney.domain.mapper.AttorneyMapper;
import com.soa.canete.attorney.domain.model.Attorney;
import com.soa.canete.attorney.exception.ResourceNotFoundException;
import com.soa.canete.attorney.repository.AttorneyRepository;
import com.soa.canete.attorney.service.AttorneyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

import static com.soa.canete.attorney.domain.mapper.AttorneyMapper.toModel;

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

    @Override
    public Flux<AttorneyResponseDto> findDataAttorneyActive() {
        return this.attorneyRepository.findAll()
                .sort(Comparator.comparing(Attorney::getId_attorney).reversed())
                .filter((active) -> active.getStatus().equals("A"))
                .map(AttorneyMapper::toDto);
    }

    @Override
    public Flux<AttorneyResponseDto> findDataAttorneyInactive() {
        return this.attorneyRepository.findAll()
                .sort(Comparator.comparing(Attorney::getId_attorney).reversed())
                .filter((active) -> active.getStatus().equals("I"))
                .map(AttorneyMapper::toDto);
    }

    @Override
    public Mono<AttorneyResponseDto> saveNewAttorney(AttorneyRequestDto request) {
        return this.attorneyRepository.save(toModel(request))
                .map(AttorneyMapper::toDto);
    }

    @Override
    public Mono<AttorneyResponseDto> updateAttorney(AttorneyRequestDto request, Integer id_attorney) {
        return this.attorneyRepository.findById(id_attorney)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("El identificador: " + id_attorney + "no fue encontrado.")))
                .flatMap((dataAttorney) -> this.attorneyRepository.save(toModel(request, dataAttorney.getId_attorney())))
                .map(AttorneyMapper::toDto);

    }

    @Override
    public Mono<AttorneyResponseDto> deleteLogicalAttorney(Integer id_attorney) {
        return this.attorneyRepository.findById(id_attorney)
                .map((delete) -> {
                    delete.setStatus("I");
                    return delete;
                })
                .flatMap(attorneyRepository::save)
                .map(AttorneyMapper::toDto);
    }

    @Override
    public Mono<AttorneyResponseDto> reactiveLogicalAttorney(Integer id_attorney) {
        return this.attorneyRepository.findById(id_attorney)
                .map((delete) -> {
                    delete.setStatus("A");
                    return delete;
                })
                .flatMap(attorneyRepository::save)
                .map(AttorneyMapper::toDto);
    }

    @Override
    public Mono<Void> deleteAttorney(Integer id_attorney) {
        return this.attorneyRepository.deleteById(id_attorney);
    }
}
