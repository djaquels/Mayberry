<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Mayberry</title>
</head>
<body>
<h3>Update  ${component.name} Component </h3>
<div class="pure-g">
<div class="pure-u-1-1 card">
    <form class="pure-form pure-form-aligned" action="/component/updateComponent" mehtod="POST">
    <fieldset>
        <div class="pure-control-group">
            <label for="aligned-name">Name</label>
            <input type="text" id="name" name="name"  value="${component.name}" />
            <span class="pure-form-message-inline">This is a required field.</span>
        </div>
        <div class="pure-control-group">
            <label for="aligned-url">Url</label>
            <input type="text" name="url" id="aligned-url"  value="${component.url}" />
        </div>
        <div class="pure-control-group">
            <label for="aligned-port">Port</label>
            <input type="number" name="port" id="aligned-port"  value="${component.port}" />
        </div>
        <div class="pure-control-group">
            <label for="aligned-url_development">Url Develpment</label>
            <input type="text" name="url_development" id="aligned-url"   value="${component.url_development}"/>
        </div>
        <div class="pure-control-group">
            <label for="aligned-port_development">Port Development</label>
            <input type="number" name="port_development" id="aligned-port_development" value="${component.port_development}" />
        </div>
        <div class="pure-control-group">
            <label for="aligned-dn">Discover Nanme: </label>
            <input type="text" name="discoverName" id="aligned-dn" value="${component.discoverName}" />
        </div>
        <div class="pure-control-group">
            <p> Leave blank to create a new Component </p>
            <label for="aligned-dn">Gitlab URL: </label>
            <input type="text" name="giturl" id="aligned-dn"  value="${component.gitlab}" />
        </div>
        <div class="pure-control-group">
            <input type="hidden" name="id" id="id" placeholder="${component.id}" value="${component.id}" />
        </div>
        <div class="pure-control-group">
            <label for="aligned-squad">Squad</label>
            <g:select name="idSquad"
                from="${squads}"
                optionKey="id"
                optionValue="name"
                 />
        </div>
        <div class="pure-controls">
            <label for="aligned-cb" class="pure-checkbox">
            <button type="submit" class="pure-button pure-button-primary">Submit</button>
            <button type="clear" class="button-error pure-button">Cancel</button> 
        </div>
    </fieldset>
</form>
    </div>
</div>
</body>
</html>
