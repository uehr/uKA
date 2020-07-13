package co.uehr.uka.repository;

import org.springframework.data.repository.CrudRepository;
import co.uehr.uka.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {}