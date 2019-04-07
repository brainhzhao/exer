package priv.zh.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.WebApplicationContext;

import org.springframework.ui.Model;

import priv.zh.service.*;
/**
 * @author zhaoheng
 * @version 1.0
 * 文件上传
 */

@Controller
@RequestMapping("/upload")
 public class UploadFileController{
    
    
    @RequestMapping("/image")
    @ResponseBody
    public HashMap<String,Object> uploadImage(MultipartFile imageFile,String date,HttpServletRequest request){
        HashMap<String,Object> result = new HashMap<>();
        FileOutputStream fileOutputStream=null;
        File saveDir=new File("D:\\save"+File.separator+date);
        try {
            result.put("filename",imageFile.getOriginalFilename());
            result.put("size",imageFile.getSize());
            result.put("name",imageFile.getName());
            result.put("contentType",imageFile.getContentType());
            result.put("saveDir",saveDir);
            if(!saveDir.exists()){
                saveDir.mkdirs();
            }
            fileOutputStream=new FileOutputStream(saveDir.getAbsolutePath()+File.separator+imageFile.getOriginalFilename());
            InputStream is=imageFile.getInputStream(); 
            byte[] temp=new byte[512];
            while(is.read(temp)>0){
                fileOutputStream.write(temp);
            }
            fileOutputStream.flush();        
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }    
        return result;
    }

    @RequestMapping("/page")
    public String toUploadPage(Model model,HttpServletRequest request){
        ApplicationContext conetxt=(WebApplicationContext) request.getAttribute("org.springframework.web.servlet.DispatcherServlet.CONTEXT");
        conetxt.publishEvent(new LogEvent(request.getHeaderNames()));
        model.addAttribute("name", "赵恒");
        return "index";
    }
 }