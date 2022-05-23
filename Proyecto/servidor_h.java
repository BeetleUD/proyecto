package Proyecto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

/*
//--------------------------------------------------------------
- Complemento que sive al cliente, una instancia que confirma y responde.

Nota: Descripcion detallada mas adelante, guia mediante comentarios por referencia.
//--------------------------------------------------------------
*/

public class servidor_h extends Thread
{
    private DataInputStream in;
    private DataOutputStream out;
    private String usuario;

    public servidor_h (DataInputStream in, DataOutputStream out, String usuario)
    {
        this.in = in;
        this.out = out;
        this.usuario = usuario;
    }

    public void run()
    {
        int opcion;
        File f = new File("Reporte_Generado.txt"); // imprime archivo de texto plano con datos referentes

        while(true)
        {
            try
            {
                opcion = in.readInt();
                
                switch(opcion)
                {
                    case 1: // agregara tipo de dato - servidor
                    int aleatorio = in.readInt();
                    ImpNum(f, aleatorio);
                    System.out.println("El usuarion " + usuario + " a realizado un cambio."); // confirma adicion
                    out.writeUTF("Numero almacenado.\n");
                    break;
                    case 2: // consultara los tipos de datos - servidor
                    break;
                    case 3: // actializara el conjunto - servidor
                    break;
                    case 4: // eliminara un elemento compuesto - servidor
                    break;
                    case 5: // saldra de la aplicacion - servidor
                    break;
                    default:
                    out.writeUTF("Seleccione una opcion segun su numero:");
                    break;
                }
            } catch (IOException e) // ex
            {
                e.printStackTrace(); // Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void ImpNum(File f, int aleatorio) throws IOException
    {
        FileWriter fw = new FileWriter(f, true);
        fw.write(usuario + ": " + aleatorio + "\r\n");
        fw.close();
    }
}