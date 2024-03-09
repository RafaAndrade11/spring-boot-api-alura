package br.com.randrade.api.paciente;

import br.com.randrade.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarPaciente(
        @NotNull Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
