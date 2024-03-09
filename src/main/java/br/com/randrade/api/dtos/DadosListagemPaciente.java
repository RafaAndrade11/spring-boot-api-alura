package br.com.randrade.api.dtos;

import br.com.randrade.api.domain.Paciente;

public record DadosListagemPaciente(Long id, String nome, String email, String telefone) {
    public DadosListagemPaciente (Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone());
    }
}
