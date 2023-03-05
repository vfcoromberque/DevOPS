package br.com.cwi.crescer.bascrescer.repository;

import br.com.cwi.crescer.bascrescer.domain.Postagem;
import br.com.cwi.crescer.bascrescer.security.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostagemRepository extends JpaRepository<Postagem,Long> {

    @Query(value = "SELECT DISTINCT p FROM Postagem p INNER JOIN Usuario u ON p.usuario = u " +
            "LEFT JOIN Conexao c ON c.solicitador = u " +
            "LEFT JOIN Conexao co ON co.solicitado = u " +
            "WHERE (c.solicitado = :usuario OR co.solicitador = :usuario OR u = :usuario) " +
            "AND (c.situacao = 'AMIZADE' OR co.situacao = 'AMIZADE')")
    Page<Postagem> findFeedUsuario(Usuario usuario, Pageable pageable);

    @Query(value = "SELECT DISTINCT p FROM Postagem p INNER JOIN Usuario u ON p.usuario = :donoPerfil " +
            "LEFT JOIN Conexao c ON c.solicitado = :donoPerfil " +
            "LEFT JOIN Conexao co ON co.solicitador = :donoPerfil " +
            "WHERE (:usuario = :donoPerfil) OR " +
            "(c.solicitador = :usuario AND c.situacao = 'AMIZADE') OR " +
            "(co.solicitado = :usuario AND co.situacao = 'AMIZADE') OR " +
            "p.visualizacao <> 'PRIVADO'")
    Page<Postagem> findPostagensPermitidas(Usuario usuario, Usuario donoPerfil, Pageable pageable);
}
