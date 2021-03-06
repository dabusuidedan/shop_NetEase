(function(w,d,u){
	var loginForm = util.get('loginForm');
	if(!loginForm){
		return;
	}
	var userName = loginForm['userName'];
	var userPassword = loginForm['userPassword'];
	var isSubmiting = false;
	var loading = new Loading();
	var page = {
		init:function(){
			loginForm.addEventListener('submit',function(e){
				if(!isSubmiting && this.check()){
					var value1 = userName.value;
					var value2 = md5(userPassword.value);
					isSubmiting = true;
					loading.show();
					ajax({
						data:{userName:value1,userPassword:value2},
						url:'../user/login.action',
						success:function(result){
						loading.hide();
							location.href = url;
						},
						error:function(message){
							loading.result(message||'登录失败');
							isSubmiting = false;
						}
					});
				}
			}.bind(this),false);
			[userName,userPassword].forEach(function(item){
				item.addEventListener('input',function(e){
					item.classList.remove('z-err');
				}.bind(this),false);
			}.bind(this));
		},
		check:function(){
			var result = true;
			[
				[userName,function(value){return value == ''}],
				[userPassword,function(value){return value == ''}]
			].forEach(function(item){
				var value = item[0].value.trim();
				if(item[1](value)){
					item[0].classList.add('z-err');
					result = false;
				}
				item[0].value = value;
			});
			return result;
		}
	};
	page.init();
})(window,document);