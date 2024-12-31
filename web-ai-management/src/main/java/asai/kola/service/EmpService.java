package asai.kola.service;

import asai.kola.pojo.Emp;
import asai.kola.pojo.EmpQueryParam;
import asai.kola.pojo.LoginInfo;
import asai.kola.pojo.PageResult;

import java.util.List;

// 员工服务接口，定义员工相关的业务操作
public interface EmpService {
    //    PageResult<Emp> getList(Integer page, Integer pageSize);

    //分页查询员工信息
    PageResult<Emp> getList(EmpQueryParam param);

    // 保存员工信息
    void save(Emp emp);

    // 根据ID列表删除员工信息
    void delet(List<Integer> ids);

    // 根据ID查询员工信息
    Emp getById(Integer id);

    // 更新员工信息
    void update(Emp emp);

    // 查询所有员工信息
    List<Emp> list();

    LoginInfo login(Emp emp);
}
