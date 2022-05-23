package Prueba_Servidor;

import java.io.IOException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.Socket; // servidor
import java.net.ServerSocket; // cliente

/*
//--------------------------------------------------------------
- Retiene y se maneja con 2 tipos de datos
- Manipula en bsase a parametros pre-definidos por la interfas del cliente para recibir mas datos/ordenes.
- Clase "Factory" no muy adecuada.
- 

Nota: Si el servidor no esta activo para cuando la conexion inicia entonces no habra respuesta. 
//--------------------------------------------------------------
*/

public class servidor
{
    public static void main (String[]args)
    {
        Socket sc = null; // servidor
        ServerSocket servidor = null; // cliente

        DataInputStream in; // puerto de entrada
        DataOutputStream out; // puerto de salida
        
        final int PORT = 7327; // el numero de puerto queda a definir --- debe coincidir con el cliente --- pero es provicional

        try
        {
            servidor = new ServerSocket(PORT);
            
            System.out.println("Servidor en linea.");
            
            while(true) //Esto deberia mantenerce abierto, la idea es que el servidor no descanse, pues simpre puede haber alguien intentando axeder
            {
                sc = servidor.accept();
                System.out.println("Conectando...");

                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                String mensaje = in.readUTF();

                System.out.println(mensaje);
                out.writeUTF("Enlace establecido con el cliente"); // confirma la conexion 

                sc.close();
                System.out.println("Desconectado.");
            }
        } catch (IOException ex)
        {
            Logger.getLogger(servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}