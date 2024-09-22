package there.cumt.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import there.cumt.pojo.Emp;
import there.cumt.pojo.PageBean;
import there.cumt.pojo.Result;
import there.cumt.service.EmpService;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/emps")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("分页查询，page表示页数，pageSize表示页记录数");
        PageBean pageBean = empService.page(page,pageSize,name, gender, begin, end);
        return Result.success(pageBean);
    }

    @DeleteMapping("/emps/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("根据主键删除员工");
        empService.delete(ids);
        return Result.success();
    }

    @PostMapping("/emps")
    public Result add(@RequestBody Emp emp){
        log.info("新增员工，emp{}",emp);
        empService.add(emp);
        return Result.success();
    }

    @GetMapping("/emps/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("根据ID查询员工信息, id: {}",id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    @PutMapping("/emps")
    public Result update(@RequestBody Emp emp){
        log.info("更新员工信息 : {}", emp);
        empService.UpDate(emp);
        return Result.success();
    }
}
