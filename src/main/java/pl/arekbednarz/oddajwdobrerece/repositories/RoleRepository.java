package pl.arekbednarz.oddajwdobrerece.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arekbednarz.oddajwdobrerece.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}