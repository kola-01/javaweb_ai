package asai.kola.pojo;

import java.util.List;

public class Report {
    private List jobList;
    private List dataList;


    public Report() {
    }

    public Report(List jobList, List dataList) {
        this.jobList = jobList;
        this.dataList = dataList;
    }

    /**
     * 获取
     * @return jobList
     */
    public List getJobList() {
        return jobList;
    }

    /**
     * 设置
     * @param jobList
     */
    public void setJobList(List jobList) {
        this.jobList = jobList;
    }

    /**
     * 获取
     * @return dataList
     */
    public List getDataList() {
        return dataList;
    }

    /**
     * 设置
     * @param dataList
     */
    public void setDataList(List dataList) {
        this.dataList = dataList;
    }

    public String toString() {
        return "Report{jobList = " + jobList + ", dataList = " + dataList + "}";
    }
}
