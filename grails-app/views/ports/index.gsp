<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Mayberry</title>
</head>
<body>
<h3>
Available Ports
</h3>
<button class="pure-button pure-button-primary">Search Port:</button>
<div class="pure-g">
    <table class="pure-table">
    <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Port</th>
        </tr>
    </thead>
    <tbody>
        <g:each var="component" in="${components}">
        <tr class="pure-menu-list">
        <td class="pure-menu-item">
            Name: ${component.name}
        </td>
        <td class="pure-menu-item">
            Port: ${component.port}
        </td>
    </tr>    
    </g:each>
    
    </tbody>
</table>
</div>
</body>
</html>
