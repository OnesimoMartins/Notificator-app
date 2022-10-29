package ao.martins.shoesclean.api.mapper;

import ao.martins.shoesclean.api.dto.input.FuncionarioInput;
import ao.martins.shoesclean.api.dto.response.FuncionarioResponse;
import ao.martins.shoesclean.domain.model.Cargo;
import ao.martins.shoesclean.domain.model.Funcionario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FuncionarioMapper {

    private final CargoMapper cargoMapper;

    public Funcionario toFuncionario(FuncionarioInput funcionarioInput){

        Funcionario funcionario= new Funcionario();
        funcionario.setNome(funcionarioInput.getNome());
        funcionario.setSobrenome(funcionarioInput.getSobrenome());
        funcionario.setTelefone(funcionarioInput.getTelefone());
        funcionario.setCargo(new Cargo(funcionarioInput.getCargoId()));
        funcionario.setPassword(funcionarioInput.getPassword());
        return  funcionario;

    }

    public FuncionarioResponse toFuncionarioresponse(Funcionario f){
      return   FuncionarioResponse.builder()
                .nome(f.getNome())
                .sobrenome(f.getSobrenome())
              .cargo(this.cargoMapper.toCargoResponse(f.getCargo()))
                .id(f.getId()).telefone(f.getTelefone())
              .build();
    }

    public Funcionario copiarPropriedades(Funcionario origem, Funcionario destino) {

        if(origem.getId()!=null)
            destino.setId(origem.getId());

        if (origem.getNome()!=null)
            destino.setNome(origem.getNome());

        if(origem.getSobrenome()!=null)
            destino.setSobrenome(origem.getSobrenome());

        if(origem.getTelefone()!=null)
            destino.setTelefone(origem.getTelefone());

        if(origem.getPassword()!=null)
            destino.setPassword(origem.getPassword());

        return destino;
    }
}
