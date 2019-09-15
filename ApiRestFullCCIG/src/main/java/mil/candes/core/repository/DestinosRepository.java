package mil.candes.core.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mil.candes.core.entity.DestinoEntity;

@Repository("destinoRepositorio")
public interface DestinosRepository extends JpaRepository<DestinoEntity, Serializable> {

//	public abstract List<DestinoEntity> findAll();
}
