package com.soa.canete.attorney.web;

import com.soa.canete.attorney.domain.dto.AttorneyResponseDto;
import com.soa.canete.attorney.repository.AttorneyRepository;
import com.soa.canete.attorney.service.AttorneyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

}
