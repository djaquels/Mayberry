<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Mayberry</title>
      <script type="text/javascript" src="https://unpkg.com/vis-network/standalone/umd/vis-network.min.js"></script> 
    <style type="text/css">
    #mynetwork {
      width: 800px;
      height: 400px;
      border: 1px solid lightgray;
    }
  </style>

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
    <p><a href="${component.gitlab}" target="_blank"><g:img dir="images" file="/stack/repo.png" width="50" height="50"/><p></a></p>
    <button class="button-warning pure-button">Edit</button>
    <a href="/component/delete/${component.id}">
    <button class="button-error pure-button">Delete</button></a>
    <a href="/dependency/create?c1=${component.id}">
    <button class="pure-button pure-button-primary pure-button">Dependencies</button> </a>
    <p></p> 
    </div>
</div>
<h3> Dependencies Graph </h3>
<div class="pure-g">
    <div id="mynetwork" class="pure-u-1-1">
    </div>
</div>

<script type="text/javascript">
  // create an array with nodes
  var nodes = new vis.DataSet([
    {id: 1, label: 'Node 1'},
    {id: 2, label: 'Node 2'},
    {id: 3, label: 'Node 3'},
    {id: 4, label: 'Node 4'},
    {id: 5, label: 'Node 5'}
  ]);
 
  // create an array with edges
  var edges = new vis.DataSet([
    {from: 1, to: 3},
    {from: 1, to: 2},
    {from: 2, to: 4},
    {from: 2, to: 5},
    {from: 3, to: 3}
  ]);
 
  // create a network
  var container = document.getElementById('mynetwork');
  var data = {
    nodes: nodes,
    edges: edges
  };
  var options = {};
  var network = new vis.Network(container, data, options);
</script> 
</body>
</html>
