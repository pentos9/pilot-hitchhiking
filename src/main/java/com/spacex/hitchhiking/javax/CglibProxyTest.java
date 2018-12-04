package com.spacex.hitchhiking.javax;

import com.spacex.hitchhiking.javax.cglib.CglibProxy;
import com.spacex.hitchhiking.javax.cglib.interfaces.UserService;
import com.spacex.hitchhiking.javax.cglib.interfaces.UserServiceImpl;
import com.spacex.hitchhiking.util.PrintUtil;

public class CglibProxyTest {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        CglibProxy cglibProxy = new CglibProxy();
        UserService proxy = (UserService) cglibProxy.getProxy(userServiceImpl.getClass());
        String result = proxy.add("Knight");
        PrintUtil.println(result);
    }
}
