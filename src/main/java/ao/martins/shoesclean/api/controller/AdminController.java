package ao.martins.shoesclean.api.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("admin")
public class AdminController {

	@PutMapping("desactivar-notificacoes-adiamento")
	void desactivarNotificacoesAdiamento() {
		
	}
}
