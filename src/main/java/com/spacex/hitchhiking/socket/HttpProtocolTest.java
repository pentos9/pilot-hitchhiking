package com.spacex.hitchhiking.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HttpProtocolTest {
    public static void main(String[] args) {
        try {
            run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void run() throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        final String host = "localhost:8080";

        try {
            Socket socket = new Socket(host, 443);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            outputStream.write("GET / HTTP/1.1\\n\".getBytes()".getBytes());
            outputStream.write("HOST:localhost:8080\\n".getBytes());
            outputStream.write("\n".getBytes());
            int i = inputStream.read();

            while (i != -1) {
                System.out.print((char) i);
                i = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
                inputStream = null;
            }

            if (outputStream != null) {
                outputStream.close();
                outputStream = null;
            }
        }
    }
}
