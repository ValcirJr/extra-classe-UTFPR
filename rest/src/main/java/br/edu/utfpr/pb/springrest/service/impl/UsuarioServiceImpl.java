package br.edu.utfpr.pb.springrest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.utfpr.pb.springrest.model.Usuario;
import br.edu.utfpr.pb.springrest.repository.UsuarioRepository;
import br.edu.utfpr.pb.springrest.service.UsuarioService;

@Service
public class UsuarioServiceImpl extends CrudServiceImpl<Usuario, Long> implements UsuarioService, UserDetailsService{

    @Autowired 
    private UsuarioRepository usuarioRepository;

    @Override
    protected JpaRepository<Usuario, Long> getRepository() {
        return usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return usuarioRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado!"));
    }
    
    @Override
    public Iterable<Usuario> save(Iterable<Usuario> iterable) {
    	return super.save(iterable);
    }

}
