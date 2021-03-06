<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Mayberry</title>
</head>
<body>
<h3>Components List </h3>
<span>
${mensaje}</p>
<p>

Code: ${code}
</p>
</span>
<a href="/">
<button class="pure-button pure-button-primary">New Component.</button></a>
<div class="pure-g">
    
    <g:each var="component" in="${components}">
    <div class="pure-u-1-3 card">
    <p>Name: ${component.name}</p>
    <p>Url: ${component.url} Port: ${component.port} </p>
    <a href="/component/view/${component.id}">
    <button class="button-success pure-button">View</button></a>
    <a href="/component/update/${component.id}">
    <button class="button-warning pure-button">Edit</button></a>
    </div>
    </g:each>
</div>
</body>
</html>
