<%--
    Document   : Ambiente_Modificar
    Created on : 18-sep-2012, 15:48:05
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
String nombre = request.getParameter("nombre");
String descripcion = request.getParameter("descripcion");
String nro_sensor = request.getParameter("nro_sensor");
String mensaje = request.getParameter("mensaje");
String hora_actualizacion = request.getParameter("hora_actualizacion");

if (controlador.Modificar_Ambiente(Long.parseLong(id), nombre, descripcion, nro_sensor, mensaje, hora_actualizacion)){
//if(controlador.Modificar_Ambiente(ambiente.getId(), request.getParameter("nombre"), request.getParameter("descripcion"), request.getParameter("nro_sensor"), request.getParameter("mensaje"), request.getParameter("hora_actualizacion"))){
%>

<br>
<p><h2>Ambiente "<%=request.getParameter("nombre")%>" Modificado con Exito.</h2></p>

<%
}else{
%>

<p><h2>Error al Modificar Ambiente "<%=request.getParameter("nombre")%>".</h2></p>

<%
}
%>

</form>
    </body>
</html>
