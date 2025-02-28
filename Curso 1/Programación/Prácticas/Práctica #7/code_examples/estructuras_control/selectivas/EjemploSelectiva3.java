package estructuras_control.selectivas;

import java.util.Scanner;

/**
 * Este ejemplo muestra un uso básico la sentencia if
 * para determinar si un entero entrado por el usuario
 * es mayor, menor o igual que 0
 * @author Hugo Pelayo
 * @Fecha 23 de abril de 2023
 * */
public class EjemploSelectiva3 {
    private static final Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Introduce un entero: ");
        int entero = lector.nextInt();

        if (entero > 0)
            System.out.println("El entero es un valor positivo");
        else if (entero < 0)
            System.out.println("El entero es un valor negativo");
        else
            System.out.println("El entero es un valor nulo");

        lector.close();
    }
}
