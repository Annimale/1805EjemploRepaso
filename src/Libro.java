/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ivamar
 */
public class Libro extends Producto implements Comparable {

    private String editor;
    private int anoPublicacion;

    public Libro(String editor, int anoPublicacion, int precioNormal) {
        super(precioNormal);
        this.editor = editor;
        this.anoPublicacion = anoPublicacion;
    }

    public String getEditor() {
        return editor;
    }

    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    public float getPrecioNormal() {
        return precioNormal;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public void setAnoPublicacion(int anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    @Override
    public String toString() {
        return super.toString() + "Libro{" + "editor=" + editor + ", anoPublicacion=" + anoPublicacion + '}';
    }

    public void setPrecioNormal(float precioNormal) {
        this.precioNormal = precioNormal;
    }

    public float CalculaPrecioVenta() {
        return (float) (this.precioNormal * 1.05);
    }

   

    public int compareTo(Libro t) {
       return Integer.compare(this.anoPublicacion, t.getAnoPublicacion());
    }

    @Override
    public int compareTo(Object t) {
        Libro llibre=(Libro) t;
        return this.anoPublicacion-llibre.getAnoPublicacion();
    }
    
    

    

}
