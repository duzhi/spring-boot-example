package com.daimabaike.biz.sys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daimabaike.biz.common.BizException;
import com.daimabaike.biz.common.Result;
import com.daimabaike.biz.common.web.BaseController;
import com.daimabaike.biz.sys.model.AccountResponse;
import com.daimabaike.biz.sys.model.UserRequest;
import com.daimabaike.biz.sys.service.AccountService;

@Controller
@RequestMapping("admin")
public class AccountController extends BaseController{
	
	private AccountService accountService;
	
	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
//	consumes： 指定处理请求的提交内容类型（Content-Type），例如application/json, text/html;
//	produces:    指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回；

	@RequestMapping(value="login")
	public String login() {
		
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
	public Result<UserRequest> aaa(UserRequest userDTO) {
//		userDTO.setSex(SexEnum.correct(userDTO.getSex()));
		
		Result<UserRequest> r = new Result<>();
		r.setData(userDTO);
		
//		System.out.println(userDTO.getSex().name());
//		System.out.println(userDTO.getSex().toString());
//		System.out.println(userDTO.getSex().getValue());
		
		return r;
	}
	
	@RequestMapping("bb")
	public UserRequest b(UserRequest userDTO) {
		if(11==userDTO.getId()) {
			throw new BizException();
		}
		return userDTO;
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
	
}
