package template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
public class HomeController {
	@RequestMapping(value={"/home", "/"})
	public ModelAndView home(){
			return new ModelAndView("home");
	}
}
