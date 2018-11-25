package com.piuna.CartaoVacinaOnline.repository;

import com.piuna.CartaoVacinaOnline.domain.AplicacaoVacina;
import com.piuna.CartaoVacinaOnline.domain.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

/**
 * Os repositories são interfaces que permitem o acesso ao banco.
 */

@RepositoryRestController
@CrossOrigin(origins = "http://localhost:4200")
public interface AplicacaoRepository extends JpaRepository<AplicacaoVacina, Long> {

    @Query("SELECT a FROM AplicacaoVacina a " +
            "JOIN a.usuario usuario " +
            "WHERE usuario.id = :id")
    List<AplicacaoVacina> recuperaListagemPeloIdUsuario(@Param("id") Long id);

    @Query("SELECT COUNT(a.id) FROM AplicacaoVacina a " +
            "JOIN a.usuario usuario " +
            "JOIN a.vacina vacina " +
            "WHERE usuario.id = :idUsuario AND vacina.id = :idVacina")
    Long recuperaPeloUsuarioEVacina(@Param("idUsuario") Long idUsuario, @Param("idVacina") Long idVacina);
}
