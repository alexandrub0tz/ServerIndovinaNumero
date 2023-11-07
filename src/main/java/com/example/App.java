package com.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            ServerSocket s = null;
            s = new ServerSocket(3000);
            while (true) { 
                Socket client = s.accept();
                Thread t = new serverMultiThread(client);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }        
}
