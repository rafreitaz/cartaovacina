package com.piuna.CartaoVacinaOnline.service;

import com.piuna.CartaoVacinaOnline.domain.AplicacaoVacina;
import com.piuna.CartaoVacinaOnline.domain.Clinica;
import com.piuna.CartaoVacinaOnline.dto.AplicacaoVacinaDTO;
import net.sf.jasperreports.engine.JRException;
import org.springframework.core.io.InputStreamResource;

import java.util.List;

public interface AplicacaoService {

    List<AplicacaoVacinaDTO> getAll(Long idUsuario);

    AplicacaoVacina save(AplicacaoVacina aplicacao) throws Exception;

    byte[] generatePDFReport(Long idUsuario) throws JRException;

    void delete(Long id);

}
