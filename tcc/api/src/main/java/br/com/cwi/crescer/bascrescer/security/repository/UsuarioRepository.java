package br.com.cwi.crescer.bascrescer.security.repository;

import br.com.cwi.crescer.bascrescer.security.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    boolean existsByEmail(String email);

    @Query(value = "SELECT u FROM Usuario u WHERE u.id <> :id " +
            "AND (lower(u.nome) LIKE %:text% " +
            "OR lower(u.email) LIKE %:text% " +
            "OR lower(u.apelido) LIKE %:text%)")
    Page<Usuario> findBuscarUsuariosFiltrados(@Param("id") Long id,@Param("text") String text, Pageable pageable);

    @Query(value = "SELECT u FROM Usuario u LEFT JOIN Conexao c ON c.solicitador = u " +
            "LEFT JOIN Conexao co ON co.solicitado = u " +
            "WHERE (c.solicitado = :usuario OR co.solicitador = :usuario) " +
            "AND (c.situacao = 'AMIZADE' OR co.situacao = 'AMIZADE')" +
            "AND (lower(u.nome) LIKE %:text% " +
            "OR lower(u.email) LIKE %:text% " +
            "OR lower(u.apelido) LIKE %:text%)")
    Page<Usuario> findUsuariosAmigos(String text, Usuario usuario, Pageable pageable);

    @Query(value = "SELECT u FROM Usuario u INNER JOIN Conexao c ON c.solicitador = u " +
            "WHERE c.solicitado = :usuario AND c.situacao = 'SOLICITADO'")
    List<Usuario> findUsuariosSolicitntes(Usuario usuario);

}
