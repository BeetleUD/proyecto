package Proyecto;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
//--------------------------------------------------------------
- Usuarios identificados como idependientes deswde diferentes instancias.
- Al consultar datos este solo seÃ±alara la cantidad de datos en el arreglo
- la idea inicial fue utilizar JO, pero esa opcion queda descartada por la adaptacion de interfaces en ambos puntos
- Puedo trabajar con esto haciendo que el arreglo busque un numero espesifico, esto no se hizo asi pues para una busqueda de este tipo debi iniciar con un arbol binario como base
- Interprete el actualizar como brindar una list de lo mas reciente, no obstante otra opcion puede reflejar el cambio en tiempo real en una ventana emergente, tendria que investigar al respecto
- se habilito la opcion de cerrar aplicacion.
- case 3: Se debe señalar un dato existente de lo contrario... se debe crear una pocion/mnesaje que señale si esta o no el dato.

Nota: Eliminar archivos de la aplicacio no es prioridad, es opcional, asi mismo, lo es el ofreser la opcion de eliminar todo o pedir confirmacion para borrar del almacenamiento no impreso.
//--------------------------------------------------------------
*/

public class cliente_h extends Thread
{
    private DataInputStream in;
    private DataOutputStream out;

    public cliente_h (DataInputStream in, DataOutputStream out)
    {
        this.in = in;
        this.out = out;
    }
    
    @Override
    public void run()
    {
        Scanner sn = new Scanner(System.in);

        int opcion;
        String mensaje;
        boolean salir = false;

        while (!salir)
        {
            try
            {
                System.out.println("----------------------------\n"
                + "1.- Agregar                 \n"
                + "2.- Consultar               \n"
                + "3.- Actualizar              \n"
                + "4.- Eliminar                \n"
                + "5.- Salir                   \n"
                + "----------------------------\n");

                opcion = sn.nextInt();
                out.writeInt(opcion);
                
                switch(opcion)
                {
                    case 1: //  agregara tipo de dato - cliente
                    int aleatorio = RandomNum(1,10); // llama a RandomNum para generar un numero
                    System.out.println("Se a generado un numero: " + aleatorio + ".\n"); // confirma dato introducido
                    out.writeInt(aleatorio);
                    mensaje = in.readUTF();
                    System.out.println(mensaje);
                    break;
                    case 2: // consultara los tipos de datos - cliente
                    int almacenado = in.readInt();
                    System.out.println("Se tienen " + almacenado + " tipos de datos almacenados."); // refiriendoce a un conjunto de 2 como 1
                    break;
                    case 3: // actualizara el conjunto  - cliente
                    System.out.println("----------------------------\n");
                    int limite = in.readInt(); // debe escupir datos segun se confirman

                    for(int i = 0; i < limite; i++)
                    {
                        System.out.println(in.readInt());
                    }
                    System.out.println("----------------------------\n");
                    break;
                    case 4: // eliminara un elemento compuesto - cliente - en pruebas...
                    mensaje = in.readUTF(); 
                    System.out.println(mensaje);
                    break;
                    case 5: // saldra de la aplicacion - cliente
                    salir = true;
                    break;
                    default: // para recibir siempre el mensaje, pues permanece abierto para recibir la opcion
                    mensaje = in.readUTF(); 
                    System.out.println(mensaje);
                    break;
                }
            } catch (Exception ex)
            {
                Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int RandomNum (int min, int max) // asi nos ahorramos meter tanto dato, generandolos de manera aleatoria, por lo menos en pruebas
    {
        int num = (int)Math.floor(Math.random()*(max - min + 1) + (min));
        return num;
    }
}