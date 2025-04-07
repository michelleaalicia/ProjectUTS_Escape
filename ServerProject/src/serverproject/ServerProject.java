/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package serverproject;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class ServerProject {
    
    static ArrayList<LoginClass> listOfLogin = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
     
       listOfLogin.add(new LoginClass());
       
        ServerSocket serverSocket = null;
        Socket incoming = null;
        
        try
        {
            serverSocket = new ServerSocket(6000);
            System.out.println("Server is running on port 6000...");

            while (true) 
            { // Loop agar server tetap berjalan
                incoming = serverSocket.accept();
                System.out.println("Client connected!");
                
                BufferedReader msgFromClient = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
                DataOutputStream msgToClient = new DataOutputStream(incoming.getOutputStream());

                String message = msgFromClient.readLine();
                if (message != null) 
                {
                    System.out.println("Received: " + message);
                    String[] commands = message.split("~");

                    if (commands.length >= 3 && commands[0].equals("LOGIN")) {
                        boolean tmp = checkLogin(commands[1], commands[2]);
                        msgToClient.writeBytes(tmp ? "TRUE\n" : "FALSE\n");
                    } else if (commands[0].equals("REGISTER")) {
                        // Tambahkan proses registrasi di sini jika diperlukan
                        msgToClient.writeBytes("REGISTER FEATURE NOT IMPLEMENTED\n");
                    } else {
                        msgToClient.writeBytes("INVALID COMMAND\n");
                    }
                }
                
                msgFromClient.close();
                msgToClient.close();
                incoming.close();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally 
        {
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
    }
     public static boolean checkLogin(String username, String password) {
        for (LoginClass login : listOfLogin) {
            if (login.getUsername().equals(username) && login.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    
}
