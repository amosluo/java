package com.amos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @RequestMapping("upload")
    public String upload(){
        return "upload";
    }

    @RequestMapping(value = "/testUpload", method = RequestMethod.POST)
    public String testUpload(@RequestParam(value = "desc", required = false) String desc, @RequestParam("file") MultipartFile multipartFile) throws IOException {
        System.out.println("desc : " + desc);
        System.out.println("OriginalFilename : " + multipartFile.getOriginalFilename());
        try {
            multipartFile.transferTo(new File("D:\\file\\"+multipartFile.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "hello"; //增加成功页面: /views/success.jsp
    }
}
