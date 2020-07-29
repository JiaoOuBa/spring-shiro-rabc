package name.ealen.domain.model;

import lombok.Data;

/**
 * @Auther ck
 * @Date 2020/7/28 17:39
 * @Desc
 */
@Data
public class LoginRequest {

    private String userName;
    private String password;

}
