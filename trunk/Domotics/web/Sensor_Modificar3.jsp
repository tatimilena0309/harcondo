<%-- 
    Document   : Sensor_Modificar3
    Created on : 25/09/2012, 01:48:43
    Author     : LEO
--%>

<%@page import="Sensores.Controlador_Sensor"%>
<%--
    Document   : Ambiente_Modificar
    Created on : 18-sep-2012, 15:48:05
    Author     : Leo
--%>

<%@include file="cabecera.jsp" %>
<div class="clearfix grpelem" id="pu1676-6"><!-- group -->
    <div class="grpelem" id="u1268" ><!-- content -->
 <h1><b>Modificar Sensor<b></h1>
        <div class="domotics">


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">



<%
Controlador_Sensor controlador = new Controlador_Sensor();

String numero = request.getParameter("sensor");
String modelo_sensor = request.getParameter("modelo");
String nro_serie = request.getParameter("serie");

if (controlador.Modificar_Sensor(numero, modelo_sensor, nro_serie)){
//if(controlador.Modificar_Ambiente(ambiente.getId(), request.getParameter("nombre"), request.getParameter("descripcion"), request.getParameter("nro_sensor"), request.getParameter("mensaje"), request.getParameter("hora_actualizacion"))){
%>

<br>
<p><h2>El Sensor Número"<%=numero%>" fue Modificado con Exito.</h2></p>

<%
}else{
%>

<p><h2>Error al Modificar Sensor Número "<%=numero%>".</h2></p>

<%
}
%>

</form>
        </div>
        </div>
</div>
<%@include file="pie.jsp"%>