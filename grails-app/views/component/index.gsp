<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Mayberry</title>
</head>
<body>
<h3>Components List </h3>
<button class="pure-button pure-button-primary">New Component.</button>
<div class="pure-g">
    
    <g:each var="component" in="${components}">
    <div class="pure-u-1-3 card">
    <p>Name: ${component.name}</p>
    <p>Url: ${component.url} Port: ${component.port} </p> 
    </div>
    </g:each>
</div>
</body>
</html>
