package Hilo;

import java.io.IOException;
import java.net.Socket;

import java.util.Scanner;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.util.logging.Level;
import java.util.logging.Logger;

public class cliente
{
    public static void main (String[]args)
    {
        try
        {
            Scanner sn = new Scanner(System.in);
            sn.useDelimiter("\n");

            Socket sc = new Socket("", 7327); // entre comillas la direccion ip
        
            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());

            String mensaje = in.readUTF();
            System.out.println(mensaje);

            String nombre = sn.next();
            out.writeUTF(nombre);

            cliente_h hilo = new cliente_h(in, out);
            hilo.start();
            hilo.join();
            
        } catch (IOException ex)
        {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        }catch (InterruptedException ex)
        {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
