package br.com.rodrigoeduque;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ClassExplorer {

    public static void exploreMetadata(Object o) throws IllegalAccessException, InvocationTargetException {

        System.out.println("---- > Extracao Atributos < ----");
        for (Field f : o.getClass().getDeclaredFields()) {
            System.out.println(f.getName() + ": " + f.getType());
        }


        System.out.println("---- > Extracao Metodos < ----");
        for (Method m : o.getClass().getDeclaredMethods()) {
            System.out.println(m.getName());
        }

        System.out.println("---- > Extracao Metodos Comecados com a letra G");
        for (Method metodo : Arrays.stream(o.getClass().getDeclaredMethods()).filter(a -> a.getName().startsWith("g")).toList()) {
            System.out.println(metodo.getName());
        }

        System.out.println("---- > Extracao Valores Objetos");
        for (Field field : o.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            System.out.println("( " + field.getType() + " )" + field.getName() + ": " + field.get(o));
        }

        System.out.println("---- > Execucao Metodos Get");
        for (Method m : o.getClass().getDeclaredMethods()){
            if (m.getName().startsWith("get")){
                System.out.println("Nome do metodo -> " + m.getName() + "  :  Valor( " + m.getReturnType() + " ) " + m.invoke(o) );
            }
        }

    }
}
