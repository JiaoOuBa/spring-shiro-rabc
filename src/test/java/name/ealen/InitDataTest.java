package name.ealen;

import name.ealen.domain.dao.PermissionRepository;
import name.ealen.domain.dao.RoleRepository;
import name.ealen.domain.dao.UserRepository;
import name.ealen.domain.model.Permission;
import name.ealen.domain.model.Role;
import name.ealen.domain.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EalenXie on 2019/3/27 9:36.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InitDataTest {


    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * 新增 权限测试
     */
    @Test
    public void addPermissionTest() {

        Permission addPermission = new Permission();
        addPermission.setAuthId("001");
        addPermission.setAuthName("新增权限");
        addPermission.setAuthCode("auth001");
        addPermission.setUrl("/add");

        Permission updatePermission = new Permission();
        updatePermission.setAuthId("002");
        updatePermission.setAuthName("修改权限");
        updatePermission.setAuthCode("auth001");
        updatePermission.setUrl("/update");

        Permission deletePermission = new Permission();
        deletePermission.setAuthId("003");
        deletePermission.setAuthName("删除权限");
        deletePermission.setAuthCode("auth001");
        deletePermission.setUrl("/delete");

        permissionRepository.save(addPermission);
        permissionRepository.save(updatePermission);
        permissionRepository.save(deletePermission);
    }


    /**
     * 新增 角色测试
     */
    @Test
    public void addRoleTest() {

        //管理员 具有所有权限
        List<Permission> permissions = permissionRepository.findAll();
        Role administrator = new Role();
        administrator.setRoleName("administrator");
        administrator.setRoleId("001");
        administrator.setPermissions(permissions);
        roleRepository.save(administrator);
        permissions.clear();

        //用户只有部分权限 比如只有新增,修改权限
        Permission addPermission = permissionRepository.findByAuthName("新增权限");
        Permission updatePermission = permissionRepository.findByAuthName("修改权限");
        permissions.add(addPermission);
        permissions.add(updatePermission);
        Role user = new Role();
        user.setRoleName("user");
        user.setRoleId("002");
        user.setPermissions(permissions);
        roleRepository.save(user);

    }

    @Test
    public void addUserTest() {
        //chenkun 具有管理员角色
        List<Role> roles = new ArrayList<>();
        Role admin = roleRepository.findByRoleName("administrator");
        roles.add(admin);
        User chenkun = new User();
        chenkun.setUserId("test001");
        chenkun.setUserName("chenkun");
        chenkun.setPasswordSalt("5371f568a45e5ab1f442c38e0932aef24447139b");
        chenkun.setPassword("dde5deadfcaa4267804832b063f4f8f9");
        chenkun.setRoles(roles);
        userRepository.save(chenkun);
        roles.clear();

        //lisi 具有用户角色
        Role user = roleRepository.findByRoleName("user");
        roles.add(user);
        User lisi = new User();
        lisi.setUserId("test002");
        lisi.setUserName("lisi");
        lisi.setPasswordSalt("5371f568a45e5ab1f442c38e0932aef24447139b");
        lisi.setPassword("3b574a9959cd4f8a9a3752d34e0f5f33");
        lisi.setRoles(roles);
        userRepository.save(lisi);
    }

}
