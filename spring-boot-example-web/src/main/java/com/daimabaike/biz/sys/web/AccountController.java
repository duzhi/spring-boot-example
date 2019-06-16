package com.daimabaike.biz.sys.web;

import com.alibaba.fastjson.JSONObject;
import com.daimabaike.biz.common.interceptor.ResultRewrite;
import com.daimabaike.biz.sys.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.daimabaike.biz.common.BizException;
import com.daimabaike.biz.common.web.BaseController;
import com.daimabaike.biz.sys.model.AccountResponse;
import com.daimabaike.biz.sys.model.UserRequest;
import com.daimabaike.biz.sys.service.AccountService;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import java.util.Set;

@RestController
@RequestMapping({"admin","a"})
public class AccountController extends BaseController<User>{

	Logger logger = LoggerFactory.getLogger(AccountController.class);

	private AccountService accountService;
	
	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService =    accountService;
	}
	
//	consumes: 指定处理请求的提交内容类型（Content-Type），例如application/json, text/html;
//	produces: 指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回；

	@RequestMapping(value="login")
	public String login() {
		HandlerInterceptorAdapter a;
		return "login";
//				ResultUtils.ok(String.format(" login at %s.", new Date()));
	}
	
//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
////        binder.registerCustomEditor(Date.class, new MyDateEditor());
////        binder.registerCustomEditor(Double.class, new DoubleEditor()); 
////        binder.registerCustomEditor(Integer.class, new IntegerEditor());
//    	
//    	
//    }

	@RequestMapping("aaa")
//	@ResultRewrite
	public String aaa(@RequestBody String body) {
//		userDTO.setSex(SexEnum.correct(userDTO.getSex()));
		
		//Result<UserRequest> r = new Result<>();
		//r.setData(userDTO);
		
//		System.out.println(userDTO.getSex().name());
//		System.out.println(userDTO.getSex().toString());
//		System.out.println(userDTO.getSex().getValue());
	//	userDTO.setName("name is "+userDTO.getName());




		return "str==="+body ;
	}
	
	@RequestMapping("bb")
	public UserRequest b(@RequestBody String body) {

		UserRequest userDTO = checkSign(body);

		userDTO.setName("name xxxx="+userDTO.getName());
		return userDTO;
	}

	private UserRequest checkSign(String body) {
		JSONObject json = JSONObject.parseObject(body);
		Set<String> set = json.keySet();
		for(String ss:set){
			System.out.println(ss);
		}
		if(!"9527".equalsIgnoreCase(json.getString("sign"))){
			throw new BizException(400112,"dadadada");
		}

		return
				JSONObject.parseObject(body,UserRequest.class);
	}


	@RequestMapping(value="bb2",produces=MediaType.TEXT_PLAIN_VALUE)//consumes=MediaType.TEXT_PLAIN_VALUE, ,
	public String b2(UserRequest userDTO) {
		
		
		return "1";
	}
	
	@RequestMapping("view")
	public AccountResponse mm(@ModelAttribute UserRequest userDTO,@RequestAttribute int viewType) {
		
		userDTO.setViewType(viewType);
		return accountService.query(userDTO);

	}
	
	@RequestMapping("view2")
	public AccountResponse mm1(@ModelAttribute UserRequest userDTO) {//,@RequestAttribute(required=false) String viewType
//		int type = 0;
//		try {
//			type = Integer.parseInt(viewType);
//		} catch (Exception e) {
//		}
//		userDTO.setViewType(type);
		return accountService.query(userDTO);

	}
	
//	@RequestMapping("view")
//	public String b() {
//		
//		return "redirect:";
//	}
//	
//	@RequestMapping("view")
//	public String b() {
//		
//		return "redirect:";
//	}
	
	
	@RequestMapping("view22")
	public AccountResponse xxxx(@ModelAttribute UserRequest userDTO) {
		return null;
	}

	@RequestMapping({"user","u"})
	@ResultRewrite
	public User user(User user) {
		logger.info("user.ip={}" , user.get_ip());
		logger.info("user.name={}" , user.getName());

		user.setName("name: "+user.getName());
		user.setDeptNo("deptNo: "+user.getDeptNo());

		return user;
	}

}
