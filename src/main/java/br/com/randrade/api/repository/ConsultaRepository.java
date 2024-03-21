package br.com.randrade.api.repository;

import br.com.randrade.api.domain.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
