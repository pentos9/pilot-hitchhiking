package com.spacex.hitchhiking.annotation.cases;

import com.spacex.hitchhiking.annotation.define.ParamIsNotNull;

public class Bean {

    @ParamIsNotNull
    private String name;

    public Bean() {
    }

    public Bean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
