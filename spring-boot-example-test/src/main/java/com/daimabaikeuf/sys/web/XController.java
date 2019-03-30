package com.daimabaikeuf.sys.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.daimabaikeuf.sys.service.XAsyncService;

@Controller
public class XController {

	@Autowired
	private XAsyncService xAsyncService;
	
//    @NacosValue(value="${v}", autoRefreshed = true)
//    private String v;
    @NacosValue(value="${abc:abc-default}", autoRefreshed = true)
    private String abc;
    
	@RequestMapping("mkd")
	public ResponseEntity<String> ads() {
		return ResponseEntity.ok("");
	}
	
	// 订单创建
	// 
	
	@RequestMapping("suc")
	public ResponseEntity<String> sss() {
		return ResponseEntity.ok("succ");
	}
	
	@GetMapping("/")
	@ResponseBody
	public String home(String a) {
		System.out.println("a=" + a);
		xAsyncService.sss();
		return "Hello World :" + abc;
	}

	@GetMapping("search/shows")
	@ResponseBody
	public List<Map<String, Object>> searchShows() {
		List<Map<String, Object>> list = new ArrayList<>();

		Map<String, Object> map = new HashMap<>();
		Map<String, Object> subMap = new HashMap<>();
		subMap.put("id", "1");
		subMap.put("name", "good book");
		map.put("show", subMap);
		list.add(map);

		map = new HashMap<>();
		subMap = new HashMap<>();
		subMap.put("id", "213");
		subMap.put("name", "Java");
		map.put("show", subMap);
		list.add(map);

		map = new HashMap<>();
		subMap = new HashMap<>();
		subMap.put("id", "8113");
		subMap.put("name", "JavaScript");
		map.put("show", subMap);
		list.add(map);

		map = new HashMap<>();
		subMap = new HashMap<>();
		subMap.put("id", "581");
		subMap.put("name", "Dubbo");
		map.put("show", subMap);
		list.add(map);

		return list;
	}

	@GetMapping("book")
	@ResponseBody
	public String book() {
		return "book some";
	}

	@GetMapping("book/{id}")
	@ResponseBody
	public Map<String, String> bookc(@PathVariable int id) {

		System.out.println("get book:" + new Date());

		Map<String, String> map = new HashMap<>();
		map.put("name", "good book" + id);
		map.put("summary", "summary:the book is it,very good, java, javascript, nodejs, react, etc." + id);
		map.put("image", "http://localhost:8080/pic.png");
		map.put("content", "the book is it,very good, java, javascript, nodejs, react, etc.");
		return map;
	}

	@PostMapping("book")
	@ResponseBody
	public String bookpost() {
		return "book create";
	}

	/**
	 * 用户编辑页面，所有字段都会提交，无论是否变化；锁定用户和版本号做乐观锁，不一致则放弃修改
	 * 
	 * @return
	 */
	@PutMapping("book/1")
	@ResponseBody
	public String bookput() {
		return "book put update";
	}

	/**
	 * 乐观锁
	 * 
	 * @return
	 */
	@PatchMapping("book")
	@ResponseBody
	public String bookpatch() {
		return "book Patch update";
	}

	/**
	 * 逻辑删除或物理删除
	 * 
	 * @return
	 */
	@DeleteMapping("book")
	@ResponseBody
	public String bookdel() {
		return "book del";
	}

	@RequestMapping("ping/first")
	public String first() {
		System.out.println("first");

		// 取 数据库 时间或取 redis 时间
		return "redirect:/ping/delay/" + System.nanoTime();
	}

	@RequestMapping("ping/delay/{firstTime}")
	@ResponseBody
	public Long delay(@PathVariable Long firstTime) {
		System.out.println("delay");
		return System.nanoTime() - firstTime;
	}

	@RequestMapping("aaaa")
	@ResponseBody
	public String aaaa() {
		//
		System.out.println(Locale.ENGLISH);
		ResourceBundle bundle = ResourceBundle.getBundle("my", new Locale("zh", "CN"));
		String cancel = bundle.getString("cancelKey");
		System.out.println(cancel);

		return cancel;
	}

	@RequestMapping("p")
	@ResponseBody
	public String p(@RequestParam(defaultValue = "null-p") String p) {
		return "[" + p + "]";
	}
}
