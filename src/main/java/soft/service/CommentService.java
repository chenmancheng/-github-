package soft.service;

import org.apache.ibatis.annotations.Param;
import soft.pojo.Comment;
import soft.pojo.User;

import java.util.List;

public interface CommentService {
    Comment getById(String name);
    boolean insert(Comment bean);
    boolean update(Comment bean);
    List<Comment> getList();
    boolean delete(String id);
}
