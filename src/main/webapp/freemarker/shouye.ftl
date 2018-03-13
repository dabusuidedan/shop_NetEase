<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>首页</title>
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
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <div class="tab">
            <ul>
        <#if user?exists>
          <#if user.userName=="buyer">
             <#if cflag?exists>
               <li  ><a href="../home/shouye.action">所有内容</a></li>
                <li class="z-sel"><a href="../home/shouye.action?contentFlag=0">未购买的内容</a></li>
             <#else>
                 <li class="z-sel" ><a href="../home/shouye.action">所有内容</a></li>
                <li ><a href="../home/shouye.action?contentFlag=0">未购买的内容</a></li>
             </#if>
          <#else>
            <li class="z-sel" ><a href="../home/shouye.action">所有内容</a></li>
          </#if>
       <#else>
       <li class="z-sel" ><a href="../home/shouye.action">所有内容</a></li> 
       </#if>     
            </ul>
        </div>
    </div>
    <div class="n-plist">
        <ul class="f-cb" id="plist">
<#if user?exists>
   <#if user.userName=="buyer">
     <#list contents as content>
       <li id="p-${content.contentId}"> 
         <a href="../home/show.action?contentId=${content.contentId}" class="link">
          <div class="img"><img src="${content.contentImage}" alt="${content.contentTitle}"/> </div>
          <h3>${content.contentTitle}</h3>
          <div class="price"><span class="v-unit">¥</span><span class="v-value">${content.contentPrice}</span></div>
          <#if content.contentFlag==1>
          <span class="had"><b>已购买</b></span>
          </#if>
         </a>
        </li>
      </#list>
   <#else>
     <#list contents as content>
       <li id="p-${content.contentId}"> 
        <a href="../home/show.action?contentId=${content.contentId}" class="link">
        <div class="img"><img src="${content.contentImage}" alt="${content.contentTitle}"/> </div>
        <h3>${content.contentTitle}</h3>
        <div class="price"><span class="v-unit">¥</span><span class="v-value">${content.contentPrice}</span></div>
        <#if content.contentFlag==1>
        <span class="had"><b>已售出</b></span>
        </#if>
        </a>
           <#if content.contentFlag==0>
             <span class="u-btn u-btn-normal u-btn-xs del" data-del="${content.contentId}">删除</span>
           </#if>
       </li>
     </#list>
  </#if>
<#else>
     <#list contents as content>
      <li id="p-${content.contentId}"> 
       <a href="../home/show.action?contentId=${content.contentId}" class="link">
       <div class="img"><img src="${content.contentImage}" alt="${content.contentTitle}"/> </div>
       <h3>${content.contentTitle}</h3>
       <div class="price"><span class="v-unit">¥</span><span class="v-value">${content.contentPrice}</span></div>
       </a>
      </li>
    </#list>
</#if>
</ul>
    </div>
</div>
<div class="n-foot">
    <p>版权所有：<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">com.netease.southeast</a></p>
</div><script type="text/javascript" src="../js/global.js"></script>
<script type="text/javascript" src="../js/pageIndex.js"></script>
</body>
</html>
</html>