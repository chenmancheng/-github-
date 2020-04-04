package soft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft.mapper.UserMapper;
import soft.pojo.User;
import soft.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getById(String tel) {
        return userMapper.getById(tel);
    }

    @Override
    public User login(String tel, String password) {
        return userMapper.login(tel, password);
    }

    @Override
    public boolean insert(User bean) {
        return userMapper.insert(bean);
    }

    @Override
    public boolean update(User bean) {
        return userMapper.update(bean);
    }

    @Override
    public List<User> getList() {
        return userMapper.getList();
    }

    @Override
    public boolean delete(String id) {
        return userMapper.delete(id);
    }
}
