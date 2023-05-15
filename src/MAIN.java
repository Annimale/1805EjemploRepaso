
import java.util.ArrayList;
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

        } while (eleccion == 1);

    }

    public static void main(String[] args) {
        ArrayList<Producto> lista = new ArrayList();
        Scanner tcl = new Scanner(System.in);
        boolean repetir = true;
        do {
            System.out.print("------ PRACTICA FICHEROS -------\n\n1. Introduce un articulo\n2. Visualizar lista\n3. Modificar \n4. Borrar por carnet\n5. Salir \nSeleccione una opcion: ");
            byte eleccion = tcl.nextByte();

            repetir = true;
            switch (eleccion) {
                case 1:
                    System.out.println("Quiere introducir una TV o un Libro     1:TV    Else:Libro");
                    byte eleccion1 = tcl.nextByte();
                    if (eleccion1 == 1) {
                        System.out.println("Introduciendo TV");
                        MAIN.introducirDatosTV(lista);
                    } else {
                        System.out.println("Introduciendo Libro");
                        MAIN.introducirDatosLibro(lista);
                    }

                    break;
                case 2:
                    System.out.println("Visualizando lista");
                    for (int i = 0; i < lista.size(); i++) {
                        System.out.println(lista.get(i));
                    }
                    break;
                case 3:
                    
                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("Usted ha salido del programa");
                    repetir = false;
                    break;

                default:
                    System.out.println("No has introducido ninguna de las opciones dadas");
            }
        } while (repetir);

    }

}
