package asai.kola.controller;

import asai.kola.pojo.Result;
import asai.kola.utils.AliyunOSSOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

// 文件上传控制器
@RestController
public class UploadController {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UploadController.class);

    //    文件上传到本地
   /* @PostMapping("/upload")
    public Result upload(String name, Integer age, MultipartFile file) throws IOException {
        log.warn("文件上传：{}", file);
        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        String newfileName = UUID.randomUUID().toString().replace("-", "") + suffix;
        file.transferTo(new File("D:/kola/imgs/" + newfileName));
        return Result.success();
    }*/

    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    //    文件上传到阿里云服务器
    @PostMapping("/upload")
    private Result upload(MultipartFile file) throws Exception {
        String upload = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        log.warn("文件上传地址：{}", upload);
        return Result.success(upload);
    }

}
