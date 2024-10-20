package co.tevent.identity.repository;


import co.tevent.identity.model.TrsEmailTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrsEmailTaskRepository extends JpaRepository<TrsEmailTask, Long> {

}
