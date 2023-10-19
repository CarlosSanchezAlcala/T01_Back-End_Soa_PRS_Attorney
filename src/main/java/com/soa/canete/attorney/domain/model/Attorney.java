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
    @Column
    private String surnamefather;
    @Column
    private String surnamemother;
    @Column
    private String dni;
    @Column
    private String phonenumber;
    @Column
    private String address;
    @Column
    private String email;
    @Column
    private String codubi;
    @Column
    private String status;

    public Attorney(String name, String surnamefather, String surnamemother, String dni, String phonenumber,
                    String address, String email, String codubi, String status) {
        this.name = name;
        this.surnamefather = surnamefather;
        this.surnamemother = surnamemother;
        this.dni = dni;
        this.phonenumber = phonenumber;
        this.address = address;
        this.email = email;
        this.codubi = codubi;
        this.status = status;
    }
}