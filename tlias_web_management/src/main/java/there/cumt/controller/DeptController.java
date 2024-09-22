package there.cumt.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import there.cumt.pojo.Dept;
import there.cumt.pojo.Result;
import there.cumt.service.DeptService;

import java.util.List;


@Slf4j
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/depts")
    public Result list(){
        log.info("查询全部部门数据");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    @DeleteMapping("/depts/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据ID{}删除部门",id);
        deptService.delete(id);
        return Result.success();
    }

    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
        log.info("新增部门：{}",dept);
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/depts/{id}")
    public Result selectOne(@PathVariable Integer id){
        log.info("根据ID{}查询部门",id);
        Dept dept=deptService.selectById(id);
        return Result.success(dept);
    }

    @PutMapping("/depts")
    public Result update(@RequestBody Dept dept){
        log.info("通过id更新行数据");
        deptService.updateById(dept);
        return Result.success();
    }

}
