package com.yydcyy;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @author YYDCYY
 * @create 2019-10-07
 */
@Controller
@RequestMapping("/user")
public class UserController {


    /**
     * 传统文件上传
     * @return
     */
    @RequestMapping("/fileupload1")
    public String fileupload1(HttpServletRequest request) throws Exception {
        //System.out.println("文件上传...");
        // 使用fileupload组件完成文件上传
        // 上传的位置
        String path =request.getSession().getServletContext().getRealPath("/uploads/");
        //System.out.println(path);
        // 判断，该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //文件夹不存在, 创建该文件夹
            file.mkdirs();
        }

        // 解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 解析request
        List<FileItem> items = upload.parseRequest(request);

        for (FileItem item : items) {
            // 进行判断，当前item对象是否是上传文件项
            if (item.isFormField()) {
                // 说明普通表单向
            }else{
                item.write(new File(path, item.getName()));
                // 删除临时文件
                item.delete();
            }
        }
        return "success";
    }

    /**
     * SpringMVC文件上传
     * @return
     */
    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("Spring MVC 文件上传...");

        // 上传的位置
        String path =request.getSession().getServletContext().getRealPath("/uploads/");
        //System.out.println(path);

        // 判断，该路径是否存在
        File file = new File(path);

        if (!file.exists()) {
            //文件夹不存在, 创建该文件夹
            file.mkdirs();
        }

        // 说明上传文件项
        // 获取上传文件的名称
        String filename = upload.getOriginalFilename();
        // 把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+"_"+filename;
        // 完成文件上传
        upload.transferTo(new File(path,filename));

        return "success";
    }

    /**
     * SpringMVC文件上传
     * @return
     */
    @RequestMapping("/fileupload3")
    public String fileupload3(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("Spring MVC 跨服务器文件上传...");

        // 定义上传文件服务器路径
        String path = "http://localhost:9090/SpringMVC_v13_fileupload_war/uploads/";

        // 判断，该路径是否存在
        File file = new File(path);

        if (!file.exists()) {
            //文件夹不存在, 创建该文件夹
            file.mkdirs();
        }

        // 说明上传文件项
        // 获取上传文件的名称
        String filename = upload.getOriginalFilename();
        // 把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+"_"+filename;

        // 创建客户端的对象
        Client client = Client.create();

        // 和图片服务器进行连接
        WebResource webResource = client.resource(path + filename);

        // 上传文件
        webResource.put(upload.getBytes());

        return "success";
    }

}
