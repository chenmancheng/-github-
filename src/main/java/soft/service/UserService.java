package soft.service;

import org.apache.ibatis.annotations.Param;
import soft.pojo.User;

import java.util.List;

public interface UserService {
    User getById(String tel);
    User login(@Param("tel") String tel, @Param("password") String password);
    //    Admin getBytel(String aName);
    boolean insert(User bean);
    boolean update(User bean);
    List<User> getList();
    boolean delete(String id);
}
