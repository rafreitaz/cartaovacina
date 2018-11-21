package com.piuna.CartaoVacinaOnline.service.impl;

import com.piuna.CartaoVacinaOnline.domain.Vacina;
import com.piuna.CartaoVacinaOnline.repository.VacinaRepository;
import com.piuna.CartaoVacinaOnline.service.VacinaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VacinaServiceImpl implements VacinaService {

    private final VacinaRepository vacinaRepository;

    public VacinaServiceImpl(VacinaRepository vacinaRepository) {
        this.vacinaRepository = vacinaRepository;
    }


    @Override
    public List<Vacina> getAll() {
        return this.vacinaRepository.findAll();
    }

    @Override
    public Vacina findOne(Long id) {
        return this.vacinaRepository.recuperaPeloId(id);
    }

    @Override
    public Vacina save(Vacina vacina) {
        return this.vacinaRepository.saveAndFlush(vacina);
    }

    @Override
    public void delete(Long id) {
        this.vacinaRepository.deleteById(id);
    }
}
