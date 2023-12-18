package com.soa.canete.attorney.web;

import com.soa.canete.attorney.domain.dto.AttorneyRequestDto;
import com.soa.canete.attorney.domain.dto.AttorneyResponseDto;
import com.soa.canete.attorney.repository.AttorneyRepository;
import com.soa.canete.attorney.service.AttorneyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/attorneyData")
@RequiredArgsConstructor
public class AttorneyController {

    final AttorneyService attorneyService;
    final AttorneyRepository attorneyRepository;

    @GetMapping("{id_attorney}")
    public Mono<AttorneyResponseDto> getDataAttorneyById(@PathVariable Integer id_attorney) {
        return this.attorneyService.findById(id_attorney);
    }

    @GetMapping("/listData")
    public Flux<AttorneyResponseDto> getDataCompleteAttorney() {
        return this.attorneyService.findAllDataAttorney();
    }

    @GetMapping("/listData/active")
    public Flux<AttorneyResponseDto> getDataCompleteAttorneyActive() {
        return this.attorneyService.findDataAttorneyActive();
    }

    @GetMapping("/listData/inactive")
    public Flux<AttorneyResponseDto> getDataCompleteAttorneyInactive() {
        return this.attorneyService.findDataAttorneyInactive();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Mono<AttorneyResponseDto> createDataAttorney(@RequestBody AttorneyRequestDto dto) {
        return this.attorneyService.saveNewAttorney(dto);
    }

    @PutMapping("/{id_attorney}")
    public Mono<AttorneyResponseDto> updateDataAttorney(@RequestBody AttorneyRequestDto dto, @PathVariable Integer id_attorney) {
        return this.attorneyService.updateAttorney(dto, id_attorney);
    }

    @PatchMapping("/deleteLogical/{id_attorney}")
    public Mono<AttorneyResponseDto> deleteLogicalAttorney(@PathVariable Integer id_attorney) {
        return this.attorneyService.deleteLogicalAttorney(id_attorney);
    }

    @PatchMapping("/reactiveLogical/{id_attorney}")
    public Mono<AttorneyResponseDto> reactiveLogicalAttorney(@PathVariable Integer id_attorney) {
        return this.attorneyService.reactiveLogicalAttorney(id_attorney);
    }

    @DeleteMapping("/{id_attorney}")
    public Mono<Void> deleteAttorney(@PathVariable Integer id_attorney) {
        return this.attorneyService.deleteAttorney(id_attorney);
    }

}
