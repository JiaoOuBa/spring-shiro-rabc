package name.ealen.domain.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

/**
 * Created by JiaoOuBa on 2020/3/25 11:18.
 * <p>
 * 角色(Role) 角色下面对应多个权限
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "fc_role")
public class Role extends BaseEntity {

    @Id
    private String roleId;

    @Column(unique = true)
    private String roleName;                    //角色名 唯一
    @ManyToMany(fetch= FetchType.EAGER)
    private List<Permission> permissions;   //一个用户角色对应多个权限
}
