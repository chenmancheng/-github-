package soft.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import soft.pojo.*;
import soft.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin")
public class AdminControl {
    @Autowired
    private AdminService adminService;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
    @Autowired
    private VideoService videoService;
    @Autowired
    private CommentService commentService;

    @RequestMapping("/login")
    public String login(String tel, String password, ModelMap modelMap, HttpSession session){
        Admin admin = adminService.login(tel, password);
        if (admin != null){
            session.setAttribute("loginAdmin","bean");
            return "seccess";
        }
        else{
            return "error";
        }

    }

    @RequestMapping("/register")
    public String register(Admin bean ,String cfmpassword,String password,  ModelMap model, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws IOException {

        if(adminService.getById(bean.getTel())!=null) {
            model.addAttribute("msg", "账号已经存在");
            return "forward:../register.jsp";
        }
        if(!password.equals(cfmpassword)) {
            model.addAttribute("msg", "两次输入密码不一致");
            return "forward:../register.jsp";
        }
        boolean flag = adminService.insert(bean);
        if(flag == true){
            model.addAttribute("msg", "操作成功，请登录");
            return "forward:../login.jsp";
        }
        else{
            response.sendRedirect(request.getContextPath()+"/register.jsp");
            return null;
        }
    }

    //查询所有产品信息
    @RequestMapping("/allProduct")
    public String allProduct(ModelMap model,HttpSession session){
        List<Product> bean = productService.getList();
        System.out.println(bean);
        model.addAttribute("allProduct",bean);
        //     session.setAttribute("allclass",bean);
        return "findAllProduct";
    }

    //删除产品信息
    @RequestMapping("/deleteProduct")
    public String deleteProduct(String name,ModelMap model,HttpSession session){

        productService.delete(name);
        // session.commit();
        List<Product> bean = productService.getList();
        //  session.setAttribute("allclass",bean);
        model.addAttribute("allProduct",bean);
        return "findAllProduct";
    }

    //产品信息管理,先跳转到页面，在进行添加，保存
    @RequestMapping("/goToUpdateProduct")
    public String gotoUpdateClass(String name,ModelMap model){
        Product bean = productService.getById(name);
        model.addAttribute("updateOneProduct",bean);
        return "updateProduct";
    }

    @RequestMapping("/updateProduct")
    public String updateClass(Product product, ModelMap model,MultipartFile headImg) throws IOException {


        System.out.println(headImg.getName());//获取上传文件的表单名称

        System.out.println(headImg.getContentType());//MIME类型

        System.out.println(headImg.getSize());//文件大小

        System.out.println(headImg.getOriginalFilename());//获取上传文件的完整名称

//获取上传文件对应的输入流

//InputStream in = headImg.getInputStream();

//创建一个磁盘目录用于保存文件

        File destFile= new File("C:\\apache-tomcat-9.0.31\\webapps\\shouyiren\\logofile");

        if(!destFile.exists()) {

            destFile.mkdir();

        }

//使用uuid作为文件随机名称

        String fileName = UUID.randomUUID().toString().replaceAll("-", "");

//使用FileNameUtils获取上传文件名的后缀

        String extension = FilenameUtils.getExtension(headImg.getOriginalFilename());// jpg , png 等等

//创建新的文件名称

        String newFileName = fileName + "."+extension;

//创建要保存文件的File对象

        File file = new File(destFile, newFileName);

//保存文件到本地磁盘

        headImg.transferTo(file);
        product.setPicture(newFileName);

        boolean flag = productService.update(product);
        if(flag == true){
//            返回一个方法，调用查找全部学生方法，返回查找全部页面
            return "forward:/admin/allProduct";
        }
        else{
            model.addAttribute("msg","操作有误，请重新操作");
            return "error";
        }
    }
    //产品信息管理,先跳转到页面，在进行添加，保存
    @RequestMapping("/gotoAddProduct")
    public String gotoAddClass(){
        return "addProduct";
    }

    @RequestMapping(value = "/addProduct")
    public String addProduct(Product product, ModelMap model, HttpServletRequest request, MultipartFile headImg) throws IOException {

        if(productService.getById(product.getName()) !=null ) {
            JOptionPane.showMessageDialog(null,"产品名称已经存在，请重新输入");
            return "addProduct";
        }
        System.out.println(headImg.getName());//获取上传文件的表单名称

        System.out.println(headImg.getContentType());//MIME类型

        System.out.println(headImg.getSize());//文件大小

        System.out.println(headImg.getOriginalFilename());//获取上传文件的完整名称

//获取上传文件对应的输入流

//InputStream in = headImg.getInputStream();

//创建一个磁盘目录用于保存文件

        File destFile= new File("C:\\apache-tomcat-9.0.31\\webapps\\shouyiren\\logofile");

        if(!destFile.exists()) {

            destFile.mkdir();

        }

//使用uuid作为文件随机名称

        String fileName = UUID.randomUUID().toString().replaceAll("-", "");

//使用FileNameUtils获取上传文件名的后缀

        String extension = FilenameUtils.getExtension(headImg.getOriginalFilename());// jpg , png 等等

//创建新的文件名称

        String newFileName = fileName + "."+extension;

//创建要保存文件的File对象

        File file = new File(destFile, newFileName);

//保存文件到本地磁盘

        headImg.transferTo(file);
        product.setPicture(newFileName);


        boolean flag = productService.insert(product);
        if(flag == true){

            return "forward:/admin/allProduct";
        }
        else{
            model.addAttribute("msg","操作有误，请重新操作");
            return "error";
        }
    }


    //查询所有产品信息
    @RequestMapping("/allUser")
    public String allUser(ModelMap model,HttpSession session){
        List<User> bean = userService.getList();
        System.out.println(bean);
        model.addAttribute("allUser",bean);
        //     session.setAttribute("allclass",bean);
        return "findAllUser";
    }

    //删除产品信息
    @RequestMapping("/deleteUser")
    public String deleteUser(String id,ModelMap model,HttpSession session){

        userService.delete(id);
        // session.commit();
        List<User> bean = userService.getList();
        //  session.setAttribute("allclass",bean);
        model.addAttribute("allUser",bean);
        return "findAllUser";
    }

    //产品信息管理,先跳转到页面，在进行添加，保存
    @RequestMapping("/goToUpdateUser")
    public String goToUpdateUser(String tel,ModelMap model){
        User bean = userService.getById(tel);
        model.addAttribute("updateOneUser",bean);
        return "updateUser";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user, ModelMap model,MultipartFile headImg) throws IOException {
        boolean flag = userService.update(user);
        if(flag == true){
//            返回一个方法，调用查找全部学生方法，返回查找全部页面
            return "forward:/admin/allUser";
        }
        else{
            model.addAttribute("msg","操作有误，请重新操作");
            return "error";
        }
    }
    //产品信息管理,先跳转到页面，在进行添加，保存
    @RequestMapping("/gotoAddUser")
    public String gotoAddUser(){
        return "addUser";
    }

    @RequestMapping(value = "/addUser")
    public String addUser(User user, ModelMap model, HttpServletRequest request, MultipartFile headImg) throws IOException {

        boolean flag = userService.insert(user);
        if(flag == true){

            return "forward:/admin/allUser";
        }
        else{
            model.addAttribute("msg","操作有误，请重新操作");
            return "error";
        }
    }

    //查询所有产品信息
    @RequestMapping("/allVideo")
    public String allVideo(ModelMap model,HttpSession session){
        List<Video> bean = videoService.getList();
        System.out.println(bean);
        model.addAttribute("allVideo",bean);
        //     session.setAttribute("allclass",bean);
        return "findAllVideo";
    }

    //删除产品信息
    @RequestMapping("/deleteVideo")
    public String deleteVideo(String name,ModelMap model,HttpSession session){

        videoService.delete(name);
        // session.commit();
        List<Video> bean = videoService.getList();
        //  session.setAttribute("allclass",bean);
        model.addAttribute("allVideo",bean);
        return "findAllVideo";
    }

    //产品信息管理,先跳转到页面，在进行添加，保存
    @RequestMapping("/goToUpdateVideo")
    public String gotoUpdateVideo(String name,ModelMap model){
        Video bean = videoService.getById(name);
        model.addAttribute("updateOneVideo",bean);
        return "updateVideo";
    }

    @RequestMapping("/updateVideo")
    public String updateVideo(Video video, ModelMap model,MultipartFile headImg) throws IOException {


        System.out.println(headImg.getName());//获取上传文件的表单名称

        System.out.println(headImg.getContentType());//MIME类型

        System.out.println(headImg.getSize());//文件大小

        System.out.println(headImg.getOriginalFilename());//获取上传文件的完整名称

//获取上传文件对应的输入流

//InputStream in = headImg.getInputStream();

//创建一个磁盘目录用于保存文件

        File destFile= new File("C:\\apache-tomcat-9.0.31\\webapps\\shouyiren\\logofile");

        if(!destFile.exists()) {

            destFile.mkdir();

        }

//使用uuid作为文件随机名称

        String fileName = UUID.randomUUID().toString().replaceAll("-", "");

//使用FileNameUtils获取上传文件名的后缀

        String extension = FilenameUtils.getExtension(headImg.getOriginalFilename());// jpg , png 等等

//创建新的文件名称

        String newFileName = fileName + "."+extension;

//创建要保存文件的File对象

        File file = new File(destFile, newFileName);

//保存文件到本地磁盘

        headImg.transferTo(file);
        video.setPicture(newFileName);

        boolean flag = videoService.update(video);
        if(flag == true){
//            返回一个方法，调用查找全部学生方法，返回查找全部页面
            return "forward:/admin/allVideo";
        }
        else{
            model.addAttribute("msg","操作有误，请重新操作");
            return "error";
        }
    }
    //产品信息管理,先跳转到页面，在进行添加，保存
    @RequestMapping("/gotoAddVideo")
    public String gotoAddVideo(){
        return "addVideo";
    }

    @RequestMapping(value = "/addVideo")
    public String addVideo(Video video, ModelMap model, HttpServletRequest request, MultipartFile headImg) throws IOException {

        if(videoService.getById(video.getName()) !=null ) {
            JOptionPane.showMessageDialog(null,"视频名称已经存在，请重新输入");
            return "addVideo";
        }
        System.out.println(headImg.getName());//获取上传文件的表单名称

        System.out.println(headImg.getContentType());//MIME类型

        System.out.println(headImg.getSize());//文件大小

        System.out.println(headImg.getOriginalFilename());//获取上传文件的完整名称

//获取上传文件对应的输入流

//InputStream in = headImg.getInputStream();

//创建一个磁盘目录用于保存文件

        File destFile= new File("C:\\apache-tomcat-9.0.31\\webapps\\shouyiren\\logofile");

        if(!destFile.exists()) {

            destFile.mkdir();

        }

//使用uuid作为文件随机名称

        String fileName = UUID.randomUUID().toString().replaceAll("-", "");

//使用FileNameUtils获取上传文件名的后缀

        String extension = FilenameUtils.getExtension(headImg.getOriginalFilename());// jpg , png 等等

//创建新的文件名称

        String newFileName = fileName + "."+extension;

//创建要保存文件的File对象

        File file = new File(destFile, newFileName);

//保存文件到本地磁盘

        headImg.transferTo(file);
        video.setPicture(newFileName);


        boolean flag = videoService.insert(video);
        if(flag == true){

            return "forward:/admin/allVideo";
        }
        else{
            model.addAttribute("msg","操作有误，请重新操作");
            return "error";
        }
    }

    //查询所有产品信息
    @RequestMapping("/allComment")
    public String allComment(ModelMap model,HttpSession session){
        List<Comment> bean = commentService.getList();
        model.addAttribute("allComment",bean);
        //     session.setAttribute("allclass",bean);
        return "findAllComment";
    }

    //删除产品信息
    @RequestMapping("/deleteComment")
    public String deleteComment(String id,ModelMap model,HttpSession session){

        commentService.delete(id);
        // session.commit();
        List<Comment> bean = commentService.getList();
        //  session.setAttribute("allclass",bean);
        model.addAttribute("allComment",bean);
        return "findAllComment";
    }

    //产品信息管理,先跳转到页面，在进行添加，保存
    @RequestMapping("/goToUpdateComment")
    public String goToUpdateComment(String name,ModelMap model){
        Comment bean = commentService.getById(name);
        model.addAttribute("updateOneComment",bean);
        return "updateComment";
    }

    @RequestMapping("/updateComment")
    public String updateComment(Comment comment, ModelMap model,MultipartFile headImg) throws IOException {
        boolean flag = commentService.update(comment);
        if(flag == true){
//            返回一个方法，调用查找全部学生方法，返回查找全部页面
            return "forward:/admin/allComment";
        }
        else{
            model.addAttribute("msg","操作有误，请重新操作");
            return "error";
        }
    }
    //产品信息管理,先跳转到页面，在进行添加，保存
    @RequestMapping("/gotoAddComment")
    public String gotoAddComment(){
        return "addComment";
    }

    @RequestMapping(value = "/addComment")
    public String addComment(Comment comment, ModelMap model, HttpServletRequest request, MultipartFile headImg) throws IOException {

        boolean flag = commentService.insert(comment);
        if(flag == true){

            return "forward:/admin/allComment";
        }
        else{
            model.addAttribute("msg","操作有误，请重新操作");
            return "error";
        }
    }


}
