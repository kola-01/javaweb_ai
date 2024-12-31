package asai.kola.pojo;

import java.util.List;

public class studentCountData {
    private List clazzList;
    private List dataList;


    public studentCountData() {
    }

    public studentCountData(List clazzList, List dataList) {
        this.clazzList = clazzList;
        this.dataList = dataList;
    }

    /**
     * 获取
     * @return clazzList
     */
    public List getClazzList() {
        return clazzList;
    }

    /**
     * 设置
     * @param clazzList
     */
    public void setClazzList(List clazzList) {
        this.clazzList = clazzList;
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
        return "studentCountData{clazzList = " + clazzList + ", dataList = " + dataList + "}";
    }
}
