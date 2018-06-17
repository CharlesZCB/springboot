<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html lang="en">
<head>
    <meta http-equiv ="Content-Type" content ="text/html;charset=utf-8"/>
    <title>简单地图</title>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/arcgis_js_api/library/3.16/3.16/dijit/themes/tundra/tundra.css"/>
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/arcgis_js_api/library/3.16/3.16/esri/css/esri.css" />
    <script type="text/javascript" src="http://localhost:8080/arcgis_js_api/library/3.16/3.16/init.js"></script>
    <script type ="text/javascript">
      dojo.require("esri.map");
      function inits(){
        var myMap=new esri.Map("mapDiv");
        //请注意，如果您没有公共Internet访问，那么您需要将此URL引导到您自己的本地可访问的缓存服务。
        var myTiledMapServiceLayer = new esri.layers.ArcGISTiledMapServiceLayer("http://server.arcgisonline.com/ArcGIS/rest/services/NGS_Topo_US_2D/MapServer");
        myMap.addLayer(myTiledMapServiceLayer);
      }
        dojo.addOnLoad(inits);
    </script>
  </head>
  <body class ="tundra">
        <div id ="mapDiv" style ="width：900px; height：600px; border：1px solid #000;"></div>
  </body>
</html>