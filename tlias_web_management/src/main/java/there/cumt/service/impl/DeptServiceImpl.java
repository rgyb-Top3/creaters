package there.cumt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import there.cumt.mapper.DeptMapper;
import there.cumt.pojo.Dept;
import there.cumt.service.DeptService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list(){
        return deptMapper.list();
    }//查询全部部门信息

    @Override
    public void delete(Integer id){
        deptMapper.deleteById(id);
    }//通过id删除部门

    @Override
    public void add(Dept dept){
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }//添加部门

    @Override
    public Dept selectById(Integer id) {
        return deptMapper.selectId(id);
    }

    @Override
    public void updateById(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateId(dept);
    }
}
