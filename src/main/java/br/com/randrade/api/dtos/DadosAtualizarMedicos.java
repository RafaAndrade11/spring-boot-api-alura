package br.com.randrade.api.dtos;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarMedicos(
        @NotNull Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
