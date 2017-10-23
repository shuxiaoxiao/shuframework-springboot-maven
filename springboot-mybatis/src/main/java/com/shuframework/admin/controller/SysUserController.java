package com.shuframework.admin.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shuframework.admin.model.SysUser;
import com.shuframework.admin.service.SysUserService;

import ch.qos.logback.core.util.FileUtil;

@Controller
@RequestMapping("/sysUser")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/init")
	public String init() {
		
		return "admin/sysUser";
	}
	
	
	/**
	 * 分页列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public SysUser list(Long id) {
		SysUser user = sysUserService.selectById(id);
		
		return user;
	}
	
	
    /**
     * 保存
     * 返回的是text
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(SysUser sysUser){
//    	Map<String,Object> map = new HashMap<>();
//    	try {
//    		sysUserService.insert(sysUser);
//    		map.put("success", true);
//        	map.put("msg", "保存成功");
//		} catch (Exception e) {
//			map.put("success", false);
//			map.put("msg", "保存失败");
//		}
//    	return JsonUtil.obj2JsonStr(map);
    	try {
    		sysUserService.insert(sysUser);
    		return "success";
    	} catch (Exception e) {
    		e.printStackTrace();
    		return "error";
    	}
    }
    
    /**
     * 修改
     * 返回的是text
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(SysUser sysUser){
    	try {
    		sysUserService.updateSelective(sysUser);
    		return "success";
    	} catch (Exception e) {
    		e.printStackTrace();
    		return "error";
    	}
    }
    
    /**
     * 删除
     * 返回的是text
     */
    @RequestMapping(value = "/delete/{ids}", method = RequestMethod.GET)
    @ResponseBody
    public String delete(@PathVariable String ids){
    	try {
    		sysUserService.deleteById(ids);
    		return "success";
    	} catch (Exception e) {
    		e.printStackTrace();
    		return "error";
    	}
    }
 
}