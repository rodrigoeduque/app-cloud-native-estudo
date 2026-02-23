package br.com.rodrigoeduque;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Set;

public class ImplementaFormataValorTelefone extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(FormataValorTelefone.class)){
       
                try {
                    Class<?> clazz = Class.forName(element.getEnclosingElement().toString());
                    Field field = clazz.getDeclaredField(element.getSimpleName().toString());
                    field.setAccessible(true);
                    String valorTelefone = (String) field.get(null);
                    String valorFormatado = formataValorTelefone(valorTelefone);
                    field.set(null, valorFormatado);
                } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
            
            }
        }
        return true;
    }
    
    public String formataValorTelefone(String valorTelefone) {
        String valorLimpo = valorTelefone.replaceAll("\\D", "");
        if (valorLimpo.length() == 11) {
            return String.format("(%s) %s-%s",
                    valorLimpo.substring(0, 2),
                    valorLimpo.substring(2, 7),
                    valorLimpo.substring(7));
        } else if (valorLimpo.length() == 10) {
            return String.format("(%s) %s-%s",
                    valorLimpo.substring(0, 2),
                    valorLimpo.substring(2, 6),
                    valorLimpo.substring(6));
        } else {
            return valorTelefone; // Retorna o valor original se não for um número de telefone válido
        }
    }
}
