package br.com.randrade.api.controller;

import br.com.randrade.api.domain.Endereco;
import br.com.randrade.api.domain.Medico;
import br.com.randrade.api.dtos.endereco.DadosEndereco;
import br.com.randrade.api.dtos.medicos.DadosCadastroMedico;
import br.com.randrade.api.dtos.medicos.DadosDetalhesMedico;
import br.com.randrade.api.enums.Especialidade;
import br.com.randrade.api.repository.MedicoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
    @AutoConfigureMockMvc
    @AutoConfigureJsonTesters
    class MedicoControllerTest {

        @Autowired
        private MockMvc mvc;

        @Autowired
        private JacksonTester<DadosCadastroMedico> dadosCadastroMedicoJson;

        @Autowired
        private JacksonTester<DadosDetalhesMedico> dadosDetalhamentoMedicoJson;

        @MockBean
        private MedicoRepository repository;

        @Test
        @DisplayName("Deveria devolver codigo http 400 quando informacoes estao invalidas")
        @WithMockUser
        void cadastrar_cenario1() throws Exception {
            var response = mvc
                    .perform(post("/medicos"))
                    .andReturn().getResponse();

            assertThat(response.getStatus())
                    .isEqualTo(HttpStatus.BAD_REQUEST.value());
        }
    @Test
    @DisplayName("Deveria devolver codigo http 200 quando informacoes estao validas")
    @WithMockUser
    void cadastrar_cenario2() throws Exception {
        var dadosCadastro = new DadosCadastroMedico(
                "Medico",
                "medico@voll.med",
                "61999999999",
                "123456",
                Especialidade.CARDIOLOGIA,
                dadosEndereco());

        when(repository.save(any())).thenReturn(new Medico(dadosCadastro));

        var response = mvc
                .perform(post("/medicos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(dadosCadastroMedicoJson.write(dadosCadastro).getJson()))
                .andReturn().getResponse();

        var dadosDetalhamento = new DadosDetalhesMedico(
                null,
                dadosCadastro.nome(),
                dadosCadastro.email(),
                dadosCadastro.crm(),
                dadosCadastro.telefone(),
                dadosCadastro.especialidade(),
                new Endereco(dadosCadastro.endereco())
        );
        var jsonEsperado = dadosDetalhamentoMedicoJson.write(dadosDetalhamento).getJson();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);
    }

    private DadosEndereco dadosEndereco() {
        return new DadosEndereco(
                "rua teste",
                "bairro teste",
                "00000000",
                "Rio de Janeiro",
                "RJ",
                null,
                null
        );
    }
}