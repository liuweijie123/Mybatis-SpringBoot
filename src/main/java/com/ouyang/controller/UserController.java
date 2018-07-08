package com.ouyang.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ouyang.model.User;
import com.ouyang.service.IUserService;
import com.ouyang.service.UserService;
import com.ouyang.util.FastDFSClientWrapper;
import com.ouyang.util.FastDFSFile;
//import org.csource.common.MyException;
//import org.csource.common.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    
    @RequestMapping(value = "/select")
    public ModelAndView select(HttpServletRequest request) {
        ModelAndView result = new ModelAndView("index");
        int a = 2/0;
        request.getSession().setAttribute("aaa",1111);
        result.addObject("userList",userService.getAll());
        return result;
    }
    
    @RequestMapping(value = "/selectall")
    public PageInfo<User> selectAll(HttpServletRequest request) {
    	return userService.getAllByPage();
    }
    
    @RequestMapping(value="/delete")
    public Integer delete(HttpServletRequest request){
    	return userService.delete();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Integer add(@RequestParam("file") MultipartFile attach,HttpServletRequest request)
            throws IOException {
        // 获取文件后缀名
//        String ext = attach.getOriginalFilename().substring(attach.getOriginalFilename().lastIndexOf(".")+1);
//        FastDFSFile file = new FastDFSFile(attach.getBytes(),ext);
//        NameValuePair[] meta_list = new NameValuePair[4];
//        meta_list[0] = new NameValuePair("fileName", attach.getOriginalFilename());
//        meta_list[1] = new NameValuePair("fileLength", String.valueOf(attach.getSize()));
//        meta_list[2] = new NameValuePair("fileExt", ext);
//        meta_list[3] = new NameValuePair("fileAuthor", "WangLiang");
//        String filePath = FileManager.upload(file,meta_list);
        Integer session = (Integer) request.getSession().getAttribute("aaa");
        return session;
    }

}
