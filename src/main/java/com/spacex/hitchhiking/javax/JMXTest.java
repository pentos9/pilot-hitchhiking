package com.spacex.hitchhiking.javax;

import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;
import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.util.List;

public class JMXTest {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        List<VirtualMachineDescriptor> vms = VirtualMachine.list();
        if (CollectionUtils.isEmpty(vms)) {
            return;
        }

        vms.forEach(virtualMachineDescriptor -> {
            System.out.println(virtualMachineDescriptor.displayName());
            System.out.println(virtualMachineDescriptor.id());
            System.out.println(virtualMachineDescriptor.provider());

            VirtualMachine vm = null;
            try {
                vm = VirtualMachine.attach(virtualMachineDescriptor);
                System.out.println("vm:" + vm);
            } catch (AttachNotSupportedException | IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                return;
            }

        });
    }
}
