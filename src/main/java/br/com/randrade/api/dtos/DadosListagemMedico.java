package br.com.randrade.api.dtos;

import br.com.randrade.api.domain.Medico;
import br.com.randrade.api.enums.Especialidade;

public record DadosListagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public DadosListagemMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
