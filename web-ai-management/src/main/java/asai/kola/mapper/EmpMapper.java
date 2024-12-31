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
    /**
     * 根据查询参数分页查询员工信息
     * @param Param 查询参数
     * @return 分页查询结果
     */
    public List<Emp> list(EmpQueryParam Param);

    /**
     * 插入员工信息
     * @param emp 员工对象
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time,update_time) values" +
            "(#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    /**
     * 根据ID列表删除员工信息
     * @param ids ID列表
     */
    void deletByIds(List<Integer> ids);

    /**
     * 根据ID查询员工信息
     * @param id 员工ID
     * @return 员工对象
     */
    Emp getById(Integer id);

    /**
     * 根据ID更新员工信息
     * @param emp 员工对象
     */
    void updateByIds(Emp emp);

    /**
     * 生成职位数量报告
     * @return 职位数量报告列表
     */
    @MapKey("pos")
    List<Map<String, Object>> reportNum();

    /**
     * 生成性别数量报告
     * @return 性别数量报告列表
     */
    @MapKey("name")
    List<Map<String, Object>> reportGender();

    @MapKey("name")
    List<Map<String, Object>>  reportStudentCount();

    @MapKey("name")
    List<Map<String, Object>> reportStudentDegree();

    Emp selectByUsernameAndPassword(Emp emp);
}
