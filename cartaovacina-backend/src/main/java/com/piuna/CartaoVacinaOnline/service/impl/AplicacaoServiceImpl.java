package com.piuna.CartaoVacinaOnline.service.impl;

import com.piuna.CartaoVacinaOnline.domain.Acesso;
import com.piuna.CartaoVacinaOnline.domain.AplicacaoVacina;
import com.piuna.CartaoVacinaOnline.domain.Clinica;
import com.piuna.CartaoVacinaOnline.domain.Usuario;
import com.piuna.CartaoVacinaOnline.domain.Vacina;
import com.piuna.CartaoVacinaOnline.dto.AplicacaoVacinaDTO;
import com.piuna.CartaoVacinaOnline.mapper.AplicacaoMapper;
import com.piuna.CartaoVacinaOnline.repository.AplicacaoRepository;
import com.piuna.CartaoVacinaOnline.repository.ClinicaRepository;
import com.piuna.CartaoVacinaOnline.repository.UsuarioRepository;
import com.piuna.CartaoVacinaOnline.repository.VacinaRepository;
import com.piuna.CartaoVacinaOnline.service.AplicacaoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AplicacaoServiceImpl implements AplicacaoService {

    private final AplicacaoRepository aplicacaoRepository;

    private final ClinicaRepository clinicaRepository;

    private final UsuarioRepository usuarioRepository;

    private final VacinaRepository vacinaRepository;

    private final AplicacaoMapper aplicacaoMapper;

    public AplicacaoServiceImpl(AplicacaoRepository aplicacaoRepository, ClinicaRepository clinicaRepository,
                                UsuarioRepository usuarioRepository, VacinaRepository vacinaRepository,
                                AplicacaoMapper aplicacaoMapper) {
        this.aplicacaoRepository = aplicacaoRepository;
        this.clinicaRepository = clinicaRepository;
        this.usuarioRepository = usuarioRepository;
        this.vacinaRepository = vacinaRepository;
        this.aplicacaoMapper = aplicacaoMapper;
    }

    @Override
    public List<AplicacaoVacinaDTO> getAll(Long idUsuario) {
        return this.aplicacaoRepository.recuperaListagemPeloIdUsuario(idUsuario)
                .stream().map(aplicacaoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AplicacaoVacina save(AplicacaoVacina aplicacao) throws Exception {
        validaUsuarioTomouVacina(aplicacao);
        preProcessSave(aplicacao);
        return this.aplicacaoRepository.save(aplicacao);
    }

    @Override
    public void delete(Long id) {
        this.aplicacaoRepository.deleteById(id);
    }

    private void preProcessSave(AplicacaoVacina aplicacao) {
        Usuario usuario = usuarioRepository.recuperaPeloId(aplicacao.getUsuario().getId());
        Vacina vacina = vacinaRepository.recuperaPeloId(aplicacao.getVacina().getId());
        Clinica clinica = clinicaRepository.recuperaPeloId(aplicacao.getClinica().getId());
        aplicacao.setUsuario(usuario);
        aplicacao.setVacina(vacina);
        aplicacao.setClinica(clinica);
    }

    private void validaUsuarioTomouVacina(AplicacaoVacina aplicacao) throws Exception {
        if (this.aplicacaoRepository.recuperaPeloUsuarioEVacina(aplicacao.getUsuario().getId(),
                aplicacao.getVacina().getId()) != 0) {
            throw new Exception("Já existe um registro da vacina selecionada para o usuário.");
        }
    }
}
