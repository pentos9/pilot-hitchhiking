package com.spacex.hitchhiking.thread.local.classloader;

import java.net.URL;
import java.net.URLClassLoader;

public class CustomClassLoader extends URLClassLoader {
    public CustomClassLoader(URL... urls) {
        super(urls);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("*** CustomClassLoader finalized! ***");
    }
}
