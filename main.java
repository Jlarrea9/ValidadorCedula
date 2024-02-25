package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    /*La cédula ecuatoriana está formada por los dos primeros dígitos que corresponden
    a la provincia donde fue expedida, por lo cual,
    los dos primeros dígitos no serán mayores a 24 ni menores a 0*/

    /*El tercer dígito es un número menor a 6 (0,1,2,3,4,5).*/

    /*Los siguientes hasta el noveno dígito son un número consecutivo*/

    /*El décimo es el dígito verificador*/

    /*Coeficientes = 2.1.2.1.2.1.2.1.2*/

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca su numero de cedula: ");

        String cedula = scanner.nextLine();
        if(cedula.equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "La Cedula es Obligatoria", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }else{
            ValidadorCedula.valida(cedula);
        }

    }

}
