package com.hc.web;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hc.dto.Exposer;
import com.hc.dto.SeckillExecution;
import com.hc.dto.SeckillResult;
import com.hc.entity.Seckill;
import com.hc.enums.SeckillStateEnum;
import com.hc.exception.RepeatKillException;
import com.hc.exception.SeckillCloseException;
import com.hc.service.SeckillService;
import com.hc.utils.Log;




/**
 * @Title: SeckillController.java 
 * @Package com.hc.web 
 * @Description: TODO
 * @author Shuyu.Wang
 * @date Creation time: 2017��9��6��
 * @version V1.0   
 */
@Controller
@RequestMapping("/seckill")//url:/ģ��/��Դ/{id}/ϸ��/seckill/list
public class SeckillController {
	@Autowired
	private SeckillService seckillService;
	
	/** 
	* @Title: list 
	* @Description: ��ȡ��ɱ�б�
	* @param model
	* @return String
	*/
	@RequestMapping(name="list",method=RequestMethod.GET)
	public String list(Model model){
		
		List<Seckill> seckillList = seckillService.getSeckillList();
		model.addAttribute("list",seckillList);
		//��ȡ�б�ҳ
		return "list";
		
	}
	
	/** 
	* @Title: detail 
	* @Description: ��ȡ��ɱ����
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
	* @Description: ��ȡ��ɱ��ַ 
	* @param seckillId
	* @return SeckillResult<Exposer>
	*/
	@RequestMapping(value="/{seckillId}/exposer",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public SeckillResult<Exposer> exposer(@PathVariable("seckillId")Long seckillId){
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
	/** 
	* @Title: execute 
	* @Description: ִ����ɱ����
	* @param seckillId
	* @param md5
	* @param phone
	* @return SeckillResult<SeckillExecution>
	*/
	@RequestMapping(value="/{seckillId}/{md5}/execution",method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public SeckillResult<SeckillExecution> execute(@PathVariable("seckillId")Long seckillId,@PathVariable("md5")String md5,@CookieValue(value="phone",required=false)Long phone){
		SeckillResult<SeckillExecution> result;
		if (phone==null) {
			result=new SeckillResult<SeckillExecution>(false, "δע��");
		}
		
		try {
			SeckillExecution executeSeckill = seckillService.executeSeckill(seckillId, phone, md5);
			
			result= new SeckillResult<SeckillExecution>(true,executeSeckill);
		}catch (RepeatKillException e) {
			SeckillExecution seckillExecution = new SeckillExecution(seckillId, SeckillStateEnum.REPEAT_KILL);
			result=new SeckillResult<SeckillExecution>(true, seckillExecution);
		} catch (SeckillCloseException e) {
			SeckillExecution seckillExecution = new SeckillExecution(seckillId, SeckillStateEnum.END);
			result=new SeckillResult<SeckillExecution>(true, seckillExecution);
		}catch (Exception e) {
			Log.e(e);
			SeckillExecution seckillExecution = new SeckillExecution(seckillId, SeckillStateEnum.INNER_EROR);
			result=new SeckillResult<SeckillExecution>(true, seckillExecution);
		}
		return result;
	}
	/** 
	* @Title: time 
	* @Description: ��ȡ��������ǰʱ��
	* @return SeckillResult<Long>
	*/
	@RequestMapping(value="/time/now",method=RequestMethod.GET)
	@ResponseBody
	public SeckillResult<Long> time(){
		Date date=new Date();
		return new SeckillResult<Long>(true,date.getTime());
	}

}
