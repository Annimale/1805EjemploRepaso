
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ivamar
 */
public class MAIN {

    public static void introducirDatosTV(ArrayList<Producto> lista) {
        Scanner tcl = new Scanner(System.in);

        int precioNormal = 0;
        String fabricante = "";
        int tamanio = 0;
        int eleccion;
        do {
            System.out.println("Introduzca el precio normal");
            precioNormal = tcl.nextInt();
            System.out.println("Introduzca el fabricante");
            tcl.nextLine();
            fabricante = tcl.nextLine();
            System.out.println("Introduzca el tamanyo");
            tamanio = tcl.nextInt();

            TV televisionObj = new TV(precioNormal, fabricante, tamanio);
            lista.add(televisionObj);
            System.out.println("Desea introducir otra TV? 1:Si  2:No");
            eleccion = tcl.nextInt();
        } while (eleccion == 1);
    }

    public static void introducirDatosLibro(ArrayList<Producto> lista) {
        Scanner tcl = new Scanner(System.in);

        int precioNormal = 0;
        String editor = "";
        int anioPub = 0;
        int eleccion;
        do {
            System.out.println("Introduzca el editor");
            editor = tcl.nextLine();

            System.out.println("Introduzca anyo de publicacion");

            anioPub = tcl.nextInt();
            System.out.println("Introduzca el precio normal");
            precioNormal = tcl.nextInt();

            Libro libroObj = new Libro(editor, anioPub, precioNormal);
            lista.add(libroObj);
            System.out.println("Desea introducir otro libro? 1:Si  2:No");
            eleccion = tcl.nextInt();
            tcl.nextLine();
        } while (eleccion == 1);

    }

    public static void guardarProductos(ArrayList<Producto> lista) {

        String archivo = "Productos.dat";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(archivo);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(lista);

            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Archivo Productos.dat creado exitosamente.");

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
            e.printStackTrace();
        }
    }
/*
    1.Se define el método guardarProductos como público y estático, lo que significa que se puede acceder a él sin necesidad de crear una instancia de la clase que lo contiene.

2.Se declara una variable de tipo String llamada archivo y se le asigna el nombre del archivo de destino, en este caso "Productos.dat". Este será el archivo donde se guardarán los objetos.

3.Se utiliza un bloque try-catch para manejar las posibles excepciones que pueden ocurrir durante la escritura en el archivo.

4.Dentro del bloque try, se crea un objeto FileOutputStream llamado fileOutputStream pasando como argumento el nombre del archivo. Esto abre un flujo de salida de archivo para escribir en el archivo "Productos.dat".

5. A continuación, se crea un objeto ObjectOutputStream llamado objectOutputStream pasando como argumento el fileOutputStream. Esto permite escribir objetos en el archivo.

6.Se utiliza el método writeObject de objectOutputStream para escribir el objeto lista en el archivo. Este método se encarga de serializar el objeto y escribirlo en el archivo en un formato binario.

7. Luego, se cierran los flujos de salida en orden inverso al que se abrieron, es decir, primero se cierra objectOutputStream y luego fileOutputStream. Esto asegura que los datos se escriban y se guarden correctamente en el archivo antes de cerrar los flujos.

8. Si no se produce ninguna excepción, se muestra un mensaje de éxito en la consola indicando que el archivo "Productos.dat" se ha creado correctamente.

9. Si ocurre alguna excepción durante el proceso de escritura, se captura en el bloque catch. En ese caso, se muestra un mensaje de error en la consola y se imprime la traza de la excepción utilizando el método printStackTrace().

En resumen, el método guardarProductos se encarga de escribir un objeto ArrayList<Producto> en un archivo binario llamado "Productos.dat". Utiliza flujos de salida de archivo y un objeto ObjectOutputStream para realizar la serialización y escritura de los datos en el archivo.
    */
    public static void leerProductosDesdeArchivo() {

        try {
            FileInputStream fileIn = new FileInputStream("Productos.dat");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            ArrayList<Producto> lista = (ArrayList) objectIn.readObject();//Esto es lo que me faltaba
            for (Producto producto : lista) {//Esto es lo que me faltaba
                System.out.println(producto);//Esto es lo que me faltaba
            }
            
            objectIn.close();
            fileIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
/*
    1. Se define el método leerProductosDesdeArchivo como público y estático.

2. Se utiliza un bloque try-catch para manejar las posibles excepciones que pueden ocurrir durante la lectura del archivo.

3. Dentro del bloque try, se crea un objeto FileInputStream llamado fileIn pasando como argumento el nombre del archivo "Productos.dat". Esto abre un flujo de entrada de archivo para leer los datos del archivo.

4. A continuación, se crea un objeto ObjectInputStream llamado objectIn pasando como argumento el fileIn. Esto permite leer objetos del archivo.

5. Se lee el objeto ArrayList<Producto> del archivo utilizando el método readObject() de objectIn y se almacena en una variable local llamada lista. Aquí, se realiza un cast (ArrayList) para indicar que se espera un objeto ArrayList en la lectura del archivo.

6. Luego, se itera sobre los elementos de la lista utilizando un bucle for-each para recorrer cada Producto en lista.

7. Dentro del bucle, se muestra cada Producto en la consola utilizando System.out.println(producto). Esto imprimirá una representación legible del objeto Producto en la consola.

8. Después de finalizar el bucle, se cierran los flujos de entrada en orden inverso al que se abrieron, es decir, primero se cierra objectIn y luego fileIn. Esto asegura que los recursos se liberen correctamente.

9. Si ocurre alguna excepción durante el proceso de lectura, se captura en el bloque catch. En ese caso, se muestra la traza de la excepción utilizando el método printStackTrace().
    */
    public static void main(String[] args) {
        ArrayList<Producto> lista = new ArrayList();
        ArrayList<Libro> listaLibro = new ArrayList();
        String Productos = "Productos.dat";
        Scanner tcl = new Scanner(System.in);
        boolean repetir = true;
        do {
            System.out.print("------ PRACTICA FICHEROS -------\n\n1. Introduce un articulo\n2. Visualizar lista\n3. Pasar solo los Libros de ArrayList de Productos a un nuevo ArrayList y submenu visualizando diferentes maneras de ordenarlo  \n4. Guardar en fichero (Productos.dat)\n5. Leer el archivo Productos.dat \n6. Salir\nSeleccione una opcion: ");

            try {
                byte eleccion = tcl.nextByte();

                repetir = true;
                switch (eleccion) {
                    case 1:
                        System.out.println("Quiere introducir una TV o un Libro     1:TV    2:Libro");
                        byte eleccion1 = tcl.nextByte();
                        switch (eleccion1) {
                            case 1:
                                System.out.println("Introduciendo TV");
                                MAIN.introducirDatosTV(lista);
                                break;
                            case 2:
                                System.out.println("Introduciendo Libro");
                                MAIN.introducirDatosLibro(lista);
                                break;
                            default:
                                System.out.println("No has introducido ninguna de las opciones dadas");

                        }
                    case 2:
                        System.out.println("Visualizando lista");
                        for (int i = 0; i < lista.size(); i++) {
                            System.out.println(lista.get(i));
                        }
                        break;

                    case 3:
                        System.out.println("Pasando todos los libros a listaLibro");

                        listaLibro.clear();//Este clear lo metemos para cada vez que pulsamos el 3 no vuelva a añadir los objetos que ya hay en el ArrayList
                        for (int i = 0; i < lista.size(); i++) {
                            if (lista.get(i) instanceof Libro) {
                                listaLibro.add((Libro) lista.get(i));//Aqui añadimos si es un libro los libros al arraylist
                            }
                            /*for (Producto producto :lista) {
                        if (producto instanceof Libro) {//Es lo mismo que lo de arriba 
                            listaLibro.add((Libro)producto);
                        }
                    }*/
                        }
                        System.out.println("1: Si quieres ordenarlos de menor a mayor por anioPublicacion \n 2: Si quieres ordenarlos alfabeticamente de menor a mayor por editor \n 3: Si quieres ordenarlos alfabeticamente de mayor a menor por editor");
                        byte eleccion3 = tcl.nextByte();
                        switch (eleccion3) {
                            case 1:
                                System.out.println("Ordenando de menor a mayor por anioPublicacion");
                                Collections.sort(listaLibro);
                                for (int i = 0; i < listaLibro.size(); i++) {
                                    System.out.println(listaLibro.get(i));
                                }
                                break;
                            case 2:
                                Collections.sort(listaLibro, new EditorComparator());
                                for (int i = 0; i < listaLibro.size(); i++) {
                                    System.out.println(listaLibro.get(i));
                                }
                                break;
                            case 3:
                                Collections.sort(listaLibro, new EditorComparator().reversed());
                                for (int i = 0; i < listaLibro.size(); i++) {
                                    System.out.println(listaLibro.get(i));
                                }
                                break;
                            default:
                                System.out.println("No has introducido ninguna de las opciones dadas");
                        }
                        break;
                    case 4:
                        MAIN.guardarProductos(lista);
                        break;
                    case 5:
                        MAIN.leerProductosDesdeArchivo();
                        break;
                    case 6:
                        System.out.println("Usted ha salido del programa");
                        repetir = false;
                        break;

                    default:
                        System.out.println("No has introducido ninguna de las opciones dadas");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: debe de introducir un numero valido");
                tcl.nextLine();
            }
        } while (repetir);
    }

}
