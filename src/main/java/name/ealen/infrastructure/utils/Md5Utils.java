package name.ealen.infrastructure.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Auther ck
 * @Date 2020/7/16 15:39
 * @Desc
 */
public class Md5Utils {

    /**
     * 加密
     * @param username
     * @param enablePassword
     * @return
     */
    private Object encrypt(String username, String enablePassword) {

        String hashAlgorithmName = "md5";//加密算法

        String passwordSalt = "5371f568a45e5ab1f442c38e0932aef24447139b";//密钥

        String salt = passwordSalt + username + passwordSalt; //盐值

        int hashIterations = 1024; //散列次数

        ByteSource credentialsSalt = ByteSource.Util.bytes(salt);//盐

        return new SimpleHash(hashAlgorithmName, enablePassword, credentialsSalt, hashIterations);

    }
}
