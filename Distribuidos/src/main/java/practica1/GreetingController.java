package practica1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {
	@RequestMapping	("/Inicio")
	public String greeting(Model model) {
	model.addAttribute("name", "World");
	return "index";
	}
}
