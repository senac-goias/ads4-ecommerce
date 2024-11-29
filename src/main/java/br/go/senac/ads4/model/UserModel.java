package br.go.senac.ads4.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "[user]")
//@Table(name = "NOME_DA_TABELA")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 100)
    private String surname;

    @Column(name = "LOCATION", length = 100)
    private String location;

    @Column(name = "CITY", length = 100, nullable = false)
    private String city;

    @Column(name = "STATE", length = 100,  nullable = false)
    private String state;
}
