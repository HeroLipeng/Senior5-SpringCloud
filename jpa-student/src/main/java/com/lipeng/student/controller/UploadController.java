package com.lipeng.student.controller;

import com.lipeng.student.config.ResultEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {

    @RequestMapping("/upload")
    public ResultEntity upload(MultipartFile file){
        //文件上传
        if (file!=null&&!file.isEmpty()){
            //h获取文件的原始名称
            String fileOriginalFilename=file.getOriginalFilename();
            //拼接一个新名称
            String fileName=UUID.randomUUID()+"_"+fileOriginalFilename;
            //保存的文件地址
            File destFile=new File("D:\\pic",fileName);

            try {
                //执行保存
                file.transferTo(destFile);
                //头像保存的地址
                String userface="http://localhost:8082/img/"+fileName;
                return ResultEntity.ok(userface);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ResultEntity.error();
    }
}
