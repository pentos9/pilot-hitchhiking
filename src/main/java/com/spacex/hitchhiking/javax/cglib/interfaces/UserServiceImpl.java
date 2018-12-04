package com.spacex.hitchhiking.javax.cglib.interfaces;

import com.spacex.hitchhiking.util.PrintUtil;

public class UserServiceImpl implements UserService {
    @Override
    public String add(String username) {
        PrintUtil.println(String.format("UserServiceImpl#add username:" + username));
        return username;
    }
}
