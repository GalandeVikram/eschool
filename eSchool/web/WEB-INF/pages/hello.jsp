<%-- 
    Document   : hello
    Created on : Jun 27, 2011, 3:08:35 PM
    Author     : vikram.galande
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Spring MVC Ajax Demo</title>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript">
            function doAjax() {
                alert("vikram")
                $.ajax({
                    url: 'time.htm',
                    data: ({name : "me"}),
                    success: function(data) {
                        $('#time').html(data);
                    }
                });
            }
        </script>
    </head>
    <body>
        <button id="demo" onclick="doAjax()" title="Button">Get the time!</button>
        <div id="time">
        </div>
    </body>
</html>