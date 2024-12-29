package asai.kola.pojo;


import java.util.List;

/**
* 分页结果封装类
*
* @return 分页结果封装类
* */
public class PageResult<T> {
    private long total;
    private List<T> rows;

    public PageResult() {
    }

    public PageResult(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    /**
     * 获取
     * @return total
     */
    public long getTotal() {
        return total;
    }

    /**
     * 设置
     * @param total
     */
    public void setTotal(long total) {
        this.total = total;
    }

    /**
     * 获取
     * @return rows
     */
    public List<T> getRows() {
        return rows;
    }

    /**
     * 设置
     * @param rows
     */
    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public String toString() {
        return "PageResult{total = " + total + ", rows = " + rows + "}";
    }
}
