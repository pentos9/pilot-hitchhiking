package com.spacex.hitchhiking.generic.generator;

import java.util.UUID;

public class RandomeStringGenerator implements Generator<String> {
    @Override
    public String next() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
