package simbot.example.model.QQMachine;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import love.forte.simbot.api.message.events.PrivateMsg;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zyf
 * @since 2021-12-04
 */
public class Friendinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "code", type = IdType.ASSIGN_UUID)
    private String code;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }


    @TableField("name")
    private String name;

    @Override
    public String toString() {
        return "Friendinfo{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
