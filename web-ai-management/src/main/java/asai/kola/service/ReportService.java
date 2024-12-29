package asai.kola.service;

import asai.kola.pojo.Report;

import java.util.List;
import java.util.Map;

public interface ReportService {
    Report getEmpJobData();

    List<Map<String, Object>> getEmpGenderData();
}
