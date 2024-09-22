package there.cumt.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import there.cumt.pojo.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {


    /*
    * pagehelper实现分页查询
    * */
    public  List<Emp> list(@Param("name") String name,@Param("gender") Short gender,@Param("begin") LocalDate begin,@Param("end") LocalDate end);

    /*
     * 根据主键删除员工
     * */
    void delete(@Param("ids") List<Integer> ids);

    /*
     * 添加员工
     * */
    void insert(@Param("emp") Emp emp);

    /*
     * 根据主键查询员工
     * */
    Emp getById(@Param("id") Integer id);

    /*
     * 更新员工
     * */
    void update(Emp emp);

    /*
     * 登录校验
     * */
    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);
}
