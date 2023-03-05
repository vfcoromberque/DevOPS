package br.com.cwi.crescer.bascrescer.repository;

import br.com.cwi.crescer.bascrescer.domain.Conexao;
import br.com.cwi.crescer.bascrescer.domain.Situacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConexaoRepository extends JpaRepository<Conexao,Long> {
    Conexao findBySolicitadoIdAndSolicitadorIdAndSituacao
            (Long s, Long sr, Situacao situacao);

}
