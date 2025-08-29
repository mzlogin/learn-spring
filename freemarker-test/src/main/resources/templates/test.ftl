<#import "./layout/page.ftl" as base>

<#assign title="测试页面">

<#assign body>

    <p>欢迎来到${title}！</p>
    <p>当前时间：<span id="current-time"></span></p>

</#assign>

<#assign js>

<script>
// 每隔一秒刷新当前时间
setInterval(function() {
    document.getElementById("current-time").innerHTML = new Date().toLocaleString();
}, 1000);
</script>

</#assign>

<@base.layout title=title body=body js=js />