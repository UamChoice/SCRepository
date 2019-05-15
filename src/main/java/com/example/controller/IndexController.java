package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**   
* @Description： TODO
* @author： XL_FUTURE   
* @date： 2019年5月11日 上午4:21:15 
*/

@Controller
public class IndexController {
	
	@RequestMapping("/welcome")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	@RequestMapping("/welcome1")
    public String userList2(Model model) throws Exception {
        model.addAttribute("hellomsg","Hello, Spring Boot!");
        return "index";
    }
}
