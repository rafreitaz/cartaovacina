package com.piuna.CartaoVacinaOnline.service;

import com.piuna.CartaoVacinaOnline.domain.AplicacaoVacina;
import com.piuna.CartaoVacinaOnline.domain.Clinica;
import com.piuna.CartaoVacinaOnline.dto.AplicacaoVacinaDTO;

import java.util.List;

public interface AplicacaoService {

    List<AplicacaoVacinaDTO> getAll(Long idUsuario);

    AplicacaoVacina save(AplicacaoVacina aplicacao) throws Exception;

    void delete(Long id);

}
