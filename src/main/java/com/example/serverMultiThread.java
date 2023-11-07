package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class serverMultiThread extends Thread {

    Socket client;

    public serverMultiThread(Socket c){
        this.client = c;

    }

    public void run(){
        try {

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


        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}
