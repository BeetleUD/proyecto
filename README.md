Proyecto:

- Desde el IDE se toman los archivos y ejecutan tanto "servidor.java" como "cliente.java".

- Los archivos ejecutados se deben tomar desde terminales distintas.
    
    De no poder utilizar 2 terminales de base:
    
    - 1.- Ejecutar el archivo directamente desde la barra lateral.
    - 2.- Utilizar 2 IDE.
    - 3.- Hacer uso de un par de equipos.

    Nota: Esto tomando en cuenta que cada archoivo se ejecuta de manera individual, 1 por terminal.

- Se ejecuta primero el servidor, esto es asi para que cuando se ejecute el cliente este pueda acceder al servidor, de ser al reves saltara un error (por tiempo de espera).

- Teniendo ya ambos main corriendo este pedira un usuario para posterior a eso mostrar un menu, todo cambio realizado se vera reflejado en el servidor con una confirmacion por texto qyue señalara la accion, desde señalar el usuario que se a conectado hasta el que salio recientemente.

- El programa debe generar un reporte que a su vez señala si se introdujo un dato con aterioridad asi como mostrara al usuario (dedicando en el proceso un hilo por usuario) que introduujo el dato, esto se mostrara independiente del usuario que introdujo el dato, con esto manejamos 2 tipos de datos y se dedica un hilo por usuario al acceder a el servidor.

    Menu:

    - Agregar: Agregara un nuevo dato a el almacenamiento del servidor (para agilizar el proceso se añadio un metodo que genera un numero aleatorio).

    - Consultar: Dara un numero en relacion a la cantidad de datos almacenados.

    - Actualizar: Enlistara los datos almacenados independiente del usuario que introdujo los datos.

    - Eliminar: Eliminara un dato exacto, la cuiestion es que no podra eliminar el dato de un reporte ya generado.

--------------------------------------------------------------

 Requisitos del proyecto Final:

- Entrega posterior al 13 de Mayo / Entregar antes del día 27 de Mayo.
- Programa basado en el modelo Cliente-Servidor, implementando Sockets e Hilos.
- El lenguaje puede ser Java, C o Python.
- Crear un repositorio privado en Github y agregar como colaborador a: "jatempa" .
- Deben usar Git para estar manifestando progreso (Nota: La idea es dar seguimiento al trabajo).
- Es importante que plantees una temática que se sustente de dos tipos de datos relacionados.
- El proyecto debe funcionar para los objetivos planteados en un correo anterior, sin ninguna falla.
- Si no hacen preguntas o presentan avances (Nota: El puntuaje sera menor y no habra margen para cambios).

# Opcional

- Un gestor de base de datos como MySQL pueden ser utilizados (Nota: Será más valorado trabajar con lectura/escritura de archivos).
- Pueden hacerlo en equipo de dos personas, si algún miembro desiste de hacer el proyecto, el otro miembro será responsable (Nota: Se debe avisar con tiempo).

---------------------------------------------------------------

- Ejemplificacion por pasos:

- 1.- El cliente presenta Menú para acciones relacionadas con: Agregar, Consultar, Actualizar y Eliminar información de ambas entidades de datos, "alumnos" y "carreras".

    - El usuario selecciona una opción
    - El proceso Cliente recaba información
    - Posteriormente se hace un envío de los datos hacia el proceso servidor. 

- 2.- El proceso servidor se maneja a través de un HILO las acciones solicitadas por el proceso cliente (un hilo para cada acción).

---------------------------------------------------------------
Nota: Puedes omitir el uso de Hilos, pero de nuevo, el uso de hilos se valora y califica mejor que el no utilizarlos.

    Si el usuario desea agregar un nuevo alumno, el Servidor creará un Hilo para manipular el archivo "alumnos.db" y agregar no solo los datos del alumno sino la carrera a la que está asociada, sin corromper o alterar datos previos en caso de que el archivo no esté vacío.
---------------------------------------------------------------

- 3.- Tomando en consideración lo anterior, el programa del lado del cliente debe solicitar la información requerida al usuario y presentar la información correcta para poder solicitar los datos del registro de un alumno y tambien presentar las carreras vigentes.

- 4.- Existen dos tipos de datos:

    - Los catálogos: Información que debe existir para poder trabajar.
        
        - Si el archivo de carreras no tiene datos, es imposible asociar el alumno a una carrera, por lo que debes contar con carreras antes de querer agregar alumnos, validar esto último en el proceso Cliente.

    - El programa cliente: No puede acceder a ningún archiv.(alumnos.db y carreras.db), sino por el contrario mantener comunicación con el Servidor para que este sea el que acceda a dicha información. 

- Nota: El servidor es el encargado de procesar todas las acciones solicitadas por el cliente y el cliente debe presentar los resultados obtenidos de dichas acciones.