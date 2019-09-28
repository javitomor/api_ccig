package mil.candes.core.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mil.candes.core.entity.PrecedenciaEntity;

@Repository("precedenciaRepository")
public interface PrecedenciaRepository extends JpaRepository<PrecedenciaEntity, Serializable>{
	
	public abstract PrecedenciaEntity findById(long id);

}
