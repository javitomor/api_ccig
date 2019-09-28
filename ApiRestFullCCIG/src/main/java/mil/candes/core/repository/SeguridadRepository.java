package mil.candes.core.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mil.candes.core.entity.SeguridadEntity;

@Repository("seguridadRepositorio")
public interface SeguridadRepository extends JpaRepository<SeguridadEntity, Serializable>{
	
	public abstract SeguridadEntity findById(long id);

}
