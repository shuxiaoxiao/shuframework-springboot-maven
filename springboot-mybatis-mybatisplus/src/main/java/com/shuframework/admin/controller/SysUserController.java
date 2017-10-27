package com.shuframework.admin.controller;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.shuframework.admin.model.SysUser;
import com.shuframework.admin.service.SysUserService;
import com.shuframework.admin.vo.UserVo;
import com.shuframework.result.Result;
import com.shuframework.util.BeanUtil;
import com.shuframework.util.DigestUtil;
import com.shuframework.util.json.JsonUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <p>
 * 系统管理_用户 前端控制器
 * </p>
 * list 条件查询总结：
 * 	post 方法：推荐list3，list6
 * 	get 方法：推荐
 * 		
 * ApiOperation 的produces 属性设置了好像不起作用,理论上是swagger的显示时按照设定格式显示。
 * 
 * 	
 * @author shuheng
 * @since 2017-10-16
 */
@Controller
@RequestMapping("/sysUser")
@Api(description = "用户操作")
//@Api(value = "用户操作", description = "用户操作") //value没起作用，反而是description 起作用
public class SysUserController {
	
	@Autowired
	private SysUserService userService;
	
	@RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value = "新增用户", notes = "aabb", httpMethod = "POST")
    public Result add(UserVo userVo) {
//        List<User> list = userService.selectByLoginName(userVo);
//        if (list != null && !list.isEmpty()) {
//            return renderError("登录名已存在!");
//        }
//        String salt = StringUtils.getUUId();
//        String pwd = passwordHash.toHex(userVo.getPassword(), salt);
//        userVo.setSalt(salt);
//        userVo.setPassword(pwd);
//        userService.insertByVo(userVo);
//        return renderSuccess("添加成功");
		Result result = new Result();
		
		String loginName = "测试aa";
		String password = "test";
		String pwd = DigestUtil.md5(password);//加密后
		SysUser user = new SysUser();
		user.setCreatetime(new Date());
		user.setLoginName(loginName);
		user.setPwd(pwd);
		
		userService.insert(user);
		
		result.setSuccess(true);
		result.setCode(20000);
		result.setData(user);
		return result;
    }
	
	@RequestMapping("/add2")
	@ResponseBody
	@ApiOperation(value = "新增用户", notes = "aabb", httpMethod = "POST")
	public Result add2(UserVo userVo) {
//        List<User> list = userService.selectByLoginName(userVo);
//        if (list != null && !list.isEmpty()) {
//            return renderError("登录名已存在!");
//        }
//        String salt = StringUtils.getUUId();
//        String pwd = passwordHash.toHex(userVo.getPassword(), salt);
//        userVo.setSalt(salt);
//        userVo.setPassword(pwd);
//        userService.insertByVo(userVo);
//        return renderSuccess("添加成功");
		Result result = new Result();
		
		String loginName = "测试aa";
		String password = "test";
		String pwd = DigestUtil.md5(password);//加密后
		SysUser user = new SysUser();
		user.setCreatetime(new Date());
		user.setLoginName(loginName);
		user.setPwd(pwd);
		
		userService.insert(user);
		
		result.setSuccess(true);
		result.setCode(20000);
		result.setData(user);
		return result;
	}
	
	
	@GetMapping("/list")
    @ResponseBody
	@ApiOperation(value = "分页查询", notes = "aa", httpMethod = "GET")
//	@ApiOperation(value = "分页查询", notes = "aa", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
	//该种方式默认是paramType = "body"，application/json，一般不存在多个，不同paramType可以存在一个
	@ApiImplicitParams({
        @ApiImplicitParam(name = "pageIndex", value = "当前页数", required = true, paramType = "query", dataType = "integer"),
        @ApiImplicitParam(name = "pageSize", value = "条数", required = true, paramType = "query", dataType = "integer")
	})
	public Result list(Integer pageIndex, Integer pageSize) {
		Result result = new Result();
		
		//第一页默认为 1
		Page<SysUser> page = new Page<>(pageIndex, pageSize);
		System.out.println(userService);
		page = userService.selectPage(page);
		
		result.setSuccess(true);
		result.setCode(20000);
		result.setData(page);
		return result;
	}
	
	
	@PostMapping("/list2")
    @ResponseBody
	@ApiOperation(value = "分页查询", notes = "条件被分开，采用的是query方式", httpMethod = "POST")
//	@ApiOperation(value = "分页查询", notes = "条件被分开，采用的是query方式", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	public Result list2(SysUser user) {
		Integer pageIndex = 0;
		Integer pageSize = 10;
		
		Result result = new Result();
		//第一页默认为 1
		Page<SysUser> page = new Page<>(pageIndex, pageSize);
		page = userService.selectPage(page);
		
		result.setSuccess(true);
		result.setCode(20000);
		result.setData(page);
		return result;
	}
	
	
//	@RequestMapping(value="/list3")
	@PostMapping("/list3")
	@ResponseBody
	@ApiOperation(value = "分页查询（推荐）", notes = "条件是json，采用的是body方式", httpMethod = "POST")
//	@ApiOperation(value = "分页查询（推荐）", notes = "条件是json，采用的是body方式", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
//	@ApiOperation(value = "分页查询（推荐）", notes = "条件是json，采用的是body方式", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ApiImplicitParam(name = "user", value = "SysUser实体json格式", required = true)
//	public Result list3(@RequestBody SysUser user) {
	public Result list3(@ApiParam(name="user",value="json格式", required=true) @RequestBody SysUser user) {
		//@ApiParam 默认paramType = "body"
		Integer pageIndex = 0;
		Integer pageSize = 10;
		
		Result result = new Result();
		
		EntityWrapper<SysUser> condition = new EntityWrapper<>();
//		condition.setEntity(user);//会将赋值的参数添加到条件里，采用的是=
		condition.where("name={0}", user.getName());
//		condition.like("name", map.get("name").toString());
		List<SysUser> list = userService.selectList(condition);
		result.setData(list);
		
		//第一页默认为 1
//		Page<SysUser> page = new Page<>(pageIndex, pageSize);
//		page = userService.selectPage(page);
//		result.setData(page);
		
		result.setSuccess(true);
		result.setCode(20000);
		return result;
	}
	
	
	@PostMapping("/list5")
	@ResponseBody
	@ApiOperation(value = "分页查询", notes = "不在model的条件则被排出了", httpMethod = "POST")
//	@ApiOperation(value = "分页查询", notes = "不在model的条件则被排出了", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	//该种方式默认是paramType = "body"，application/json，一般不存在多个，不同paramType可以存在一个
	@ApiImplicitParams({
		@ApiImplicitParam(name = "pageIndex", value = "当前页数", required = true, paramType = "query", dataType = "integer"),
		@ApiImplicitParam(name = "pageSize", value = "条数", required = true, paramType = "query", dataType = "integer"),
		@ApiImplicitParam(name = "user", value = "json格式", required = true, paramType = "body", dataType = "SysUser")
	})
	public Result list5(Integer pageIndex, Integer pageSize, @RequestBody SysUser user) {
		Result result = new Result();
		
		//第一页默认为 1
		Page<SysUser> page = new Page<>(pageIndex, pageSize);
		page.setCondition(BeanUtil.beanToMap(user));
		page = userService.selectUserPage(page);
		
		result.setSuccess(true);
		result.setCode(20000);
		result.setData(page);
		return result;
	}
	
	
	@PostMapping("/list6")
	@ResponseBody
	@ApiOperation(value = "分页查询（推荐）", notes = "不在model的条件，统一有jsonStr形式拿到", httpMethod = "POST", response = SysUser.class)
//	@ApiOperation(value = "分页查询（推荐）", notes = "不在model的条件，统一有jsonStr形式拿到", httpMethod = "POST", 
//	response = SysUser.class, produces = MediaType.APPLICATION_JSON_VALUE)
	//该种方式默认是paramType = "body"，application/json，一般不存在多个，不同paramType可以存在一个
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userStr", value = "json格式", required = true, paramType = "body", dataType = "string")
	})
	@SuppressWarnings("unchecked")
	public Result list6(@RequestBody String userStr) {
//		paramType = "body" 采用@RequestBody 接收
//		请求地址 http://localhost:8080/sysUser/list6	参数{"pageIndex":1, "pageSize":10, "name":"aa"}
		Map<String, Object> map = JsonUtil.jsonStr2Map(userStr);
		Integer pageIndex = (Integer) map.get("pageIndex");
		Integer pageSize = (Integer) map.get("pageSize");
		Result result = new Result();
		
		//第一页默认为 1
		Page<SysUser> page = new Page<>(pageIndex, pageSize);
		page.setCondition(map);
		page = userService.selectUserPage(page);
		
		result.setSuccess(true);
		result.setCode(20000);
		result.setData(page);
		return result;
	}
	
	
	@GetMapping("/list7")
	@ResponseBody
	@ApiOperation(value = "分页查询（不推荐，应该换成post请求）", notes = "不在model的条件，统一有jsonStr形式拿到", httpMethod = "GET")
//	@ApiOperation(value = "分页查询（推荐）", notes = "不在model的条件，统一有jsonStr形式拿到", httpMethod = "GET", 
//	response = SysUser.class, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//	如果想写，则是一个个字段列出，不写默认显示出所有字段
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userStr", value = "json格式", required = true, paramType = "query", dataType = "string")
	})
	@SuppressWarnings("unchecked")
	public Result list7(@RequestParam String userStr) {
//		Map<String, Object> map = BeanUtil.getParameterMap(request);
//		try {
//			userStr = URLDecoder.decode(userStr, "utf-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		Map<String, Object> map = JsonUtil.jsonStr2Map(userStr);
		Integer pageIndex = (Integer) map.get("pageIndex");
		Integer pageSize = (Integer) map.get("pageSize");
		Result result = new Result();
		
		//第一页默认为 1
		Page<SysUser> page = new Page<>(pageIndex, pageSize);
		EntityWrapper<SysUser> condition = new EntityWrapper<>();
//		condition.setEntity(new User(1));
		condition.where("name={0}", map.get("name").toString());
//		condition.like("name", map.get("name").toString());
//		page.setCondition(condition);
		page = userService.selectPage(page, condition);
		
		result.setSuccess(true);
		result.setCode(20000);
		result.setData(page);
		return result;
	}
	
	
	@PostMapping("/list8")
	@ResponseBody
	@ApiOperation(value = "分页查询（推荐）", notes = "不在model的条件，统一有jsonStr形式拿到", httpMethod = "POST")
//	@ApiOperation(value = "分页查询（推荐）", notes = "不在model的条件，统一有jsonStr形式拿到", httpMethod = "POST", 
//	response = SysUser.class, produces = MediaType.APPLICATION_JSON_VALUE)
	//该种方式默认是paramType = "body"，application/json，一般不存在多个，不同paramType可以存在一个
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userStr", value = "json格式", required = true, paramType = "query", dataType = "string")
	})
	@SuppressWarnings("unchecked")
	public Result list8(@RequestParam String userStr) {
//		paramType = "query" 采用@RequestParam接收，
//		请求地址 http://localhost:8080/sysUser/list8?userStr={"pageIndex":1, "pageSize":10, "name":"aa"}
		Map<String, Object> map = JsonUtil.jsonStr2Map(userStr);
		Integer pageIndex = (Integer) map.get("pageIndex");
		Integer pageSize = (Integer) map.get("pageSize");
		Result result = new Result();
		
		//第一页默认为 1
		Page<SysUser> page = new Page<>(pageIndex, pageSize);
		page = userService.selectPage(page);
		
		result.setSuccess(true);
		result.setCode(20000);
		result.setData(page);
		return result;
	}
}
