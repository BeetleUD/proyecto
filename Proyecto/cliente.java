package Proyecto;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/*
//--------------------------------------------------------------
- La IP debe ser correcta y ser introducida antes de su ejecucucion y luego de tener el servidor en linea.

Nota: Si el cliente no corre habra que modificar el IOException "e" a "ex".
//--------------------------------------------------------------
*/

public class cliente
{
    public static void main (String[]args)
    {
        try
        {
            Scanner sn = new Scanner(System.in);

            sn.useDelimiter("\n"); 

            Socket sc = new Socket("", 5050); // entre comillas la direccion ip
        
            DataInputStream in = new DataInputStream(sc.getInputStream());
            DataOutputStream out = new DataOutputStream(sc.getOutputStream());

            String mensaje = in.readUTF();
            System.out.println(mensaje);

           String nombre = sn.next();
           out.writeUTF(nombre);

            cliente_h hilo = new cliente_h(in, out);
            hilo.start();
            hilo.join();
            
        } catch (IOException e) // ex
        {
            e.printStackTrace(); // Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        }catch (InterruptedException e) // ex
        {
            e.printStackTrace(); //Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}