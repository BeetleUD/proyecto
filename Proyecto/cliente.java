package Proyecto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
//--------------------------------------------------------------
- La IP debe ser correcta y ser introducida antes de su ejecucucion y luego de tener el servidor en linea.
- Linea 29: el numero entre comillas corresponde al HOST
- En respuesta a la entrada del servidor que detecta un nuevo usuario, el cliente marcara (como si fuese un "checkador" su entrada o salida) 
- Reflejara todos sus movimientos en otras secciones partiendo de A.

Nota: Revisar que el servidor este en linea antes de su ejecucion.
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

            Socket sc = new Socket("", 7032); // -------------------
        
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