<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Mayberry</title>
</head>
<body>
<h3>New Dependency </h3>
<div class="pure-g">
<div class="pure-u-1-1 card">
    <form class="pure-form pure-form-aligned" action="newComponent" mehtod="POST">
    <fieldset>
        <div class="pure-control-group">
            <label for="aligned-c1">Name</label>
            <input type="numeric" id="c1" name="c1" placeholder="${c1.name}" value="${c1.id}" />
            <span class="pure-form-message-inline">This is a required field.</span>
        </div>
        <p>Depens Of: </p>
        <div class="pure-control-group">
            <label for="aligned-c2">Component 2</label>
            <input type="numeric" id="c2" name="c2" placeholder="Dependency" value="" />
            <span class="pure-form-message-inline">This is a required field.</span>
        </div>
        <div class="pure-control-group">
            <label for="aligned-grade">Grade</label>
            <input type="number" name="grade" id="aligned-grade" placeholder="1" />
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
