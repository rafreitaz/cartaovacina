package com.piuna.CartaoVacinaOnline.repository;

import com.piuna.CartaoVacinaOnline.domain.Acesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface AcessoRepository extends JpaRepository<Acesso, Long> {

    @Query("SELECT COUNT(a.id) FROM Acesso a WHERE a.login LIKE :login")
    Long recuperaCountLogin(@Param("login") String login);

}
