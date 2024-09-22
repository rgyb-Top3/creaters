package there.cumt.service;


import there.cumt.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> list();

    void delete(Integer id);

    void add(Dept dept);

    Dept selectById(Integer id);

    void updateById(Dept dept);
}
