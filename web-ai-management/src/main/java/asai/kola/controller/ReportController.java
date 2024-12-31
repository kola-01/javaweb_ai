package asai.kola.controller;

import asai.kola.pojo.Report;
import asai.kola.pojo.Result;
import asai.kola.pojo.studentCountData;
import asai.kola.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

// 报告控制器类，用于处理与报告相关的HTTP请求
@RequestMapping("/report")
@RestController
public class ReportController {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ReportController.class);

    // 自动注入报告服务
    @Autowired
    private ReportService reportService;

    // 获取职位统计数据
    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        log.info("获取职位统计数据");
        Report report = reportService.getEmpJobData();
        return Result.success(report);
    }

    // 获取性别统计数据
    @GetMapping("/empGenderData")
    public Result getEmpGenderData() {
        log.info("获取性别统计数据");
        List<Map<String, Object>> list = reportService.getEmpGenderData();
        return Result.success(list);
    }

    @GetMapping("/studentCountData")
    public Result getStudentCountData() {
        log.info("获取学生统计数据");
        studentCountData list = reportService.getStudentCountData();
        log.info("学生统计数据：{}" ,list);
        return Result.success(list);
    }

    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData() {
        log.info("获取学生学历统计数据");
        List<Map<String, Object>> list = reportService.getStudentDegreeData();
        return Result.success(list);
    }
}
