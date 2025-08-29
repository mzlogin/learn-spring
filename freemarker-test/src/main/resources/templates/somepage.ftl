<#import "./layout/page.ftl" as base>

<#assign body>

<p>我是页面内容</p>
<p>当前时间：<span id="current-time">${.now?string("yyyy-MM-dd HH:mm:ss")}</span></p>

</#assign>

<#assign js>

<script>
// 每隔一秒刷新当前时间
setInterval(function() {
    document.getElementById("current-time").innerHTML = new Date().toLocaleString();
}, 1000);
</script>

</#assign>

<@base.layout body=body js=js />