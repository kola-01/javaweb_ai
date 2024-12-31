package asai.kola.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class clazzQueryParam {
    public Integer page = 1;
    public Integer pageSize = 10;
    private String name;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate begin;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate end;


    public clazzQueryParam() {
    }

    public clazzQueryParam(Integer page, Integer pageSize, String name, LocalDate begin, LocalDate end) {
        this.page = page;
        this.pageSize = pageSize;
        this.name = name;
        this.begin = begin;
        this.end = end;
    }

    /**
     * 获取
     * @return page
     */
    public Integer getPage() {
        return page;
    }

    /**
     * 设置
     * @param page
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * 获取
     * @return pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置
     * @param pageSize
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return begin
     */
    public LocalDate getBegin() {
        return begin;
    }

    /**
     * 设置
     * @param begin
     */
    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    /**
     * 获取
     * @return end
     */
    public LocalDate getEnd() {
        return end;
    }

    /**
     * 设置
     * @param end
     */
    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String toString() {
        return "clazzQueryParam{page = " + page + ", pageSize = " + pageSize + ", name = " + name + ", begin = " + begin + ", end = " + end + "}";
    }
}
