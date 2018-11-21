package com.spacex.hitchhiking.generic.convertor;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Collection;


public class ConvertorUtil {

    public static <T> Collection<T> fromArrayToCollection(T[] array) {

        Collection<T> aCollection = Lists.newArrayList();
        if (ArrayUtils.isEmpty(array)) {
            return aCollection;
        }

        for (T item : array) {
            aCollection.add(item);
        }

        return aCollection;
    }
}
