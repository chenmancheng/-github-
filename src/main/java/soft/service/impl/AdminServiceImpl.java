package soft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soft.mapper.AdminMapper;
import soft.pojo.Admin;
import soft.service.AdminService;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin getById(String tel) {
        return adminMapper.getById(tel);
    }

    @Override
    public Admin login(String tel, String password) {
        return adminMapper.login(tel, password);
    }

    @Override
    public boolean insert(Admin bean) {
        return adminMapper.insert(bean);
    }

    @Override
    public boolean update(Admin bean) {
        return adminMapper.update(bean);
    }

    @Override
    public List<Admin> getList() {
        return adminMapper.getList();
    }
}
