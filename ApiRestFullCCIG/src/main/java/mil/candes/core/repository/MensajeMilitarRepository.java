package mil.candes.core.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import mil.candes.core.entity.MensajeMilitarEntity;

@Repository("mensajeMilitarRepositorio")
public interface MensajeMilitarRepository extends JpaRepository<MensajeMilitarEntity, Serializable>, PagingAndSortingRepository<MensajeMilitarEntity, Serializable>{
	
	public abstract MensajeMilitarEntity findByNumeroRegistro(long numeroRegistro);
	public abstract MensajeMilitarEntity findById(long id);
	
	

	public abstract Page<MensajeMilitarEntity> findAll(Pageable pageable);

}
