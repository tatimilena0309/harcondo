<%-- 
    Document   : Sensor_Modificar2
    Created on : 25/09/2012, 01:20:48
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


Sensor sensor = controlador.getSensor(Integer.parseInt(request.getParameter("sensor")));



%>


<form action="Sensor_Modificar3.jsp?sensor=<%=sensor.getNumero()%>" method="POST">

    <p>Sensor Número: "<%=sensor.getNumero()%>"</p>
<p>Número de Serie<br><input type="text" value="<%=sensor.getNumero_serie()%>" name="serie" id="serie"/></p>
<p>Modelo Sensor<br>
    <select name="modelo" id="modelo">
        <option><%=sensor.getModelo_sensor().getModelo()%></option>
        <%
        List<Modelo_Sensor> Lista_Modelos = controlador.getModelosSensores();
        Modelo_Sensor modelo;
        Iterator iter = Lista_Modelos.iterator();
        while(iter.hasNext()){

        modelo = (Modelo_Sensor) iter.next();

        //Si el sensor es el mismo que el actual no lo muestra
        if(modelo.getModelo() != sensor.getModelo_sensor().getModelo()){
        out.println("<option>");
        out.println(modelo.getModelo());
        out.println("</option>");
        }

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
<br>
<p>Estado del Sensor: <br> <%=sensor.getEstado_sensor().getNombre()%></p>
<br>
<hr>
<br>

<input type="submit">

        </div>
        </div>
</div>
<%@include file="pie.jsp"%>