package Proyecto;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.Socket;

/*
//--------------------------------------------------------------
- Complemento que sive al cliente, una instancia que confirma y responde.
- El agregar tipo de dato agiliza el procedimiento generando numeros aleatorios del 1 al 10.
- Se implemento un contador varios metodos para llevar el conteo de elementos almacenados.
- Se utiliza un arreglo para imprimir los datos, este a su vez actua como filtro, divide los datos impresos y muestra el numero de interes.
- se habilito la opcion de cerrar aplicacion.

Nota: cliete_h posee los datos puntuados y notas pendientes.
//--------------------------------------------------------------
*/

public class servidor_h extends Thread
{
    private DataInputStream in;
    private DataOutputStream out;
    private String usuario;
    private Socket sc;

    public servidor_h (DataInputStream in, DataOutputStream out, String usuario, Socket sc)
    {
        this.in = in;
        this.out = out;
        this.usuario = usuario;
        this.sc = sc;
    }
    
    @Override
    public void run()
    {
        int opcion;
        File f = new File("Reporte_Generado.txt"); // imprime archivo de texto plano con datos referentes (ejem: el reporte seÃ±alara el usuario y el dato introducido)
        boolean salir = false;

        while(!salir)
        {
            try
            {
                ArrayList<Integer> NumS = NumList(f); // paso de estar en el case 3 a fuera para servir en el 4
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
                    int almacenado = AlmTot(f); // almacenado total
                    out.writeInt(almacenado); // devuelve una lista de los numeros generados independientemente del usuario de origen
                    break;
                    case 3: // actualizara el conjunto - servidor
                    out.writeInt(NumS.size());

                    for(int D:NumS)
                    {
                        out.writeInt(D);
                    }
                    break;
                    case 4: // eliminara un elemento compuesto - servidor
                    String Elim = in.toString(); // Recibe el dato exacto a buscar --------------- sujeto a pruebas...
                    NumS.remove((Elim)); // new Integer // 
                    System.out.println("El usuarion " + usuario + " a realizado un cambio."); // confirma adicion
                    out.writeUTF("Se a eliminado un dato almacenado.\n");
                    break;
                    case 5: // saldra de la aplicacion - servidor
                    System.out.println("Cerrando secion...");
                    salir = true;
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
        
        try
        {
            sc.close();
        } catch (Exception e)
        {
            // no se que poner aqui
        }
        System.out.println(" --- Conexion terminada con " + usuario + " --- ");
    }
    // este texto plano es lo que se vera reflejado como contenido en el archivo generado
    public void ImpNum(File f, int aleatorio) throws IOException
    {
        FileWriter fw = new FileWriter(f, true);
        fw.write(usuario + ": " + aleatorio + "\r\n"); 
        fw.close();
    }

    public int AlmTot(File f) throws IOException // el numero de datos incrementa con el contador cada que detecta uno nuevo
    {
        int almacenado = 0;

        BufferedReader br = new BufferedReader(new FileReader(f)); 
        String dato = "";

        while ((dato = br.readLine()) != null)
        {
            almacenado++; 
        }
        br.close();
        return almacenado;
    }
    // divide el dato por partes tomando como fragmento en un dato 2 el numero que nos interesa
    public ArrayList<Integer> NumList(File f) throws FileNotFoundException, IOException
    {
        ArrayList<Integer> NumS = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(f));
        String dato = "";

        while ((dato = br.readLine()) != null)
        {
            String[] dato2 = dato.split(":"); // nos aseguramos de tomar el numero /tipo de dato/

            int Num = Integer.parseInt(dato2[1]);
            NumS.add(Num);
        }  
        br.close();
		return NumS; // cicla proceso
    }
}