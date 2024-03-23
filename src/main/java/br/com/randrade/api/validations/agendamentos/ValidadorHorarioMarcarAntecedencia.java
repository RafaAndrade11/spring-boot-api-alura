package br.com.randrade.api.validations.agendamentos;

import br.com.randrade.api.dtos.consultas.DadosAgendamentoConsulta;
import br.com.randrade.api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioMarcarAntecedencia implements ValidadorAgendamentoDeConsulta {

    public void validar (DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();

        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora,dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30) {
            throw new ValidacaoException("Consulta deve ser agendada com antecedência mínima de 30 minutos!");
        }
    }
}
