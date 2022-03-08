/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets.chat_app;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientChat {
    private static Socket sock_client;
    public static void main(String[] args)throws UnknownHostException,IOException{
        //creation du socket client
        sock_client = new Socket("localhost",9000);
        
        //recuperation du flux de lecture avec le serveur
        InputStream is = sock_client.getInputStream();
        InputStreamReader ipsr = new InputStreamReader(is);
        final BufferedReader reader = new BufferedReader(ipsr);
        // recuperation du flux d'ecriture avec le serveur
        OutputStream os = sock_client.getOutputStream();
        final PrintWriter writer = new PrintWriter(os,true);
        Thread reception = new Thread (new Runnable(){
            String msg;
            
            @Override
            public void run()
            {
                while (true)
                {
                    try
                    {
                        msg = reader.readLine();
                        if(msg!=null)System.err.println(msg);
                    }catch(IOException e){}
                }
            }
        });
        
        Thread emission = new Thread(new Runnable(){
            private Scanner sc;
            @Override
            public void run(){
                while(true){
                   
                   sc = new Scanner(System.in);
                    //pour lire a partir de l'entré standard 
                    
                    String str = sc.nextLine();
                    //envoyer ce qui est été lu
                    writer.println(str);
                }
            }
        });
        emission.start();
        reception.start();
    }
}
