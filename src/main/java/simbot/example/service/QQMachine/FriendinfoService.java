package simbot.example.service.QQMachine;

import simbot.example.model.QQMachine.Friendinfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zyf
 * @since 2021-12-04
 */
public interface FriendinfoService extends IService<Friendinfo> {
    //插入一个好友信息
    void insertOneCode(Friendinfo friendinfo);

    //读取所有数据
    List<Friendinfo> selectAll();
}
