package com.offcn.userprovider01.service;

import com.offcn.userprovider01.Dao.UserDao;
import com.offcn.userprovider01.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userdao;

    @Override
    public List<User> getUserList() {
        return userdao.findAll();
    }

    @Override
    public void createUser(User user) {
        userdao.save(user);
    }

    @Override
    public User getUser(Long id) {
        return userdao.findById(id).get();
    }

    @Override
    public void updateUser(Long id, User user) {
        user.setId(id);
        userdao.saveAndFlush(user);
    }

    @Override
    public void deleteUser(Long id) {
        userdao.deleteById(id);
    }
}
