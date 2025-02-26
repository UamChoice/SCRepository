package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**   
* @Description： 后台接收各种参数
* @author： XL_FUTURE   
* @date： 2019年4月21日 
*/

//是@ResponseBody和@Controller的组合注解
@RestController   
@RequestMapping("/receiveParams")
@Api(tags="接收参数",description="废弃的")
public class AllParamsController {
	/**
	 * 1.定义成static final,logger变量不可变，读取速度快
	   2.static 修饰的变量是不管创建了new了多少个实例，也只创建一次，节省空间，如果每次都创建Logger的话比较浪费内存；final修饰表示不可更改，常量
	   3.将域定义为static,每个类中只有一个这样的域.而每一个对象对于所有的实例域却都有自己的一份拷贝.，用static修饰既节约空间，效率也好。final 是本 logger 不能再指向其他 Logger 对象
	 */
	private static final Logger logger = LoggerFactory.getLogger(AllParamsController.class);
	
	//相当于@RequestMapping(method = RequestMethod.GET/POST)
	@GetMapping("/ptPam")
	@ApiOperation(value="接收普通参数",notes="接收普通参数notes[notes]")
	@ApiImplicitParams({
		@ApiImplicitParam(name="myname",value="姓名",required=false,paramType="query",dataType="string"),
		@ApiImplicitParam(name="myage",value="年龄",required=false,paramType="query",dataType="int"),
	})
	public User ptPam(@RequestParam(name="myname",defaultValue="xl",required=false) String name,
			@RequestParam("myage") int age) {
		logger.info("姓名："+name+",年龄："+age);
		return new User(name, age);
	}
	
	/**
	 * 接收RETFUL风格的参数，注意要用@PathVariable，而不是@PathParam
	 * @param name
	 * @param age
	 * @return
	 */
	@GetMapping("/pathPam/{myname}/{myage}")
	@ApiOperation(value="接收RESTFUL风格参数",notes="接收RESTFUL风格参数[notes]")
	public User pathPam(@ApiParam(name="myname",value="姓名") @PathVariable("myname")String name,
			@ApiParam(name="myage",value="年龄",allowableValues="range[1,55]") @PathVariable("myage")Integer age) {
		logger.info("姓名："+name+",年龄："+age);
		return new User(name, age);
	}
	
	/**
	 * 使用@RequestBody接收application/json类型的数据，例如ajax请求，data为json的字符串
	 * @param user
	 * @return
	 */
	@PostMapping("/pojoPam")
	@ApiOperation(value="接收对象参数",notes="接收对象参数[notes],使用@RequestBody",consumes="application/json")
	public User pojoPam(@RequestBody User user) {
		logger.info(user.toString());
		return user;
	}
	
	/**
	 * 如果使用@RequestBody会报错Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported
	 * @param user,使用@ModelAttribute接收application/x-www-form-urlencoded类型，参数name和age就可以
	 * @return
	 */
	@PostMapping("/pojoPamM")
	@ApiOperation(value="接收对象参数",notes="接收对象参数[notes],使用@ModelAttribute")
	public User pojoPamM(@ModelAttribute User user) {
		logger.info(user.toString());
		return user;
	}

	/**
	 * 接收增强类设置的全局参数，XLControllerAdvice中设置
	 * @return
	 */
	@GetMapping("/advicePara")
	@ApiOperation(value="接收增强类设置的参数",notes="XLControllerAdvice中设置,也可以通过ModelMap modelMap.get('demo_author')获取")
	public String advicePara(@ModelAttribute("demo_author") String author) {
		logger.info(author);
		return author;
	}
	
	@GetMapping("/getHeadPara")
	@ApiOperation(value="接收Header中的参数",notes="接收Header中的参数[notes]")
	public String getHeadPara(@RequestHeader("Host") String myhost,@RequestHeader("User-Agent") String agent) {
		logger.info(myhost);
		logger.info(agent);
		return myhost+""+agent;
	}
	
	@PostMapping("/getCookiePara")
	@ApiOperation(value="接收Cookie中的参数",notes="接收Cookie中的参数[Cookie: name=XLING; JESSIONID=ADADSADASDSAXAQW1211S12SSA112]")
	public String getCookiePara(@CookieValue("JESSIONID") String jessionid,@CookieValue("name") String name) {
		logger.info(jessionid+","+name);
		return jessionid;
	}
}
