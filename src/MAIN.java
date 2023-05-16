
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
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
 public static void visualizarFichero5() {
        
       
    try {
        BufferedReader reader = new BufferedReader(new FileReader("Productos.dat"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    } catch (IOException e) {
        System.out.println("Error al leer el archivo.");
        e.printStackTrace();
    }
}
    /*public static void leerArchivo(String archivo) {
        try {
            FileInputStream fileInputStream = new FileInputStream(archivo);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Object contenido = objectInputStream.readObject();

            // Hacer algo con el contenido del archivo
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/

    public static void main(String[] args) {
        ArrayList<Producto> lista = new ArrayList();
        ArrayList<Libro> listaLibro = new ArrayList();

        Scanner tcl = new Scanner(System.in);
        boolean repetir = true;
        do {
            System.out.print("------ PRACTICA FICHEROS -------\n\n1. Introduce un articulo\n2. Visualizar lista\n3. Pasar solo los Libros de ArrayList de Productos a un nuevo ArrayList y submenu visualizando diferentes maneras de ordenarlo  \n4. Guardar en fichero (Productos.dat)\n5. Leer el archivo Productos.dat \n6. Salir\nSeleccione una opcion: ");
           
            try{
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
                    MAIN.visualizarFichero5();
                    break;
                case 6:
                    System.out.println("Usted ha salido del programa");
                    repetir = false;
                    break;

                default:
                    System.out.println("No has introducido ninguna de las opciones dadas");
            }
        }catch(InputMismatchException e){
                System.out.println("Error: debe de introducir un numero valido");
                tcl.nextLine();
                }
        } while (repetir);
    }

}
