package pl.arekbednarz.oddajwdobrerece.services.Implementation;

import org.springframework.stereotype.Service;
import pl.arekbednarz.oddajwdobrerece.entity.Role;
import pl.arekbednarz.oddajwdobrerece.repositories.RoleRepository;
import pl.arekbednarz.oddajwdobrerece.services.RoleService;

@Service
public class RoleServiceDb implements RoleService {

    RoleRepository roleRepository;

    public RoleServiceDb(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }
}
