package soft.service;

import org.apache.ibatis.annotations.Param;
import soft.pojo.Admin;

import java.util.List;

public interface AdminService  {
    Admin getById(String tel);
    Admin login(@Param("tel") String tel, @Param("password") String password);
    //    Admin getBytel(String aName);
    boolean insert(Admin bean);
    boolean update(Admin bean);
    List<Admin> getList();
}
