<%-- 
    Document   : Ambiente_Modificar_Estado3
    Created on : 18-sep-2012, 21:44:54
    Author     : Leo
--%>

<%@page import="Sensores.Controlador_Sensor"%>
<%@page import="Negocio.Sensor"%>
<%@page import="java.util.Iterator"%>
<%@page import="Negocio.Ambiente"%>
<%@page import="java.util.List"%>
<%@page import="Ambientes.Controlador_Ambiente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Ambiente</title>
    </head>
    <body>
        <h1>Modificar Ambiente</h1>

<%

Controlador_Ambiente controlador = new Controlador_Ambiente();


String id = request.getParameter("id");
//Long id = Long.parseLong(request.getParameter("id"));
String nombre_estado = request.getParameter("estado");
if (controlador.Modificar_Estado_Ambiente(Long.parseLong(id), nombre_estado)){
//if(controlador.Modificar_Ambiente(ambiente.getId(), request.getParameter("nombre"), request.getParameter("descripcion"), request.getParameter("nro_sensor"), request.getParameter("mensaje"), request.getParameter("hora_actualizacion"))){
%>

<br>
<p><h2>Estado del Ambiente Modificado con Exito a "<%=nombre_estado%>".</h2></p>

<%
}else{
%>

<p><h2>Error al Modificar el Estado del Ambiente.</h2></p>

<%
}
%>

</form>
    </body>
</html>
