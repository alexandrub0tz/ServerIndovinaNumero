package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
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
            ServerSocket s = new ServerSocket(3000);
            Socket client = s.accept();
            System.out.println("il client e connesso");

            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            DataOutputStream out = new DataOutputStream(client.getOutputStream());


            int numeroRandom = (int) (Math.random() * 100) + 1; 
            System.out.println(numeroRandom);

            // In ascolto
            out.writeBytes("prova a indovinare! \n");
            

            int tentativi = 0;
            int risposta;
            do{
                risposta = Integer.parseInt(in.readLine());
                tentativi++;
                if(risposta < numeroRandom){
                    out.writeBytes("1\n");
                } else if (risposta > numeroRandom){
                    out.writeBytes("2\n");
                } else {
                    out.writeBytes("3\n");
                    out.writeBytes(tentativi + "\n");
                }

            } while(risposta != numeroRandom);

            client.close();
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
