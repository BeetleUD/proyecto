package proyecto;

import java.io.IOException;

import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.util.loggin.Level;
import java.util.loggin.Logger;

//--------------------------------------------------------------
import java.net.Socket; // servidor
import java.net.ServerSocket; // cliente
//--------------------------------------------------------------

/*
//--------------------------------------------------------------
- Retiene y se maneja con 2 tipos de datos

- Manipula en bsase a parametros pre-definidos por la interfas del cliente para recibir mas datos/ordenes (CLIENTESALIDA==ENTRADASERVIDOR???)

- Clase "Factory" no muy adecuada.

Nota: Usar puertos de entrada y salida simpre alerta, prueba con "while" y "for".
//--------------------------------------------------------------
*/

public class servidor
{
    public static void main (String[]]args)
    {
        Socket sc = null; // servidor
        ServerSocket servidor = null; // cliente

        DataInputStream in; // puerto de entrada
        DataOutputStream out; // puerto de salida
        
        int puerto = ; // el numero lo definire luego por potencial dispocicion variable

        try
        {
            servidor = new ServerSocket(puerto);
            
            System.out,println("Iniciando...");
            
            while(true) //Esto deberia mantenerce abierto, la idea es que el servidor no descanse, pues simpre puede haber alguien intentando axeder
            {
                sc = servidor.accept();
            }
        } catch (IOException ex)
        {
            Logger.getLogger(Servidor.class.getName()).log(level.SERVER, null, ex);
        }
    }
}