var seckill = {
	//封装秒杀相关地址
	URL : {
            now:function(){
            	return '/seckill/time/now';
            },
            exposer:function(seckillId){
            	return '/seckill/'+seckillId+'/exposer';
            }
	},
	validatePhone:function(phone){
		if(phone&&phone.lenght==11&&!isNaN(phone)){
			return true;
			
		}else{
			return false;
		}
		
	},
	//处理秒杀逻辑
	handlerSeckill:function(seckillId,node){
		node.hide().html('<button class="btn btn-primary btn-lg" id="killBtn">开始秒杀</button>');
		$.post(seckill.URL.exposer(seckillId),{},function(result){
			//在回调函数中，执行交互流程
			if(result&&result['success']){
				var exposer=result['data'];
				if(exposer['exposed']){
					//开启秒杀
					
				}else{
					//未开启秒杀
				}
				
			}else{
				console.log('result='+result);//TODO
			}
			
		});
	},
	countdown:function(seckillId,nowTime,startTime,endTime){
		var seckillBox=$('#seckill-box');
		//时间的判断 
		if(nowTime>endTime){
			//秒杀结束
			seckillBox.html('秒杀结束');
		}else if(nowTime<startTime){
			//秒杀未开始,/计时事件绑定
			var killTime=new Date(startTime+1000);
			
			seckillBox.countdown(killTime,function(event){
				//时间格式
				var format=event.startTimt('秒杀倒计时：%D天 %H时 %M分 %S秒');
				seckillBox.html(format);
				//时间完成后回调事件
			}).on('finish.countdown',function(){
				//获取秒杀地址，控制显示逻辑，执行秒杀
				seckill.handlerSeckill(seckillId,seckillBox);
			});
		}else{
			seckill.handlerSeckill(seckillId,seckillBox);
		}
	},
	//详情页
	detail : {
		init:function(params){
			//用户手机验证和登录，计时交互
			//才cookie中查找手机号
			var killPhone=$.cookie('killPhone');
			
			//验证手机号
			
			if(!seckill.validatePhone(killPhone)){
				//绑定手机号
				//控制输出
				
				var killPhoneModal=$('#killPhoneModal');
				killPhoneModal.moal({
					
					show:true,//显示弹出层
					backdrop:'static',//禁止位置关闭
					keyboard:false//关闭键盘事件
				
				});
				
				$('#killPhoneBtn').click(function(){
					var inputPhone=$('#killPhoneKey').val();
					console.log('inputPhone='+inputPhone);//TODO
					if(seckill.validatePhone(killPhone)){
						//电话写入cookie
						$.cookie('killPhone',inputPhone,{expiress:7,path:'/seckill'});
						window.location.reload();
					}else{
						$('#killPhoneMessage').hide().html('<label class="label label-danger">手机号错误</label>').show(300);
					}
				});
			}
			//已经登录
			//计时交互
			$.get(seckill.URL.now(),{},function(result){
				if(result&&result['success']){
					var timeNow=result['data'];
					
					var startTime=params['startTime'];
					var endTime=params['endTime'];
					var seckillId=params['seckillId'];
					//时间判断
					
				}else{
					console.log('result='+result);//TODO
				}
			});
		}

	}
}