package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ValidadorCedula {

    public static List<String> numerosCalculados = new ArrayList<>();
    public static List<Integer> coeficientes = new ArrayList<>();
    public static List<String> cedulaDestructurada = new ArrayList<>();

    public static void valida(String  cedula){
        llenaCoeficintes();
        boolean cedul = validaLongitud(cedula);

        if(cedul){
            int provincia = Integer.parseInt(cedula.substring(0,2));

            boolean validaProvincia = validaProvincia(provincia);

            if(validaProvincia){
                int tercerDigito = Integer.parseInt(cedula.substring(2,3));
                boolean validaTercerDigito = validaTercerDigito(tercerDigito);
                if(validaTercerDigito){

                    for(int a = 0; a< cedula.length(); a++){
                        char caracter = cedula.charAt(a);

                        if( a != 9){
                            cedulaDestructurada.add(String.valueOf(caracter));
                        }
                    }

                    for(Integer a : coeficientes){
                        for(String b : cedulaDestructurada){

                            int calculo = a * Integer.parseInt(b);
                            int resultado = 0;
                            if(calculo >= 10){
                                resultado = calculo - 9;
                            }else{
                                resultado = calculo;
                            }
                            numerosCalculados.add(String.valueOf(resultado));
                            cedulaDestructurada.remove(b);
                            break;

                        }
                    }

                    int suma = 0;
                    for(String resultados : numerosCalculados){
                        suma = suma + Integer.parseInt(resultados);
                    }
                    
                    int decenaSuperior = ((suma / 10) + 1) * 10;
                    int resta = decenaSuperior - suma;
                    String ultimoDigito = cedula.substring(9,10);

                    if(ultimoDigito.equalsIgnoreCase(String.valueOf(resta)) || ultimoDigito.equalsIgnoreCase("0")){
                        JOptionPane.showMessageDialog(null, "La Cedula es Correcta", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "La Cedula es Incorrecta", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                    }

                }else{
                    JOptionPane.showMessageDialog(null, "El tecer digito no puede ser mayor a 6", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }

            }else{
                JOptionPane.showMessageDialog(null, "Dos primeros digitos de la Cedula no debe ser mayor a 24 ni menor a 0", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }

        }else{
            JOptionPane.showMessageDialog(null, "Cedula no debe ser mayor ni menor a 10 digitos", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static boolean validaLongitud(String cedula){
        return cedula.length() == 10;
    }

    public static boolean validaProvincia(int provincia){
        return (provincia > 0 && provincia < 24);
    }

    public static boolean validaTercerDigito(int tercerDigito){
        return (tercerDigito < 6);
    }

    public static void llenaCoeficintes(){
        coeficientes.add(2);
        coeficientes.add(1);
        coeficientes.add(2);
        coeficientes.add(1);
        coeficientes.add(2);
        coeficientes.add(1);
        coeficientes.add(2);
        coeficientes.add(1);
        coeficientes.add(2);
    }

}
