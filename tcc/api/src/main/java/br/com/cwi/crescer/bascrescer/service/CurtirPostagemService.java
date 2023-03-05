package br.com.cwi.crescer.bascrescer.service;

import br.com.cwi.crescer.bascrescer.controller.response.IdResponse;
import br.com.cwi.crescer.bascrescer.domain.Curtida;
import br.com.cwi.crescer.bascrescer.domain.Postagem;
import br.com.cwi.crescer.bascrescer.mapper.IdResponseMapper;
import br.com.cwi.crescer.bascrescer.repository.CurtidaRepository;
import br.com.cwi.crescer.bascrescer.security.domain.Usuario;
import br.com.cwi.crescer.bascrescer.security.service.UsuarioAutenticadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurtirPostagemService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private BuscarPostagemService buscarPostagemService;

    @Autowired
    private CurtidaRepository curtidaRepository;

    @Autowired
    private ValidaCurtidaService validaCurtidaService;


    public IdResponse curtir(Long id) {

        Usuario usuario = usuarioAutenticadoService.get();

        Postagem postagem = buscarPostagemService.porId(id);

        validaCurtidaService.validarCurtida(usuario, postagem);

        Curtida curtida = Curtida.builder()
                .usuario(usuario)
                .postagem(postagem)
                .build();

        curtidaRepository.save(curtida);

        return IdResponseMapper.toResponse(curtida.getId());

    }
}
