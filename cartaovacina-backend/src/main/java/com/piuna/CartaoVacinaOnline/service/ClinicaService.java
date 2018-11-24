package com.piuna.CartaoVacinaOnline.service;

import com.piuna.CartaoVacinaOnline.domain.Clinica;
import com.piuna.CartaoVacinaOnline.domain.Usuario;

import java.util.List;

public interface ClinicaService {

    List<Clinica> getAll();

    Clinica recuperaPeloId(Long id);

    Clinica save(Clinica clinica) throws Exception;

    void delete(Long id);

}
