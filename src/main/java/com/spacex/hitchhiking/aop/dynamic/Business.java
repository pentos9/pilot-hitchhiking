package com.spacex.hitchhiking.aop.dynamic;

import com.spacex.hitchhiking.aop.dynamic.interfaces.IBusiness;
import com.spacex.hitchhiking.aop.dynamic.interfaces.IBusiness2;
import com.spacex.hitchhiking.util.PrintUtil;

public class Business implements IBusiness, IBusiness2 {

    @Override
    public void doJob() {
        PrintUtil.println("Business#doJob ...");
    }

    @Override
    public void doJob2() {
        PrintUtil.println("Business#doJob2 ...");
    }
}
