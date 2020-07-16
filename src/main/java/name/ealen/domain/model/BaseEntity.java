package name.ealen.domain.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by JiaoOuBa on 2020/3/25 13:08.
 * 权限（Auth）
 */
@MappedSuperclass
@Data
public class BaseEntity implements Serializable {
    /*@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;//创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp updateTime;//更新时间*/
}
