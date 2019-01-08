package com.spacex.hitchhiking.socket;

import com.spacex.hitchhiking.util.PrintUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class RedisClientTest {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        String redisServerIp = "127.0.0.1";
        int port = 6379;

        try {
            Socket socket = new Socket(redisServerIp, port);
            String protocol = "*2\r\n$3\r\nget\r\n$3\r\nkey\r\n";//command:get key

            byte[] protocolBytes = protocol.getBytes();

            byte[] responseByteBuffer = new byte[1024];

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(protocolBytes);//send command data to redis

            InputStream inputStream = socket.getInputStream();
            inputStream.read(responseByteBuffer);

            PrintUtil.println(new String(responseByteBuffer));

            //raw RESP protocol response format: "$13\r\nmagellan-test\r\n"

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
