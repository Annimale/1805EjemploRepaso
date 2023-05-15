
import java.util.Comparator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ivamar
 */
public class EditorComparator implements Comparator{
@Override
    public int compare(Object t, Object t1) {
        Libro a1 = (Libro) t;
        Libro a2 = (Libro) t1;
        return a1.getEditor().compareTo(a2.getEditor());
    }

    public boolean equals(Object o) {
        return this == o;
    }
    
}
