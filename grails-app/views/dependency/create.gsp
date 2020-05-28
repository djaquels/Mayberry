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
    <form class="pure-form pure-form-aligned" action="newDependency" mehtod="POST">
    <fieldset>
        <div class="pure-control-group">
            <label for="aligned-c1">Name</label>
            <g:select name="c1"
                from="${list}"
                optionKey="id"
                optionValue="name"
                 />
            <span class="pure-form-message-inline">This is a required field.</span>
        </div>
        <p>Depens Of: </p>
        <div class="pure-control-group">
            <label for="aligned-c2">Component 2</label>
            <g:select name="c2"
                from="${list}"
                optionKey="id"
                optionValue="name"
                 />
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
