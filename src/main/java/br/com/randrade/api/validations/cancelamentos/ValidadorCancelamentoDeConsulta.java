package br.com.randrade.api.validations.cancelamentos;

import br.com.randrade.api.dtos.consultas.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoDeConsulta {

    void validar(DadosCancelamentoConsulta dados);

}
