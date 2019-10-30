package com.offcn.userprovider01.Dao;

import com.offcn.userprovider01.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
}
