<%-- 
    Document   : subir_Archivo
    Created on : 25/09/2012, 12:19:27
    Author     : LEO
--%>

<html>

    <head>

        <title>EJERCICIO 04 SUBIR ARCHIVO</title>

    </head>

    <body>

        <!--Lo real mente importante es en el formulario decir -->

        <!--que van archivos con el enctype igual a MULTIPART/FORM-DATA -->

        <form  enctype="MULTIPART/FORM-DATA" method="post">

          <input type="file" name="file" /><br/>

            <input type="submit" value="Upload" />

        </form>

    </body>
</html>
