<#import "./layout/page.ftl" as base>

<#assign title="Test Page">

<#assign body>

<p>Hello, <span id="name">World</span>!</p>

</#assign>

<#assign js>

<script>
    // Freemarker 和 World 来回切换，时间间隔 1 秒
    setInterval(function() {
        var nameElement = document.getElementById("name");
        nameElement.innerText = nameElement.innerText === "Freemarker" ? "World" : "Freemarker";
    }, 1000);
</script>

</#assign>

<@base.layout title=title body=body js=js />