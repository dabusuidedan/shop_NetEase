<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>账务</title>
<link rel="stylesheet" href="../css/style.css"/>
</head><body>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div><div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
                    买家你好，<span class="name">${user.userName }</span>！<a href="../user/logout.action">[退出]</a>
        </div>
        <ul class="nav">
            <li><a href="../home/shouye.action">首页</a></li>
            <li><a href="../home/account.action">账务</a></li>
            <li><a href="../home/settleAccount.action">购物车</a></li>
        </ul>
    </div>
</div><div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>已购买的内容</h2>
    </div>
    <table class="m-table m-table-row n-table g-b3">
        <colgroup><col class="img"/><col/><col class="time"/><col/><col class="num"/><col/><col class="price"/><col/></colgroup>
        <thead>
            <tr><th>内容图片</th><th>内容名称</th><th>购买时间</th><th>购买数量</th><th>购买价格</th></tr>
        </thead>
        <tbody>
         <#list accountAll as account1>
            <tr>
                <td><a href="../home/show.action?contentId=${account1.accountContentId}"><img src="${account1.accountImage}" alt=""></a></td>
                <td><h4><a href="../home/show.action?contentId=${account1.accountContentId}">${account1.accountTitle}</a></h4></td>
                <td><span class="v-time">${account1.accountTime?string("yyyy-MM-dd HH:mm")}</span></td>
                <td><span class="v-num">${account1.accountNum}</span></td>
                <td><span class="v-unit">¥</span><span class="value">${account1.accountPrice}</span></td>
            </tr>
         </#list>
</tbody>
        <tfoot>
            <tr>
                <td colspan="4"><div class="total">总计：</div></td>
                <td><span class="v-unit">¥</span><span class="value">${sum}</span></td>
            </tr>
        </tfoot>
    </table>
</div>
<div class="n-foot">
    <p>版权所有：<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">com.netease.southeast</a></p>
</div></body>
</html>