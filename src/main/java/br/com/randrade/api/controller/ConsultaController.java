package br.com.randrade.api.controller;

import br.com.randrade.api.dtos.consultas.DadosAgendamentoConsulta;
import br.com.randrade.api.dtos.consultas.DadosCancelamentoConsulta;
import br.com.randrade.api.dtos.consultas.DadosDetalhamentoConsulta;
import br.com.randrade.api.repository.ConsultaRepository;
import br.com.randrade.api.services.AgendaDeConsultas;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultas agendaDeConsultas;

    @Autowired
    private ConsultaRepository consultaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados) {
        agendaDeConsultas.agendar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoConsulta(null,null,null,null));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados) {
        agendaDeConsultas.cancelar(dados);
        return ResponseEntity.noContent().build();
    }

}
