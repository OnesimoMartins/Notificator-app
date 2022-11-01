package ao.martins.shoesclean.domain.model;

public enum StatusPedido {
CRIADO,CONCLUIDO;

    public static StatusPedido fromString( String str){
      if(str.equalsIgnoreCase("criado"))
          return CRIADO;
     if(str.equalsIgnoreCase("CONCLUIDO"))
            return CONCLUIDO;

//     if(str.equalsIgnoreCase("CANCELADO"))
//            return CANCELADO;

   throw new IllegalArgumentException(str+" é inválido para o Enum StatusPedido");
    }
}
