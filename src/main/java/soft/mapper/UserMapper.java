package soft.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import soft.pojo.User;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    User getById(String tel);
    User login(@Param("tel") String tel, @Param("password") String password);
//    Admin getBytel(String aName);
    boolean insert(User bean);
    boolean update(User bean);
    List<User> getList();
    boolean delete(String id);
}
