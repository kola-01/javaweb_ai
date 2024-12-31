package asai.kola.service.impl;

import asai.kola.mapper.EmpMapper;
import asai.kola.pojo.Report;
import asai.kola.pojo.studentCountData;
import asai.kola.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 实现报告服务接口的类，用于获取员工相关数据报告
 */
@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private EmpMapper empMapper;

    /**
     * 获取员工职位数据的方法，返回一个包含职位和数量的报告对象
     */
    @Override
    public Report getEmpJobData() {
        List<Map<String, Object>> maps = empMapper.reportNum();
        List<Object> jobList = maps.stream().map(data -> data.get("pos")).toList();
        List<Object> dataList = maps.stream().map(data -> data.get("num")).toList();
        return new Report(jobList, dataList);
    }

    /**
     * 获取员工性别数据的方法，返回一个包含性别和数量的Map列表
     */
    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        List<Map<String, Object>> list = empMapper.reportGender();
        return list;
    }

    @Override
    public studentCountData getStudentCountData() {
        List<Map<String, Object>> list = empMapper.reportStudentCount();
        List<Object> clazzList = list.stream().map(data -> data.get("name")).toList();
        List<Object> dataList = list.stream().map(data -> data.get("num")).toList();
        return new studentCountData(clazzList, dataList);
    }

    @Override
    public List<Map<String, Object>> getStudentDegreeData() {
        List<Map<String, Object>> list = empMapper.reportStudentDegree();
        return list;
    }
}

