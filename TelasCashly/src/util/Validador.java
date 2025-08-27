package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.*;

public class Validador {
	
	
	public static boolean isValidEmail(String email) {
        // Definir o padrão de expressão regular para validar o email
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        
        // Criar o padrão com a expressão regular
        Pattern pattern = Pattern.compile(emailRegex);
        
        // Verificar se o email corresponde ao padrão
        Matcher matcher = pattern.matcher(email);
        
        return matcher.matches();
    }

}
