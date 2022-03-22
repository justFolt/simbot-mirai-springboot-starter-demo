package simbot.example.service.QQMachine.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import simbot.example.model.QQMachine.Friendinfo;
import simbot.example.mapper.QQMachine.FriendinfoMapper;
import simbot.example.service.QQMachine.FriendinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zyf
 * @since 2021-12-04
 */
@Service
public class FriendinfoServiceImpl extends ServiceImpl<FriendinfoMapper, Friendinfo> implements FriendinfoService {

    @Autowired
    FriendinfoMapper friendinfoMapper;

    @Override
    public void insertOneCode(Friendinfo friendinfo){
        QueryWrapper<Friendinfo> friendinfoQueryWrapper = new QueryWrapper<>();
        int insert = friendinfoMapper.insert(friendinfo);
        System.out.println(insert);
    }

    @Override
    public List<Friendinfo> selectAll() {
        QueryWrapper<Friendinfo> friendinfoQueryWrapper = new QueryWrapper<>();

        return friendinfoMapper.selectAll();
    }
}
