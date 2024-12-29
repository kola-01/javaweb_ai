package asai.kola.service.impl;

import asai.kola.mapper.EmpExprMapper;
import asai.kola.mapper.EmpMapper;
import asai.kola.pojo.*;
import asai.kola.service.EmpLogService;
import asai.kola.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;
    @Autowired
    EmpExprMapper empExprMapper;
    @Autowired
    EmpLogService empLogService;

    // 使用分页插件PageHelper来实现分页
    @Override
    public PageResult<Emp> getList(EmpQueryParam Param) {
        PageHelper.startPage(Param.getPage(), Param.getPageSize());
        List<Emp> list = empMapper.list(Param);
        Page<Emp> p = (Page<Emp>) list;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }

    // 保存员工信息，事务管理
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void save(Emp emp) {
        try {
            // 参数校验
            if (emp == null) {
                return;
            }
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);
            List<EmpExpr> exprList = emp.getExprList();
            if (!CollectionUtils.isEmpty(exprList)) {
                exprList.forEach(empExpr -> empExpr.setEmpId(emp.getId()));
                empExprMapper.insrtBatch(exprList);
            }
        } finally {
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), emp.toString());
            empLogService.insertLog(empLog);
        }
    }

    // 根据ID列表删除员工信息，事务管理
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void delet(List<Integer> ids) {
        empMapper.deletByIds(ids);
        empExprMapper.deletByEmpIds(ids);
    }

    // 根据ID获取员工信息
    @Override
    public Emp getById(Integer id) {
        Emp emp = empMapper.getById(id);
        return emp;
    }

    // 更新员工信息，事务管理
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateByIds(emp);
        List<Integer> ids = Arrays.asList(emp.getId());
        empExprMapper.deletByEmpIds(ids);
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(empExpr -> empExpr.setEmpId(emp.getId()));
            empExprMapper.insrtBatch(exprList);
        }
    }

    // 获取所有员工信息
    @Override
    public List<Emp> list() {
        return empMapper.list(null);
    }
}
