/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ivamar
 */
public class TV extends Electronico{
    private int tamano;

    public TV(int tamano, String fabricante, int precioNormal) {
        super(fabricante, precioNormal);
        this.tamano = tamano;
    }

    public int getTamano() {
        return tamano;
    }

    public float getPrecioNormal() {
        return precioNormal;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public void setPrecioNormal(int precioNormal) {
        this.precioNormal = precioNormal;
    }
    
    @Override
    public float CalculaPrecioVenta() {
        return (float) (this.precioNormal*1.08);
    }

    @Override
    public String toString() {
        return super.toString()+"TV{" + "tamano=" + tamano + '}';
    }
    
    
}
