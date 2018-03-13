<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>购物车</title>
<link rel="stylesheet" href="../css/style.css"/>
</head><body>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div><div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
                    买家你好，<span class="name">${user.userName}</span>！<a href="../user/logout.action">[退出]</a>
        </div>
        <ul class="nav">
            <li><a href="../home/shouye.action">首页</a></li>
            <li><a href="../home/account.action">账务</a></li>
            <li><a href="../home/settleAccount.action">购物车</a></li>
        </ul>
    </div>
</div><div class="g-doc" id="settleAccount">
    <div class="m-tab m-tab-fw m-tab-simple f-cb" >
        <h2>已添加到购物车的内容</h2>
    </div>
 	<table id="newTable" class="m-table m-table-row n-table g-b3">
 	</table>
 	<div id="act-btn"><button class="u-btn u-btn-primary" id="back">退出</button>
 	<button class="u-btn u-btn-primary" id="Account">购买</button></div>
</div>
<div class="n-foot">
    <p>版权所有：<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">com.netease.southeast</a></p>
</div><script type="text/javascript" src="../js/global.js"></script>
<script type="text/javascript" src="../js/settleAccount.js"></script>
</body>
</html>