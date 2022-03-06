/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChatUI;
import ChatUI.Chat;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
/**
 *
 * @author khoualdi koussay
 */
public class ServerChat {
    public static void main(String[] args)
    {
    ArrayList<Socket> listClientsConnectee = new ArrayList<Socket>(); 
    int numClient =0;
    ServerSocket serv_sock;
    
 
    
        try{
            serv_sock = new ServerSocket(9000);
            Socket socket = null;
            
            while(true)
            {
                Socket sock_client = serv_sock.accept();
                listClientsConnectee.add(sock_client);
                numClient++;
                new Chat(numClient,sock_client,listClientsConnectee).start();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
