package mil.candes.core.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mil.candes.core.entity.PromotorEntity;

@Repository("promotorRepositorio")
public interface PromotorRepository extends JpaRepository<PromotorEntity, Serializable>{
	
	public abstract PromotorEntity findById(long id);
	
	public abstract PromotorEntity findByDescripcion(String descripcion);

}
