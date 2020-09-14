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
    <a href="/component/update/${component.id}">
    <button class="button-warning pure-button">Edit</button></a>
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

<g:javascript>
<g:applyCodec encodeAs="none">
 var garrix = ${nodes};
 var guetta = ${edges};
 var arrson = ${nodes}.map(e => JSON.parse(e));
 var arred = ${edges}.map(e => JSON.parse(e));
 var nodes = new vis.DataSet(arrson);
  // create an array with edges
  var edges = new vis.DataSet(arred);
 
  // create a network
  var container = document.getElementById('mynetwork');
  var data = {
    nodes: nodes,
    edges: edges
  };
  var options = {
          nodes: {
            shape: "dot",
            size: 16,
          },
          physics: {
            forceAtlas2Based: {
              gravitationalConstant: -26,
              centralGravity: 0.005,
              springLength: 230,
              springConstant: 0.18,
            },
            maxVelocity: 146,
            solver: "forceAtlas2Based",
            timestep: 0.35,
            stabilization: { iterations: 150 },
          },
  };
  var network = new vis.Network(container, data, options);
</g:applyCodec>
</g:javascript>
</body>
</html>
