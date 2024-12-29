package asai.kola.service;

import asai.kola.pojo.Dept;

import java.util.List;

public interface Deptservice {

    // 查询全部部门
    List<Dept> findAll();

    // 根据id删除部门
    void deleteById(Integer id);

    // 添加新部门
    void add(Dept dept);

    // 更新部门信息
    void update(Dept dept);

    // 根据id查找部门
    Dept findAll(Integer id);
}
