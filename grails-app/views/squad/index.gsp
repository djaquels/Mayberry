<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Mayberry</title>
</head>
<body>
<h3>
Squads
</h3>
<div class="pure-g">

    <g:each var="squad" in="${squads}">
    <div class="pure-u-1-1 card">
    <p>Name: ${squad.name}</p>
    <button class="button-warning pure-button">Edit</button>
    <p></p> 
    </div>
    </g:each>
</div>
</body>
</html>
