package asai.kola.service.impl;

import asai.kola.mapper.EmpMapper;
import asai.kola.pojo.Report;
import asai.kola.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public Report getEmpJobData() {
        List<Map<String, Object>> maps = empMapper.reportNum();
        List<Object> jobList = maps.stream().map(data -> data.get("pos")).toList();
        List<Object> dataList = maps.stream().map(data -> data.get("num")).toList();
        return new Report(jobList, dataList);
    }
}
