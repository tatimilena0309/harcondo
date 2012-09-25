<%-- 
    Document   : Sensor_Modificar_Estado3
    Created on : 25/09/2012, 02:36:12
    Author     : LEO
--%>


<%@page import="Sensores.Controlador_Sensor"%>

<%@include file="cabecera.jsp" %>
<div class="clearfix grpelem" id="pu1676-6"><!-- group -->
    <div class="grpelem" id="u1268" ><!-- content -->
 <h1><b>Modificar Estado Sensor<b></h1>
        <div class="domotics">


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">



<%
Controlador_Sensor controlador = new Controlador_Sensor();

String numero = request.getParameter("sensor");
String estado = request.getParameter("estado");

if (controlador.Modificar_Estado_Sensor(numero, estado)){
//if(controlador.Modificar_Ambiente(ambiente.getId(), request.getParameter("nombre"), request.getParameter("descripcion"), request.getParameter("nro_sensor"), request.getParameter("mensaje"), request.getParameter("hora_actualizacion"))){
%>

<br>
<p><h2>El Estado del Sensor Número"<%=numero%>" fue Modificado con Exito a "<%=estado%>".</h2></p>

<%
}else{
%>

<p><h2>Error al Modificar el Estado del Sensor Número "<%=numero%>" a "<%=estado%>".</h2></p>

<%
}
%>

</form>
        </div>
        </div>
</div>
<%@include file="pie.jsp"%>