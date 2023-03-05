package br.com.cwi.crescer.bascrescer.security.service;

import br.com.cwi.crescer.bascrescer.domain.Time;
import br.com.cwi.crescer.bascrescer.security.controller.request.UsuarioRequest;
import br.com.cwi.crescer.bascrescer.security.controller.response.UsuarioResponse;
import br.com.cwi.crescer.bascrescer.security.domain.Permissao;
import br.com.cwi.crescer.bascrescer.security.domain.Usuario;
import br.com.cwi.crescer.bascrescer.security.repository.UsuarioRepository;
import br.com.cwi.crescer.bascrescer.service.BuscarTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static br.com.cwi.crescer.bascrescer.security.domain.Funcao.USUARIO;
import static br.com.cwi.crescer.bascrescer.security.mapper.UsuarioMapper.toEntity;
import static br.com.cwi.crescer.bascrescer.security.mapper.UsuarioMapper.toResponse;

@Service
public class IncluirUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ValidaEmailUnicoService validaEmailUnicoService;

    @Autowired
    private BuscarTimeService buscarTimeService;


    public UsuarioResponse incluir(UsuarioRequest request) {

        Usuario usuario = toEntity(request);

        Time time = buscarTimeService.porId(request.getTimeId());

        validaEmailUnicoService.validar(request.getEmail());

        usuario.setTime(time);
        usuario.setSenha(getSenhaCriptografada(request.getSenha()));
        usuario.adicionarPermissao(getPermissaoPadrao());
        usuario.setAtivo(true);

        usuarioRepository.save(usuario);

        return toResponse(usuario);
    }

    private String getSenhaCriptografada(String senhaAberta) {
        return passwordEncoder.encode(senhaAberta);
    }

    private Permissao getPermissaoPadrao() {
        Permissao permissao = new Permissao();
        permissao.setFuncao(USUARIO);
        return permissao;
    }
}
