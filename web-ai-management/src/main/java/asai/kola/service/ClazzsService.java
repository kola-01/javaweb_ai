package asai.kola.service;

import asai.kola.pojo.Clazz;
import asai.kola.pojo.PageResult;
import asai.kola.pojo.clazzQueryParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClazzsService {
    PageResult<Clazz> getList(clazzQueryParam param);

    void deletById(int id);

    void add(Clazz clazz);

    Clazz getById(int id);

    void update(Clazz clazz);

    List<Clazz> allgetList();
}
