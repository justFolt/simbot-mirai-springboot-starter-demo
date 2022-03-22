package simbot.example.mapper.QQMachine;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import simbot.example.model.QQMachine.Friendinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zyf
 * @since 2021-12-04
 */
@Mapper
public interface FriendinfoMapper extends BaseMapper<Friendinfo> {

    @Select("select * from friendinfo")
    public List<Friendinfo> selectAll();

}
