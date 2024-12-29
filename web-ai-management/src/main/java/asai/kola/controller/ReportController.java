package asai.kola.controller;


import asai.kola.pojo.Report;
import asai.kola.pojo.Result;
import asai.kola.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/report")
@RestController
public class ReportController {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ReportController.class);


    @Autowired
    private ReportService reportService;

    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        log.info("获取职位统计数据");
        Report report = reportService.getEmpJobData();
        return Result.success(report);
    }
}
