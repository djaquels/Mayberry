<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <meta name="charset" content="utf-8"/>
    <title>Mayberry</title>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
      <script type="text/javascript" src="https://unpkg.com/vis-network/standalone/umd/vis-network.min.js"></script> 
    <style type="text/css">
    #mynetwork {
      width: 800px;
      height: 400px;
      border: 1px solid lightgray;
    }
    table{
      width:100% !important;
      letter-spacing:normal !important;
    }
  </style>

</head>
<body onLoad="buildHtmlTable('#excelDataTable');">
<h3>
System Global Overview
</h3>

<h3> Dependencies Graph </h3>
<button class="button-success pure-button"onclick="buildHtmlTable('#excelDataTable');"> Download Matrix</button>
<div class="pure-g">
    <div id="mynetwork" class="pure-u-1-1">
    </div>
    <table id="excelDataTable" border="1" hidden>
    </table>
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

<g:javascript>
<g:applyCodec encodeAs="none">

 var garrix = ${nodes};
 var guetta = ${edges};
 var arrson = ${nodes}.map(e => JSON.parse(e));
 var arred = ${edges}.map(e => JSON.parse(e));
 var fortable = arred;
 var nodeLabeMap = {}
// Builds the HTML Table out of myList.
for(var i=0; i<arrson.length;i++){
  const id = arrson[i].id
  nodeLabeMap[id] = arrson[i].label
}
for(var j=0; j < fortable.length; j++){
  fortable[j].from = nodeLabeMap[ fortable[j].from ]
  fortable[j].to = nodeLabeMap[ fortable[j].to ]
}
 var myList = fortable;
function buildHtmlTable(selector) {
  var columns = addAllColumnHeaders(myList, selector);

  for (var i = 0; i < myList.length; i++) {
    var row$ = $('<tr/>');
    for (var colIndex = 0; colIndex < columns.length; colIndex++) {
      var cellValue = myList[i][columns[colIndex]];
      if (cellValue == null) cellValue = "";
      row$.append($('<td/>').html(cellValue));
    }
    $(selector).append(row$);
  }
  exportTableToExcel('excelDataTable');
}

// Adds a header row to the table and returns the set of columns.
// Need to do union of keys from all records as some records may not contain
// all records.
function addAllColumnHeaders(myList, selector) {
  var columnSet = [];
  var headerTr$ = $('<tr/>');

  for (var i = 0; i < myList.length; i++) {
    var rowHash = myList[i];
    for (var key in rowHash) {
      if ($.inArray(key, columnSet) == -1) {
        columnSet.push(key);
        headerTr$.append($('<th/>').html(key));
      }
    }
  }
  $(selector).append(headerTr$);

  return columnSet;
}
function exportTableToExcel(tableID, filename = ''){
    var downloadLink;
    var dataType = 'application/vnd.ms-excel';
    var tableSelect = document.getElementById(tableID);
    var tableHTML = tableSelect.outerHTML.replace(/ /g, '%20');
    
    // Specify file name
    filename = filename?filename+'.xls':'dependencies_matrix.xls';
    
    // Create download link element
    downloadLink = document.createElement("a");
    
    document.body.appendChild(downloadLink);
    
    if(navigator.msSaveOrOpenBlob){
        var blob = new Blob(['\ufeff', tableHTML], {
            type: dataType
        });
        navigator.msSaveOrOpenBlob( blob, filename);
    }else{
        // Create a link to the file
        downloadLink.href = 'data:' + dataType + ', ' + tableHTML;
    
        // Setting the file name
        downloadLink.download = filename;
        
        //triggering the function
        downloadLink.click();
    }
}
</g:applyCodec>
</g:javascript>


</body>
</html>
