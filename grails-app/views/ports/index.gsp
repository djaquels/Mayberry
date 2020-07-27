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
<div class="">
    <table class="pure-table" style="width:100%;">
    <thead>
        <tr>
            <th>Name</th>
            <th>Port</th>
        </tr>
    </thead>
    <tbody>
        <g:each var="component" in="${components}">
        <tr class="pure-menu-list">
        <td class="pure-menu-item">
            ${component.name}
        </td>
        <td class="pure-menu-item">
            ${component.port}
        </td>
    </tr>    
    </g:each>
    
    </tbody>
</table>
</div>
</body>
</html>
