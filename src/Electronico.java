/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author ivamar
 */
public abstract class Electronico extends Producto {
    private String fabricante;

    public Electronico(String fabricante, int precioNormal) {
        super(precioNormal);
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return super.toString()+"Electronico{" + "fabricante=" + fabricante + '}';
    }

    public String getFabricante() {
        return fabricante;
    }

    public float getPrecioNormal() {
        return precioNormal;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setPrecioNormal(int precioNormal) {
        this.precioNormal = precioNormal;
    }

   
   
    
}
