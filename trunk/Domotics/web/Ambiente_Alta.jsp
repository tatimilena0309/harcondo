<%-- 
    Document   : Ambiente_Alta
    Created on : 04-sep-2012, 17:33:28
    Author     : Leo
--%>


<%@page import="java.util.Iterator"%>
<%@page import="Negocio.Sensor"%>
<%@page import="java.util.List"%>
<%@page import="Sensores.Controlador_Sensor"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

    Controlador_Sensor controlador2 = new Controlador_Sensor();
    
    //traemos los sensores para luego mostrarlos
    List<Sensor> Lista_Sensores = controlador2.getSensores();
    Sensor sensor;
    
    
   

%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ambiente Alta</title>
    </head>
<body>
<h1>Alta Ambiente</h1>

<form action="Ambiente_Alta2.jsp" method="POST">


        <b>Ingresar Nombre de Ambiente:</b><br>



        <input type="text" size="35" id="ambiente" name="ambiente">


        <br><br><br>
        <b>Ingresar Descripción Ambiente:</b><br>

        <textarea cols="38" rows="5"  id="desc_ambiente" name="desc_ambiente"></textarea>

        <br><br><br>
        <b>Agregar Sensor Nro:</b>

        <select  id="nro_sensor" name="nro_sensor">
<%
        
        Iterator iter = Lista_Sensores.iterator();
        while(iter.hasNext()){

        sensor = (Sensor) iter.next();

        out.println("<option>");
        out.println(sensor.getNumero());
        out.println("</option>");
    
    }


%> 
        </select>

        <br><br><br>
        <b>Agregar Mensaje de Ingreso</b> <br>
        <textarea cols="38" rows="5"  id="mensaje_ingreso" name="mensaje_ingreso"></textarea>
        <br>

        <p>Hora de Actualización:<br><input type="text" value="" name="actualizacion" id="actualizacion"/></p>

        <input type="submit"/>
    </form>

</body>
</html>
