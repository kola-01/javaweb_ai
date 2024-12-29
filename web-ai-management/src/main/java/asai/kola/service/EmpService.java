package asai.kola.service;

import asai.kola.pojo.Emp;
import asai.kola.pojo.EmpQueryParam;
import asai.kola.pojo.PageResult;

import java.util.List;

public interface EmpService {
    //    PageResult<Emp> getList(Integer page, Integer pageSize);

    //分页查询员工信息
    PageResult<Emp> getList(EmpQueryParam param);

    void save(Emp emp);

    void delet(List<Integer> ids);

    Emp getById(Integer id);

    void update(Emp emp);
}
