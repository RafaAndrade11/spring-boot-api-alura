package br.com.randrade.api.dtos.medicos;

import br.com.randrade.api.domain.Endereco;
import br.com.randrade.api.domain.Medico;
import br.com.randrade.api.enums.Especialidade;

public record DadosDetalhesMedico(Long id, String nome, String email, String crm, String telefone, Especialidade especialidade, Endereco endereco) {

    public DadosDetalhesMedico (Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(),medico.getEspecialidade(), medico.getEndereco());
    }
}
