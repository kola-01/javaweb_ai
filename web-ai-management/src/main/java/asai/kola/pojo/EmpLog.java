package asai.kola.pojo;

import java.time.LocalDateTime;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class EmpLog {
    private Integer id; //ID
    private LocalDateTime operateTime; //操作时间
    private String info; //详细信息

    public EmpLog() {
    }

    public EmpLog(Integer id, LocalDateTime operateTime, String info) {
        this.id = id;
        this.operateTime = operateTime;
        this.info = info;
    }

    /**
     * 获取
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     *
     * @return operateTime
     */
    public LocalDateTime getOperateTime() {
        return operateTime;
    }

    /**
     * 设置
     *
     * @param operateTime
     */
    public void setOperateTime(LocalDateTime operateTime) {
        this.operateTime = operateTime;
    }

    /**
     * 获取
     *
     * @return info
     */
    public String getInfo() {
        return info;
    }

    /**
     * 设置
     *
     * @param info
     */
    public void setInfo(String info) {
        this.info = info;
    }

    public String toString() {
        return "EmpLog{id = " + id + ", operateTime = " + operateTime + ", info = " + info + "}";
    }
}
