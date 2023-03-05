package br.com.cwi.crescer.bascrescer.service;

import br.com.cwi.crescer.bascrescer.domain.Curtida;
import br.com.cwi.crescer.bascrescer.domain.Postagem;
import br.com.cwi.crescer.bascrescer.repository.CurtidaRepository;
import br.com.cwi.crescer.bascrescer.security.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidaCurtidaService {

    @Autowired
    private CurtidaRepository curtidaRepository;


    public void validarCurtida(Usuario usuario, Postagem postagem) {

        if(isNull(usuario))
            throw new ResponseStatusException(BAD_REQUEST, "Esse usuario não existe.");

        if(isNull(postagem))
            throw new ResponseStatusException(BAD_REQUEST, "Essa postagem não existe.");

        Curtida curtida = curtidaRepository.findByUsuarioIdEqualsAndPostagemIdEquals(usuario.getId(), postagem.getId());

        if(nonNull(curtida))
            throw new ResponseStatusException(BAD_REQUEST, "Esse usuario ja curtiu essa postagem.");

    }

    public void validarDescurtida(Curtida curtida) {

        if(isNull(curtida))
            throw new ResponseStatusException(BAD_REQUEST, "Esse usuario não curtiu esse post para poder descurti-lo.");

    }
}
