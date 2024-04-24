package com.elton.awpag.domain.model;

import com.elton.awpag.domain.validation.ValidationGroups;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Parcelamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Valid // para validação em cascata junto com a Entity Cliente
    @ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class)
    @NotNull
    @ManyToOne
    private Cliente cliente;

    @NotBlank
    @Size(max = 20)
    private String descricao;

    @NotNull
    @Positive // apenas numero (valor) positivo
    private BigDecimal valorTotal;

    @NotNull
    @Positive
    @Max(12)
    private Integer quantidadeParcelas;

    private OffsetDateTime dataCriacao;

}