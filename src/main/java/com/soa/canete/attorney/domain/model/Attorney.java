package com.soa.canete.attorney.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "attorney")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attorney {

    @Id
    private Integer id_attorney;
    @Column
    private String name;
    @Column("surnamefather")
    private String surnameFather;
    @Column("surnamemother")
    private String surnameMother;
    @Column
    private String dni;
    @Column("phonenumber")
    private String phoneNumber;
    @Column
    private String address;
    @Column
    private String email;
    @Column
    private String codubi;
    @Column
    private String status;

    public Attorney(String name, String surnameFather, String surnameMother, String dni, String phoneNumber,
                    String address, String email, String codubi, String status) {
        this.name = name;
        this.surnameFather = surnameFather;
        this.surnameMother = surnameMother;
        this.dni = dni;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.codubi = codubi;
        this.status = status;
    }
}