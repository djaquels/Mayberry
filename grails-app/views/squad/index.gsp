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
<button class="pure-button pure-button-primary">New Squad</button>
<div class="pure-g">

    <g:each var="squad" in="${squads}">
    <div class="pure-u-1-1 card">
    <p>Name: ${squad.name}</p>
    <button class="button-success pure-button">View</button>
    <button class="button-warning pure-button">Edit</button>
    <button class="button-error pure-button">Delete</button> 
    <p></p> 
    </div>
    </g:each>
</div>
</body>
</html>
