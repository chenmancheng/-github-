package soft.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import soft.pojo.Admin;

import java.util.List;
@Mapper
@Repository
public interface AdminMapper {
    Admin getById(String tel);
    Admin login(@Param("tel") String tel, @Param("password") String password);
//    Admin getBytel(String aName);
    boolean insert(Admin bean);
    boolean update(Admin bean);
    List<Admin> getList();
}
