package br.com.randrade.api.validations.agendamentos;

import br.com.randrade.api.dtos.consultas.DadosAgendamentoConsulta;
import br.com.randrade.api.infra.exception.ValidacaoException;
import br.com.randrade.api.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;
    public void validar (DadosAgendamentoConsulta dados) {

        var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(),dados.data());
        if (medicoPossuiOutraConsultaNoMesmoHorario) {
            throw new ValidacaoException("Médico já possui outra consulta agendada no mesmo horário");
        }

    }
}
