<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>发布成功</title>
<link rel="stylesheet" href="../css/style.css"/>
</head><body>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div><div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
                    卖家你好，<span class="name">${user.userName }</span>！<a href="/logout">[退出]</a>
        </div>
        <ul class="nav">
            <li><a href="../home/shouye.action">首页</a></li>
            <li><a href="../freemarker/public.ftl">发布</a></li>
        </ul>
    </div>
</div><div class="g-doc">
    <div class="n-result">
        <h3>发布成功！</h3>
        <p><a href="../home/show.action?contentId=${zhujian}">[查看内容]</a><a href="../home/shouye.action">[返回首页]</a></p>
    </div>
</div>
<div class="n-foot">
    <p>版权所有：<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">com.netease.southeast</a></p>
</div></body>
</html>