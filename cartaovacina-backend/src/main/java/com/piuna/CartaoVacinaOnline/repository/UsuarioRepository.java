package com.piuna.CartaoVacinaOnline.repository;

import com.piuna.CartaoVacinaOnline.domain.Usuario;
import com.piuna.CartaoVacinaOnline.domain.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Os repositories são interfaces que permitem o acesso ao banco.
 */

@RepositoryRestController
@CrossOrigin(origins = "http://localhost:4200")
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE u.cpf = :cpf")
    Usuario recuperaPeloCpf(@Param("cpf") String cpf);

    @Query("SELECT u FROM Usuario u WHERE u.id = :id")
    Usuario recuperaPeloId(@Param("id") Long id);

    @Query("SELECT u FROM Usuario u " +
            "JOIN u.acesso a " +
            "WHERE a.login LIKE :login " +
            "AND a.senha LIKE :senha")
    Usuario recuperaUsuarioLogin(@Param("login") String login, @Param("senha") String senha);

    @Query("SELECT u.nome FROM Usuario u WHERE u.id = :id")
    String getNomePeloId(@Param("id") Long id);
}
