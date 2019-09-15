package mil.candes.core.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mil.candes.core.entity.UsuarioEntity;

@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Serializable> {

	public abstract UsuarioEntity findByUsuario(String name);
}
