package com.example.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.dto.User;

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
	
	@RequestMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("userName", "LHY");
        map.addAttribute("flag", "yes");
        map.addAttribute("users", getUserList());
        map.addAttribute("type", "link");
        map.addAttribute("pageId", "springcloud/2017/09/11");
        map.addAttribute("img", "images/star.png");
        map.addAttribute("count", 12);
        map.addAttribute("date", new Date());
        return "th/index";
    }
 
 
    private List<User> getUserList(){
        List<User> list=new ArrayList<User>();
        User user1=new User("zhangsan",12);
        User user2=new User("lisi",6);
        User user3=new User("wangwu",66);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return  list;
    }
}
