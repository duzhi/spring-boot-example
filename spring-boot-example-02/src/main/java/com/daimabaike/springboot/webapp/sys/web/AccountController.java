package com.daimabaike.springboot.webapp.sys.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daimabaike.springboot.webapp.common.BizException;
import com.daimabaike.springboot.webapp.common.Result;
import com.daimabaike.springboot.webapp.common.web.BaseController;
import com.daimabaike.springboot.webapp.sys.dto.UserDTO;
import com.daimabaike.springboot.webapp.sys.service.AccountService;
import com.daimabaike.springboot.webapp.sys.vo.AccountVO;
import com.fasterxml.jackson.annotation.JsonView;
@RestController
public class AccountController extends BaseController{
	
	private AccountService accountService;
	
	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@RequestMapping("login")
	public String login() {
		
		// 1 验证密码
		
		
		// 2用户信息，权限信息初始化
		
		
		// redis 存储
		
		return String.format(" login at %s.", new Date());
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
	public Result<UserDTO> aaa(UserDTO userDTO) {
//		userDTO.setSex(SexEnum.correct(userDTO.getSex()));
		
		Result<UserDTO> r = new Result<>();
		r.setCode(0);
		r.setMessage("OK");
		r.setData(userDTO);
		
//		System.out.println(userDTO.getSex().name());
//		System.out.println(userDTO.getSex().toString());
//		System.out.println(userDTO.getSex().getValue());
		
		return r;
	}
	
	@RequestMapping("bb")
	public UserDTO b(UserDTO userDTO) {
		if(11==userDTO.getId()) {
			throw new BizException();
		}
		return userDTO;
	}
	
	@RequestMapping(value="bb2",produces=MediaType.TEXT_PLAIN_VALUE)//consumes=MediaType.TEXT_PLAIN_VALUE, ,
	public String b2(UserDTO userDTO) {
		
		
		return "1";
	}
	
	@RequestMapping("view")
	public AccountVO mm(@ModelAttribute UserDTO userDTO,@RequestAttribute int viewType) {
		
		userDTO.setViewType(viewType);
		return accountService.query(userDTO);

	}
	
	@RequestMapping("view2")
    @JsonView(AccountVO.ChannelView.class)
	public AccountVO mm1(@ModelAttribute UserDTO userDTO) {//,@RequestAttribute(required=false) String viewType
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
	public AccountVO xxxx(@ModelAttribute UserDTO userDTO) {
		return null;
	}
	
}
