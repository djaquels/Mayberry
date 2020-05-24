<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Mayberry</title>
</head>
<body>
<h3>
Component: ${component.name}
</h3>
<div class="pure-g">

    <div class="pure-u-1-1 card">
    <p>Name: ${component.name}</p>
    <p>Url: ${component.url}</p>
    <p>Port: ${component.port}</p>
    <p>Squad: ${component.idSquad}</p>
    <p>Discover Name: ${component.discoverName}</p>
    <button class="button-warning pure-button">Edit</button>
    <button class="button-error pure-button">Delete</button>
    <button class="pure-button pure-button-primary pure-button">Dependencies</button>  
    <p></p> 
    </div>
</div>
</body>
</html>
