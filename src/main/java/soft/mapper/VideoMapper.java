package soft.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import soft.pojo.Product;
import soft.pojo.Video;

import java.util.List;

@Mapper
@Repository
public interface VideoMapper {
    Video getById(String name);
//    Admin getBytel(String aName);
    boolean insert(Video bean);
    boolean update(Video bean);
    List<Video> getList();
    boolean delete(String name);
}
