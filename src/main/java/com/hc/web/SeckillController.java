package com.hc.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hc.dto.Exposer;
import com.hc.dto.SeckillResult;
import com.hc.entity.Seckill;
import com.hc.service.SeckillService;
import com.hc.utils.Log;

import javafx.scene.transform.Scale;
import sun.util.logging.resources.logging;



/**
 * @Title: SeckillController.java 
 * @Package com.hc.web 
 * @Description: TODO
 * @author Shuyu.Wang
 * @date Creation time: 2017年9月6日
 * @version V1.0   
 */
@Controller
@RequestMapping("/seckill")//url:/模块/资源/{id}/细分/seckill/list
public class SeckillController {
	@Autowired
	private SeckillService seckillService;
	
	/** 
	* @Title: list 
	* @Description: 获取秒杀列表
	* @param model
	* @return String
	*/
	@RequestMapping(name="list",method=RequestMethod.GET)
	public String list(Model model){
		
		List<Seckill> seckillList = seckillService.getSeckillList();
		model.addAttribute("list",seckillList);
		//获取列表页
		return "list";
		
	}
	
	/** 
	* @Title: detail 
	* @Description: 获取秒杀详情
	* @param seckillId
	* @param model
	* @return String
	*/
	@RequestMapping(value="/{seckillId}/detail",method=RequestMethod.GET)
	public String detail(@PathVariable("seckillId")Long seckillId,Model model){
		if (seckillId==null) {
			return "redirect:/seckill/list";
		}
		Seckill byId = seckillService.getById(seckillId);
		if (byId==null) {
			return "forward:/seckill/list";
		}
		model.addAttribute("seckill",byId);
		
		return "detail";
	}
	/** 
	* @Title: exposer 
	* @Description: 获取秒杀地址 
	* @param seckillId
	* @return SeckillResult<Exposer>
	*/
	@RequestMapping(value="/{seckillId}/exposer",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public SeckillResult<Exposer> exposer(Long seckillId){
		SeckillResult<Exposer> result;
		try {
			Exposer exportSeckillUrl = seckillService.exportSeckillUrl(seckillId);
			result=new SeckillResult<Exposer>(true, exportSeckillUrl);
		} catch (Exception e) {
			Log.e(e);
			result=new SeckillResult<>(false, e.getMessage());
		}
		return result;
		
	}

}
