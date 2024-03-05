package br.com.randrade.api.paciente;

import br.com.randrade.api.endereco.DadosEndereco;

public record DadosCadastroPaciente(
        String nome,
        String email,
        String telefone,
        String CPF,
        DadosEndereco endereco
) {
}
