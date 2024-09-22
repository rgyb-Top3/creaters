package there.cumt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/*
* 封装分页查询结果
* */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private Long total;//总记录数
    private List row;//数据列表
}
