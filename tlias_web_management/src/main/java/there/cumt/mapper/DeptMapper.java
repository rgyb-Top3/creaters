package there.cumt.mapper;

import org.apache.ibatis.annotations.Mapper;
import there.cumt.pojo.Dept;

import java.util.List;

@Mapper
public interface DeptMapper {


    //@Select("select * from dept")
    List<Dept> list();

    //@Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    //@Insert("insert into dept(name, create_time, update_time) VALUES (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    Dept selectId(Integer id);

    void updateId(Dept dept);
}
