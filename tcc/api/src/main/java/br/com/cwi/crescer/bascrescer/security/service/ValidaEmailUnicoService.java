package br.com.cwi.crescer.bascrescer.security.service;

import br.com.cwi.crescer.bascrescer.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidaEmailUnicoService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public void validar(String email) {
        if(usuarioRepository.existsByEmail(email))
            throw new ResponseStatusException(BAD_REQUEST, "Email ja utilizado");
    }

}
