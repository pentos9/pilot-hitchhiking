package com.spacex.hitchhiking.javax.cglib.interfaces;


public class UserServiceImpl implements UserService {
    @Override
    public String add(String username) {
        return username;
    }
}
