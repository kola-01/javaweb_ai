package asai.kola.mapper;


import asai.kola.pojo.EmpExpr;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 员工工作经历表
 *
 * @return 员工工作经历表
 */

@Mapper
public interface EmpExprMapper {
    void insrtBatch(List<EmpExpr> exprList);
    void deletByEmpIds(List<Integer> empIds);
}
