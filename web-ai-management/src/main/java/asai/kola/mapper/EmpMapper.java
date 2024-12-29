package asai.kola.mapper;

import asai.kola.pojo.Emp;
import asai.kola.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;
import java.util.Map;

/**
 * 员工信息
 *
 * @return 员工信息
 */
@Mapper
public interface EmpMapper {
    //-----------------------原始的分页实现-------------------------------
    //    /**
    //     * 查询总记录数
    //     * @return 查询总记录数
    //    * */
    //    @Select("select count(*) from emp e left join  dept d on e.dept_id = d.id")
    //    public long count();
    //
    //    /**
    //     * 分页查询
    //     * @return 分页查询
    //     */
    //    @Select("select e.*,d.name deptName from emp e left join dept d " +
    //            "on e.dept_id=d.id order by e.update_time limit #{start},#{pageSize} ")
    //    public List<Emp> list(Integer start,Integer pageSize);


    //-----------------------使用分页插件PageHelper来实现分页-------------------------------
    //         @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id=d.id order by e.update_time")
    public List<Emp> list(EmpQueryParam Param);


    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time,update_time) values" +
            "(#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);


    void deletByIds(List<Integer> ids);

    Emp getById(Integer id);

    void updateByIds(Emp emp);

//    @MapKey("pos")
    List<Map<String, Object>> reportNum();
}
