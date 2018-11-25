package com.piuna.CartaoVacinaOnline.service.impl;

import com.piuna.CartaoVacinaOnline.domain.Acesso;
import com.piuna.CartaoVacinaOnline.domain.Clinica;
import com.piuna.CartaoVacinaOnline.domain.Usuario;
import com.piuna.CartaoVacinaOnline.repository.AcessoRepository;
import com.piuna.CartaoVacinaOnline.repository.ClinicaRepository;
import com.piuna.CartaoVacinaOnline.service.ClinicaService;
import com.piuna.CartaoVacinaOnline.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClinicaServiceImpl implements ClinicaService {

    private final ClinicaRepository clinicaRepository;

    private final AcessoRepository acessoRepository;

    public ClinicaServiceImpl(ClinicaRepository clinicaRepository, AcessoRepository acessoRepository) {
        this.clinicaRepository = clinicaRepository;
        this.acessoRepository = acessoRepository;
    }

    @Override
    public List<Clinica> getAll() {
        return this.clinicaRepository.findAll();
    }

    @Override
    public Clinica recuperaPeloId(Long id) {
        return this.clinicaRepository.recuperaPeloId(id);
    }

    @Override
    public Clinica recuperaClinicaLogin(String login, String senha) {
        return this.clinicaRepository.recuperaUsuarioLogin(login, senha);
    }

    @Override
    public Clinica save(Clinica clinica) throws Exception {
        validaCNPJ(clinica.getCnpj());
        validaLogin(clinica.getAcesso().getLogin());
        Acesso acesso = preProcessAcesso(clinica);
        clinica.setAcesso(acesso);
        return this.clinicaRepository.save(clinica);
    }

    @Override
    public void delete(Long id) {
        this.clinicaRepository.deleteById(id);
    }

    private Acesso preProcessAcesso(Clinica clinica) {
        Acesso acesso = new Acesso();
        acesso.setLogin(clinica.getAcesso().getLogin());
        acesso.setSenha(clinica.getAcesso().getSenha());
        acesso.setTipoAcesso("C");
        return this.acessoRepository.save(acesso);
    }

    private void validaLogin(String login) throws Exception {
        if (this.acessoRepository.recuperaCountLogin(login) != 0) {
            throw new Exception("Login informado já existe. Favor escolher outro.");
        }
    }

    private void validaCNPJ(String cnpj) throws Exception {
        if (this.clinicaRepository.recuperaPeloCnpj(cnpj) != 0) {
            throw new Exception("Já existe uma clínica cadastrada com o CNPJ informado.");
        }
    }
}
