package asai.kola.pojo;

public class studentGet {
    private Integer clazzId; //班级ID
    private Integer degree; //学历
    private String name; //学生姓名
    private Integer page = 1;  //页码
    private Integer pageSize = 10;  //每页数量

    public studentGet() {
    }

    public studentGet(Integer clazzId, Integer degree, String name, Integer page, Integer pageSize) {
        this.clazzId = clazzId;
        this.degree = degree;
        this.name = name;
        this.page = page;
        this.pageSize = pageSize;
    }

    /**
     * 获取
     *
     * @return clazzId
     */
    public Integer getClazzId() {
        return clazzId;
    }

    /**
     * 设置
     *
     * @param clazzId
     */
    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }

    /**
     * 获取
     *
     * @return degree
     */
    public Integer getDegree() {
        return degree;
    }

    /**
     * 设置
     *
     * @param degree
     */
    public void setDegree(Integer degree) {
        this.degree = degree;
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

    public String toString() {
        return "studentGet{clazzId = " + clazzId + ", degree = " + degree + ", name = " + name + ", page = " + page + ", pageSize = " + pageSize + "}";
    }
}
