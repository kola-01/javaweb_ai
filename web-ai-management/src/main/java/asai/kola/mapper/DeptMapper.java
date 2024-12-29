package asai.kola.mapper;


import asai.kola.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    //    查询所有部门
    @Select("select id, name, create_time, update_time from dept order by  update_time DESC")
    List<Dept> findId();

    //    通过id删除部门
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    //    添加部门
    @Insert("INSERT INTO dept(name, create_time, update_time) VALUES (#{name},#{createTime},#{updateTime})")
    void add(Dept dept);

    //    通过id查询部门
    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Dept findAll(Integer id);

    //    修改部门
    @Update("UPDATE dept SET name = #{name}, update_time = #{updateTime} WHERE id = #{id}")
    void update(Dept dept);

}
