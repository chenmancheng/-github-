package soft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft.mapper.CommentMapper;
import soft.mapper.UserMapper;
import soft.pojo.Comment;
import soft.pojo.User;
import soft.service.CommentService;
import soft.service.UserService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper CommentMapper;

    @Override
    public Comment getById(String name) {
        return CommentMapper.getById(name);
    }

    @Override
    public boolean insert(Comment bean) {
        return CommentMapper.insert(bean);
    }

    @Override
    public boolean update(Comment bean) {
        return CommentMapper.update(bean);
    }

    @Override
    public List<Comment> getList() {
        return CommentMapper.getList();
    }

    @Override
    public boolean delete(String id) {
        return CommentMapper.delete(id);
    }
}
