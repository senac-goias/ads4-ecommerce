package br.go.senac.ads4.model;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table
public class ShipperModel {
//    id,nome,descricao
    @Id
    @SequenceGenerator(name="shipper_seq_gen",
            sequenceName="shipper_sequence",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="shipper_seq_gen")
    private Integer id;


    @Column(name = "NOME")
    private String nome;

    @Column(name ="DESCRICAO", columnDefinition = "TEXT")
    private String descricao;
}





