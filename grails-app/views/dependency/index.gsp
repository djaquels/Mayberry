<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Mayberry</title>
</head>
<body>
<h3>Dependencies </h3>
<span>
</span>
<a href="/">
<button class="pure-button pure-button-primary">New Component.</button></a>
<div class="pure-g">
    ${mensaje}
    <g:each var="dependency" in="${Dependencies}">
    <div class="pure-u-1-3 card">
    <button class="button-success pure-button">View</button></a>
    <button class="button-warning pure-button">Edit</button>
    </div>
    </g:each>
</div>
</body>
</html>
