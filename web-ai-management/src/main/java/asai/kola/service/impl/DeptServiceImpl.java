package asai.kola.service.impl;

import asai.kola.mapper.DeptMapper;
import asai.kola.pojo.Dept;
import asai.kola.service.Deptservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements Deptservice {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    // 查询所有部门信息
    public List<Dept> findAll() {
        return deptMapper.findId();
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    // 根据ID删除部门信息
    public void deleteById(Integer id) {
        Integer num = deptMapper.selectById(id);
        if (num > 0) {
            throw new RuntimeException("该部门下有员工，不能删除");
        }
        deptMapper.deleteById(id);
    }

    @Override
    // 添加新的部门信息，并设置创建时间和更新时间为当前时间
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }

    @Override
    // 根据ID查询部门信息
    public Dept findAll(Integer id) {
        return deptMapper.findAll(id);
    }

    @Override
    // 更新部门信息，并设置更新时间为当前时间
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }


}

