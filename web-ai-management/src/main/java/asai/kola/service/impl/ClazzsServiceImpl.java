package asai.kola.service.impl;

import asai.kola.mapper.ClazzsMapper;
import asai.kola.pojo.Clazz;
import asai.kola.pojo.PageResult;
import asai.kola.pojo.Student;
import asai.kola.pojo.clazzQueryParam;
import asai.kola.service.ClazzsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Service
public class ClazzsServiceImpl implements ClazzsService {

    @Autowired
    private ClazzsMapper clazzsMapper;

    @Override
    public PageResult<Clazz> getList(clazzQueryParam param) {
        PageHelper.startPage(param.getPage(), param.getPageSize());
        List<Clazz> list = clazzsMapper.getList(param);
        Page<Clazz> p = (Page<Clazz>) list;
        p.forEach(item -> {
            //            判断班级状态（如果当前日期在班级开始日期之前，那么未开班；如果当前日期在班级结束日期之后，那么已结课；否则，在读）
            LocalDate beginDate = item.getBeginDate();
            LocalDate endDate = item.getEndDate();
            LocalDate now = LocalDate.now();
            if (now.isBefore(beginDate)) {
                item.setStatus("未开班");
            } else if (now.isAfter(endDate)) {
                item.setStatus("已结课");
            } else {
                item.setStatus("在读");
            }
        });
        return new PageResult<Clazz>(p.getTotal(), p.getResult());
    }


    @Override
    public void add(Clazz clazz) {
        clazzsMapper.insert(clazz);
    }

    @Override
    public Clazz getById(int id) {
        return clazzsMapper.selectById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazzsMapper.update(clazz);
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deletById(int id) {
        List<Student> list = clazzsMapper.selectstudentById(id);
        System.out.println(list);
        if (list.size() > 0) {
            throw new RuntimeException("班级下有学生，不能删除");
        }
        clazzsMapper.deleteById(id);
    }


    @Override
    public List<Clazz> allgetList() {
       List<Clazz> list = clazzsMapper.allgetList();
        return list;
    }
}
