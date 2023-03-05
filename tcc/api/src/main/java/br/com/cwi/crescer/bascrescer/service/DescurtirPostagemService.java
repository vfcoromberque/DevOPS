package br.com.cwi.crescer.bascrescer.service;

import br.com.cwi.crescer.bascrescer.domain.Curtida;
import br.com.cwi.crescer.bascrescer.domain.Postagem;
import br.com.cwi.crescer.bascrescer.repository.CurtidaRepository;
import br.com.cwi.crescer.bascrescer.security.domain.Usuario;
import br.com.cwi.crescer.bascrescer.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DescurtirPostagemService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private BuscarPostagemService buscarPostagemService;

    @Autowired
    private CurtidaRepository curtidaRepository;

    @Autowired
    private ValidaCurtidaService validaCurtidaService;


    public void descurtir(Long id) {

        Usuario usuario = usuarioAutenticadoService.get();

        Postagem postagem = buscarPostagemService.porId(id);

        Curtida curtida = curtidaRepository.findByUsuarioIdEqualsAndPostagemIdEquals(usuario.getId(), postagem.getId());

        validaCurtidaService.validarDescurtida(curtida);

        curtidaRepository.delete(curtida);

    }
}
