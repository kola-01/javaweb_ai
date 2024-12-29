package asai.kola.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class EmpQueryParam {
    private Integer page = 1;  //当前页码
    private Integer pageSize = 10; // 每页记录数
    private String name; //员工姓名
    private Integer gender;//员工性别
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin; //范围匹配的开始时间(入职日期)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end; //范围匹配的结束时间(入职日期)

    public EmpQueryParam() {
    }

    public EmpQueryParam(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {
        this.page = page;
        this.pageSize = pageSize;
        this.name = name;
        this.gender = gender;
        this.begin = begin;
        this.end = end;
    }

    /**
     * 获取
     *
     * @return page
     */
    public Integer getPage() {
        return page;
    }

    /**
     * 设置
     *
     * @param page
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * 获取
     *
     * @return pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置
     *
     * @param pageSize
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return gender
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置
     *
     * @param gender
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取
     *
     * @return begin
     */
    public LocalDate getBegin() {
        return begin;
    }

    /**
     * 设置
     *
     * @param begin
     */
    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    /**
     * 获取
     *
     * @return end
     */
    public LocalDate getEnd() {
        return end;
    }

    /**
     * 设置
     *
     * @param end
     */
    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String toString() {
        return "EmpQueryParam{page = " + page + ", pageSize = " + pageSize + ", name = " + name + ", gender = " + gender + ", begin = " + begin + ", end = " + end + "}";
    }
}
