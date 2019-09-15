package mil.candes.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mil.candes.core.entity.UsuarioEntity;
import mil.candes.core.repository.UsuarioRepository;

@Service("usuarioService")
public class UsuarioService
//implements UserDetailsService 
{
	
	@Autowired
	@Qualifier("usuarioRepository")
	private UsuarioRepository repo;

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		UsuarioEntity user = repo.findByUsuario(username);
//		return new User(user.getUsuario(), user.getContrasena(), 
//				user.isActivo(), user.isActivo(), user.isActivo(), user.isActivo(), buildgrante(user.getRol()) );
//	}
//	
//	public List<GrantedAuthority> buildgrante(byte rol){
//		String[] roles = {"LECTOR","USUARIO","ADMINISTRADOR"};//recuperar los roles de la base de datos
//		List<GrantedAuthority> auths = new ArrayList<>();
//		for(int i = 0; i<rol; i++) {
//			auths.add(new SimpleGrantedAuthority(roles[i]));
//		}
//		return auths;
//	}
	
}
