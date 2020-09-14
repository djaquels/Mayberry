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
<button class="pure-button pure-button-primary">Search Port or Service</button></p>
<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search Port:">
<div class="">
    <table class="pure-table" style="width:100%;" id="Table">
    <thead>
        <tr>
            <th>Name</th>
            <th>Port</th>
            <th>Link</th>
            <th> Development Port</th>
            <th> Development Url </th>
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
        <td class="pure-menu-item">
            <a href="${component.url}:${component.port}" target="_"> ${component.url}:${component.port}</a>
        </td>
        <td class="pure-menu-item">
            ${component.port_development}
        </td>
        <td class="pure-menu-item">
            <a href="${component.url_development}:${component.port_development}" target="_"> ${component.url_development}:${component.port_development}</a>
        </td>
    </tr>    
    </g:each>
    
    </tbody>
</table>
</div>
<script>
function myFunction() {
  // Declare variables
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("Table");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
    td2 = tr[i].getElementsByTagName("td")[3];
    nameC = tr[i].getElementsByTagName("td")[0];
    if (td) {
      txtValue = td.textContent || td.innerText;
      nameValue =  nameC.textContent || nameC.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1 || nameValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}
</script>
</body>
</html>
