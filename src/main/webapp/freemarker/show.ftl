<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>详细页面</title>
<link rel="stylesheet" href="../css/style.css"/>
</head><body>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div>
<div class="n-head">
    <div class="g-doc f-cb">   
    <#if user?exists>
        <#if user.userName=="buyer">
        <div class="user">
                    买家你好，<span class="name">${user.userName }</span>！<a href="../user/logout.action">[退出]</a>
        </div>
        <ul class="nav">
            <li><a href="../home/shouye.action">首页</a></li>
            <li><a href="../home/account.action">账务</a></li>
            <li><a href="../home/settleAccount.action">购物车</a></li>
        </ul>
        <#else>
        <div class="user">
                    卖家你好，<span class="name">${user.userName }</span>！<a href="../user/logout.action">[退出]</a>
        </div>
        <ul class="nav">
            <li><a href="../home/shouye.action">首页</a></li>
            <li><a href="../freemarker/public.ftl">发布</a></li>
        </ul>
        </#if>
    <#else>
        <div class="user">
                    请<a href="../freemarker/login.ftl">[登录]</a>
        </div>
        <ul class="nav">
            <li><a href="../home/shouye.action">首页</a></li>
        </ul>
    </#if>    
    </div>
</div>
<div class="g-doc">
    <div class="n-show f-cb" id="showContent">
        <div class="img"><img src="${content.contentImage}" alt="" ></div>
        <div class="cnt">
            <h2>${content.contentTitle}</h2>
            <p class="summary">${content.contentAbstract}</p>
            <div class="price">
                <span class="v-unit">¥</span><span class="v-value">${content.contentPrice}</span>
            </div>
            <#if account?exists>
            <div class="num">购买数量：<span id="plusNum" class="lessNum"><a>-</a></span><span class="totalNum" id="allNum">${account.accountNum}</span><span id="addNum" class="moreNum"><a>+</a></span></div>
            <#else>
            <div class="num">购买数量：<span id="plusNum" class="lessNum"><a>-</a></span><span class="totalNum" id="allNum">2</span><span id="addNum" class="moreNum"><a>+</a></span></div>
            </#if>
            <div class="oprt f-cb">
      <#if user?exists>
        <#if user.userName=="buyer">
           <#if account?exists>
           <span class="u-btn u-btn-primary z-dis">已购买</span>
           <span class="buyprice">当时购买价格：¥${account.accountPrice}</span>
           <#else>
            <button class="u-btn u-btn-primary" id="add" data-id="${content.contentId}" data-title="${content.contentTitle}" data-price="${content.contentPrice}">
                                                  加入购物车</button>
           </#if>
        <#else>
        <a href="../home/edit.action?id=${content.contentId}" class="u-btn u-btn-primary">编 辑</a>
        </#if>       
      </#if>                 
            </div>
        </div>
    </div>
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>详细信息</h2>
    </div>
    <div class="n-detail">
     ${content.contentBody}
    </div>
</div>
<div class="n-foot">
    <p>版权所有：<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">com.netease.southeast</a></p>
</div><script type="text/javascript" src="../js/global.js"></script>
<script type="text/javascript" src="../js/pageShow.js"></script>
</body>
</html>