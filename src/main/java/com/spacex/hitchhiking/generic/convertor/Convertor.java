package com.spacex.hitchhiking.generic.convertor;

import java.util.Collection;

public interface Convertor {
    <T> Collection<T> fromArrayToCollection(T[] array, Collection collection);
}
