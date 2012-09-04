<%-- 
    Document   : Ambiente_Alta
    Created on : 04-sep-2012, 17:33:28
    Author     : Leo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ambiente Alta</title>
    </head>
<body>
<h1>Alta Ambiente</h1>

    <form>


        <b>Ingresar Nombre de Ambiente:</b>



        <input type="text" size="35" id="ambiente" name="ambiente">


        <br><br><br>
        <b>Ingresar Descripción Ambiente:</b><br>

        <textarea cols="38" rows="5"  id="desc_ambiente" name="desc_ambiente"></textarea>

        <br><br><br>
        <b>Agregar Sensor Nro:</b>

        <select  id="sensor" name="sensor">
        <option>009</option>
        <option>008</option>
        <option>003</option>
        <option>002</option>
        </select>

        <br><br><br>
        <b>Agregar Mensaje de Ingreso</b> <br>
        <textarea cols="38" rows="5"  id="mensaje_ingreso" name="mensaje_ingreso"></textarea>


    </form>

</body>
</html>
