var seckill = {
	//封装秒杀相关地址
	URL : {

	},
	validatePhone:function(phone){
		if(phone&&phone.lenght==11&&!isNaN(phone)){
			return true;
			
		}else{
			return false;
		}
		
	},
	//详情页
	detail : {
		init:function(params){
			//用户手机验证和登录，计时交互
			//才cookie中查找手机号
			var killPhone=$.cookie('killPhone');
			var startTime=params['startTime'];
			var endTime=params['endTime'];
			var seckillId=params['seckillId'];
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
		}

	}
}