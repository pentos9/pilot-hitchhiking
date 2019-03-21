package com.spacex.hitchhiking.reflect;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

public class IntrospectionTest {

    private static class Cpu {
        private Long id;
        private String name;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {

        Cpu cpu = new Cpu();
        cpu.setId(12345L);
        cpu.setName("cup");
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(Cpu.class);
            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor propertyDescriptor : descriptors) {
                System.out.println(propertyDescriptor.getName());
                System.out.println(propertyDescriptor.getReadMethod().invoke(cpu, null));
            }
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
