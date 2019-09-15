package mil.candes.core.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;



import mil.candes.core.configuration.Routes;

@Controller
@RequestMapping(Routes.root)
public class ClientRestController {
	
	private static final Log logger = LogFactory.getLog(ClientRestController.class);

	@GetMapping(Routes.cargarmm)
	public ModelAndView cargarMM() {
		
		ModelAndView mav = new ModelAndView("ccig/mm/index");
		
		RestTemplate restTemplate = new RestTemplate();
		logger.info("Creo RestTemplate");
		
//		HttpHeaders httpHeaders = new HttpHeaders();
//		HttpEntity httpEntity = new HttpEntity(httpHeaders);
		
		logger.info("1 - "+Routes.host+Routes.api+Routes.datosFormularioCargaMM);
		
//		ResponseEntity<MensajeMilitarEntity[]> mensajeMilitarEntity = restTemplate.exchange(Pages.host+Pages.api+Pages.datosFormularioCargaMM,HttpMethod.GET,httpEntity,MensajeMilitarEntity[].class);
		
		logger.info("2");
		
//		MensajeMilitarEntity[] mensajes = mensajeMilitarEntity.getBody();
//		mav.addObject(mensajes);
		
		return mav;
	}
}
