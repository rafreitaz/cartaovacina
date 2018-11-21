package com.piuna.CartaoVacinaOnline.service;

import com.piuna.CartaoVacinaOnline.domain.Usuario;
import com.piuna.CartaoVacinaOnline.domain.Vacina;

import java.util.List;

public interface UsuarioService {

    List<Usuario> getAll();

    Usuario findOne(String cpf);

    Usuario recuperaPeloId(Long id);

    Usuario save(Usuario usuario);

    void delete(Long id);

}
