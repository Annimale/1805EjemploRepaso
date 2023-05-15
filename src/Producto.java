
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ivamar
 */
public abstract class Producto implements Serializable{
    protected float precioNormal;

    public Producto(int precioNormal) {
        this.precioNormal = precioNormal;
    }

    public float getPrecioNormal() {
        return precioNormal;
    }

    @Override
    public String toString() {
        return "Producto{" + "precioNormal=" + precioNormal + '}';
    }

    public void setPrecioNormal(int precioNormal) {
        this.precioNormal = precioNormal;
    }
    
    public abstract float CalculaPrecioVenta();
        
    
}
