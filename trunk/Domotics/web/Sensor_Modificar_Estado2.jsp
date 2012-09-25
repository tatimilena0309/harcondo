<%-- 
    Document   : Sensor_Modificar_Estado2
    Created on : 25/09/2012, 02:23:44
    Author     : LEO
--%>


<%@page import="persistencia.formateador_fechas"%>
<%@page import="persistencia.Fachada_Persistencia"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Iterator"%>
<%@page import="Negocio.Modelo_Sensor"%>
<%@page import="java.util.List"%>
<%@page import="Negocio.Sensor"%>
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


Sensor sensor = controlador.getSensor(Integer.parseInt(request.getParameter("sensor")));


if (sensor.getEstado_sensor().getNombre().equals("Asignado")){
%>


<p>Sensor Asignado a un Ambiente.<br> Solamente se pueden modificar Sensores sin asignar o dados de baja</p>

<%
} else{
%>


<form action="Sensor_Modificar_Estado3.jsp?sensor=<%=sensor.getNumero()%>" method="POST">

<p>Sensor Número: "<%=sensor.getNumero()%>"</p>
<p>Número de Serie: "<%=sensor.getNumero_serie()%>"</p>

<p>Modelo Sensor: "<%=sensor.getModelo_sensor().getModelo()%>"</p>
<br>
<hr>
<br>
<p>Seleccine Estado Sensor <br> <select name="estado">  
        <option><%=sensor.getEstado_sensor().getNombre()%></option>
<%
        
    if(sensor.getEstado_sensor().getNombre().equals("Sin_Asignar")){
        out.println("<option>" + controlador.getEstado_Sensor("Baja").getNombre()+  "</option>");
    }else{
        out.println("<option>" + controlador.getEstado_Sensor("Sin_Asignar").getNombre()+  "</option>");
    }
       
%>
    </select>
    
 
</p>
<br>
<hr>
<br>
<p>Última Modificación: <%=formateador_fechas.getInstance().getFecha_y_Hora(sensor.getFecha_ultima_modificacion())%></p>
    
</p>Fecha de Alta: <%=formateador_fechas.getInstance().getFecha_y_Hora(sensor.getFecha_alta())%></p>
<br>
<hr>
<hr>
<br>

<input type="submit">
<%
}
%>
        </div>
        </div>
</div>
<%@include file="pie.jsp"%>