package there.cumt.service;

import org.springframework.format.annotation.DateTimeFormat;
import there.cumt.pojo.Emp;
import there.cumt.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    PageBean page(Integer page, Integer pageSize,String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void add(Emp emp);

    Emp getById(Integer id);

    void UpDate(Emp emp);

    Emp login(Emp emp);
}
