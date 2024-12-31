package asai.kola.mapper;


import asai.kola.pojo.Clazz;
import asai.kola.pojo.PageResult;
import asai.kola.pojo.Student;
import asai.kola.pojo.clazzQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzsMapper {


    List<Clazz> getList(clazzQueryParam param);

    void deleteById(int id);

    void insert(Clazz clazz);

    Clazz selectById(int id);

    void update(Clazz clazz);

    List<Student> selectstudentById(int id);

    List<Clazz> allgetList();
}
