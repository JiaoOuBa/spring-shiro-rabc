package name.ealen.domain.dao;

import name.ealen.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by JiaoOuBa on 2020/3/27 12:29.
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoleName(String roleName);
}
