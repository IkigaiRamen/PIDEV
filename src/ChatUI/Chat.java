/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatUI;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

/**
 *
 * @author khoualdi koussay
 */
public class Chat extends Thread {
    private int numClient ;
    private Socket sock_client;
    private ArrayList<Socket> listClientsConnectee ;
   
    public Chat(int numClient , Socket sock_client,ArrayList<Socket> listClientsConnectee)
    {
        this.numClient = numClient;
        this.sock_client = sock_client;
        this.listClientsConnectee = listClientsConnectee;
        
    }
    @Override
    public void run(){
        System.out.println("Client <"+numClient+">connected...");
        InputStream is;
        try{
            //recupperation du flux de lecture avec le client "sock_client"
            is = sock_client.getInputStream();
            InputStreamReader ipsr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(ipsr);
            OutputStream os = sock_client.getOutputStream();
            PrintWriter writer = new PrintWriter(os,true);
             
            writer.println("\n Vous etes connecte en tant que Client "+numClient+"!\n");
            String msg;
            int nbclient;
            while(true)
            {
                //n'envoyer qu'auprés avoir lire .. a partir du client "numClient"
                msg = reader.readLine();
              
                if(msg!=null)
                {
                    for(Socket socket : listClientsConnectee ){
                        // on va envoyer a tous les autres clients "sauf" sock_client
                        if(socket!=sock_client){
                            //recupération du flux d'ecriture (avec les autres clients)
                            OutputStream aos = socket.getOutputStream();
                            PrintWriter other_sock_writer = new PrintWriter(aos,true);
                            //affichage sophistiqué
                            other_sock_writer.println("\nClient "+ numClient+" :"+msg);
                        }
                    }
                }
            }
        } catch (IOException e){}
    }
    
}
