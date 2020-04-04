package soft.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import soft.pojo.Comment;
import soft.pojo.User;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    Comment getById(String name);
    boolean insert(Comment bean);
    boolean update(Comment bean);
    List<Comment> getList();
    boolean delete(String id);
}
