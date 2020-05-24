<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Mayberry</title>
</head>
<body>
<h3>New ${framework} Component </h3>
<div class="pure-g">
<div class="pure-u-1-1 card">
    <form class="pure-form pure-form-aligned" action="newComponent" mehtod="POST">
    <fieldset>
        <div class="pure-control-group">
            <label for="aligned-name">Name</label>
            <input type="text" id="name" name="name" placeholder="Project Name" />
            <span class="pure-form-message-inline">This is a required field.</span>
        </div>
        <div class="pure-control-group">
            <label for="aligned-url">Url</label>
            <input type="text" name="url" id="aligned-url" placeholder="http://" />
        </div>
        <div class="pure-control-group">
            <label for="aligned-port">Port</label>
            <input type="number" name="port" id="aligned-port" placeholder="5432" />
        </div>
        <div class="pure-control-group">
            <label for="aligned-dn">Discover Nanme: </label>
            <input type="text" name="discoverName" id="aligned-dn" placeholder="/hello" />
        </div>
        <div class="pure-control-group">
            <input type="hidden" name="seed" id="aligned-password" placeholder="${seed}" value="${seed}" />
        </div>
        <div class="pure-control-group">
            <label for="aligned-squad">Squad</label>
            <input type="text" name="idSquad" id="aligned-squad" placeholder="Squad" />
        </div>
        <div class="pure-control-group">
            <label for="aligned-text">Token</label>
            <input type="text" id="aligned-text" name="token" placeholder="Gitlab Api Token" />
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
