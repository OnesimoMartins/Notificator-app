package ao.martins.shoesclean.core.validation;

import java.util.List;
import java.util.stream.Stream;

public class ValidationUtils {

    private  static List numbers=  List.of('1','2','3','4','5','6','7','8','9','0');

    public static Boolean isNumeroTelefone(String value){
        return value!=null && value.length()==9 && (
                value.startsWith("91")||
                value.startsWith("92")||
                value.startsWith("93")||
                value.startsWith("94")||
                value.startsWith("95"))
                &&
                Stream.of(value.toCharArray())
                        .anyMatch(it->!numbers.contains(it));
   }

   public static Boolean isNome(String value){
        return  Stream.of(value.toCharArray())
                        .noneMatch( numbers::contains);
    }
}
