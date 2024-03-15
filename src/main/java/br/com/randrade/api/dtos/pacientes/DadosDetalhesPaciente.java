package br.com.randrade.api.dtos.pacientes;

import br.com.randrade.api.domain.Endereco;
import br.com.randrade.api.domain.Paciente;

public record DadosDetalhesPaciente(Long id, String nome, String email, String telefone, String cpf, Endereco endereco) {

    public DadosDetalhesPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }
}
