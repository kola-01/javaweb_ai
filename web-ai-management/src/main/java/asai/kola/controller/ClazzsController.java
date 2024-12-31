package asai.kola.controller;


import asai.kola.pojo.Clazz;
import asai.kola.pojo.PageResult;
import asai.kola.pojo.Result;
import asai.kola.pojo.clazzQueryParam;
import asai.kola.service.ClazzsService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clazzs")
public class ClazzsController {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ClazzsController.class);


    @Autowired
    private ClazzsService clazzsService;

    @GetMapping
    public Result page(clazzQueryParam param) {
        log.info("分页查询班级: {}", param);
        PageResult<Clazz> pageResult = clazzsService.getList(param);
        return Result.success(pageResult);
    }


    @PostMapping
    public Result add(@RequestBody Clazz clazz) {
        log.info("新增班级：{}", clazz);
        clazzsService.add(clazz);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable int id) {
        log.info("通过Id查询班级：{}", id);
       Clazz clazz= clazzsService.getById(id);
        return Result.success(clazz);
    }
    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        log.info("新增班级：{}", clazz);
        clazzsService.update(clazz);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id) {
        log.info("删除班级：{}", id);
        clazzsService.deletById(id);
        return Result.success();
    }

    @GetMapping("/list")
    public Result list() {
        log.info("查询所有班级");
     List<Clazz> list=  clazzsService.allgetList();
      return Result.success(list);
    }
}
