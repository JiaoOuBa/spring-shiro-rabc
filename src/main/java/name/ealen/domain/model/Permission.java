package name.ealen.domain.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Created by JiaoOuBa on 2020/3/25 11:15.
 * <p>
 * 权限许可（Permission) 操作 及其能访问url 权限对应一个url地址
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "fc_authority")
public class Permission extends BaseEntity {

    @Id
    private String authId;
    @Column(unique = true)
    private String authCode;  // 权限代码 唯一
    @Column(unique = true)
    private String authName;  //权限名 唯一
    @Column(unique = true)
    private String url;  //访问地址信息 唯一
    private Long adminId;
    private Integer authType;  //权限类型

}
