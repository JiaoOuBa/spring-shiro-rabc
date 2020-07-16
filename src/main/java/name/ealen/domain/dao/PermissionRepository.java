package name.ealen.domain.dao;

import name.ealen.domain.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by JiaoOuBa on 2020/3/27 10:57.
 */
public interface PermissionRepository extends JpaRepository<Permission, Integer> {
    Permission findByAuthName(String authName);
}
