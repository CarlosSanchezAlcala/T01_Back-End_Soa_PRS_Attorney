package com.soa.canete.attorney.domain.mapper;

import com.soa.canete.attorney.domain.dto.AttorneyRequestDto;
import com.soa.canete.attorney.domain.dto.AttorneyResponseDto;
import com.soa.canete.attorney.domain.model.Attorney;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AttorneyMapper {

    public static Attorney toModel(AttorneyRequestDto dto) {
        return new Attorney(
                dto.getName(),
                dto.getSurnamefather(),
                dto.getSurnamemother(),
                dto.getDni(),
                dto.getPhonenumber(),
                dto.getAddress(),
                dto.getEmail(),
                dto.getCodubi(),
                dto.getStatus()
        );
    }

    public static Attorney toModel(AttorneyRequestDto dto, Integer id_attorney) {
        return new Attorney(
                id_attorney,
                dto.getName(),
                dto.getSurnamefather(),
                dto.getSurnamemother(),
                dto.getDni(),
                dto.getPhonenumber(),
                dto.getAddress(),
                dto.getEmail(),
                dto.getCodubi(),
                dto.getStatus()
        );
    }

    public static AttorneyResponseDto toDto(Attorney model) {
        return new AttorneyResponseDto(
                model.getId_attorney(),
                model.getName(),
                model.getSurnamefather(),
                model.getSurnamemother(),
                model.getDni(),
                model.getPhonenumber(),
                model.getAddress(),
                model.getEmail(),
                model.getCodubi(),
                model.getStatus()
        );
    }

}
