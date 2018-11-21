package com.piuna.CartaoVacinaOnline.service;

import com.piuna.CartaoVacinaOnline.domain.Vacina;

import java.util.List;

public interface VacinaService {

    List<Vacina> getAll();

    Vacina findOne(Long id);

    Vacina save(Vacina vacina);

    void delete(Long id);

}
