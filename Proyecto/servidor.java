package Proyecto;

import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/*
//--------------------------------------------------------------
- Se debe corroborar tanto IP como puerto antes de su ejecucion.

Nota: Debe estar activo sntes de activar el cliente.
//--------------------------------------------------------------
*/

public class servidor
{
    public static void main (String[]args)
    {
        try 
        {
            ServerSocket server = new ServerSocket(7327);
            Socket sc;

            System.out.println("Servidor iniciado");

            while(true)
            {
                sc = server.accept();

                DataInputStream in = new DataInputStream(sc.getInputStream());
                DataOutputStream out = new DataOutputStream(sc.getOutputStream());

                out.writeUTF("Incerte nombre de ususario: ");
                String usuario = in.readUTF();

                servidor_h hilo = new servidor_h(in, out, usuario, sc);
                hilo.start(); //inicia hilo dedicado por usuario
            
                System.out.println("Conexion establecida con " + usuario);
            }
        }catch (IOException e) // ex
        {
            e.printStackTrace(); // Logger.getLogger(servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}