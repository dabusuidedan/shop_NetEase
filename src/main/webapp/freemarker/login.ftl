<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<script type="text/javascript" 

src="../js/jquery.min.js"></script>
<script type="text/javascript" 

src="../js/jquery.md5.js"></script>
<title>登录</title>
<link rel="stylesheet" href="../css/style.css"/>
</head><body>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div><div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
                    请<a href="login.ftl">[登录]</a>
        </div>
        <ul class="nav">
            <li><a href="../home/shouye.action">首页</a></li>
        </ul>
    </div>
</div><form class="m-form m-form-ht n-login" action="../user/login.action" method="post" id="loginForm"  >
    <div class="fmitem">
        <label class="fmlab">用户名：</label>
        <div class="fmipt">
            <input class="u-ipt"  id="username" name="userName" autofocus/>
        </div>
    </div>
    <div class="fmitem">
        <div class="fmipt">
            <input class="u-ipt" type="hidden" id="password" name="userPassword" autofocus/>
        </div>
    </div>
    <div class="fmitem">
        <label class="fmlab">密码：</label>
        <div class="fmipt">
            <input class="u-ipt" type="password" id="pwd" name="user_psw" onblur="mdjia()"/>
        </div>
    </div>
    <div class="fmitem fmitem-nolab fmitem-btn">
        <div class="fmipt">
            <button type="submit" class="u-btn u-btn-primary u-btn-lg u-btn-block">登 录</button>
        </div>
    </div>
</form>
<div class="n-foot">
     <p>版权所有：<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">com.netease.southeast</a></p>
</div>
<script type="text/javascript" src="../js/global.js"></script>
</body>
<script type="text/javascript">
function mdjia(){
    var password=$("#pwd").val();
    var pwd=$.md5(password);
    $("#password").val(pwd);
}
</script>
</html>