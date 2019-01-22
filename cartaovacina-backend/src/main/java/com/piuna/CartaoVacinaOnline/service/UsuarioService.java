package com.piuna.CartaoVacinaOnline.service;

import com.piuna.CartaoVacinaOnline.domain.Usuario;
import com.piuna.CartaoVacinaOnline.domain.Vacina;

import java.util.List;

public interface UsuarioService {

    List<Usuario> getAll();

    Usuario findOne(String cpf);

    Usuario recuperaPeloId(Long id);

    Usuario recuperaUsuarioLogin(String login, String senha);

    Usuario save(Usuario usuario) throws Exception;

    void delete(Long id);

    String getNomePeloId(Long id);

}
