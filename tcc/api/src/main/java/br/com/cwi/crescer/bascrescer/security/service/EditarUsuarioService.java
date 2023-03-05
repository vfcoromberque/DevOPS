package br.com.cwi.crescer.bascrescer.security.service;

import br.com.cwi.crescer.bascrescer.security.controller.request.EditarUsuarioRequest;
import br.com.cwi.crescer.bascrescer.security.domain.Usuario;
import br.com.cwi.crescer.bascrescer.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
public class EditarUsuarioService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public void editar(EditarUsuarioRequest request) {

        Usuario usuario = usuarioAutenticadoService.get();

        if(nonNull(request.getNome()))
            usuario.setNome(request.getNome());

        if(nonNull(request.getApelido()))
            usuario.setApelido(request.getApelido());

        if(nonNull(request.getImg()))
            usuario.setImg(request.getImg());

        usuarioRepository.save(usuario);

    }
}
