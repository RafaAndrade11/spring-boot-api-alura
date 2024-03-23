package br.com.randrade.api.validations;

import br.com.randrade.api.dtos.consultas.DadosAgendamentoConsulta;
import br.com.randrade.api.infra.exception.ValidacaoException;
import br.com.randrade.api.repository.PacienteRepository;

public class ValidadorPacienteAtivo {

    private PacienteRepository repository;
    public void validar (DadosAgendamentoConsulta dados) {
        var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
        if (!pacienteEstaAtivo) {
            throw new ValidacaoException("Consulta não pode ser agendada com paciente excluído!");
        }
    }
}
