package mil.candes.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mil.candes.core.configuration.Routes;
import mil.candes.core.service.LoginService;

@Controller
@RequestMapping(Routes.api)

public class LoginController {

	@Autowired
	@Qualifier("loginService")
	LoginService loginService;
	
	@GetMapping(Routes.login)
	public ModelAndView getLoginInterface() {
		return new ModelAndView("login");
	}
}
