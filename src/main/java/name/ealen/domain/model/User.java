package name.ealen.domain.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

/**
 * Created by JiaoOuBa on 2020/3/25 11:01.
 * <p>
 * 用户表(User) 用户下面对应多个角色
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "fc_user")
public class User extends BaseEntity {

    @Id
    private String userId;

    @Column(unique = true)
    private String userName;//用户名 唯一
    private String password;//用户密码
    private String passwordSalt;//用户密码加密盐值
    private Integer status;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;//用户角色  一个用户可能有一个角色，也可能有 多个角色

}
