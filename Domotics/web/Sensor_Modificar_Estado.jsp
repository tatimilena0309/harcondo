<%-- 
    Document   : Sensor_Modificar_Estado
    Created on : 25/09/2012, 02:21:57
    Author     : LEO
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Negocio.Sensor"%>
<%@page import="java.util.List"%>
<%@page import="Sensores.Controlador_Sensor"%>
<%-- 
    Document   : Ambiente_Baja
    Created on : 18-sep-2012, 21:18:12
    Author     : Leo
--%>

<%@include file="cabecera.jsp" %>
<div class="clearfix grpelem" id="pu1676-6"><!-- group -->
    <div class="grpelem" id="u1268" ><!-- content -->
 <h1><b>Modificar Estado Ambiente<b></h1>
        <div class="domotics">


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">




                 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<%

Controlador_Sensor controlador = new Controlador_Sensor();
List<Sensor> listaSensores = controlador.getSensores();

%>
<p><h2>Seleccione Sensor a Modificar Estado</h2></p>
<br>
<form action="Sensor_Modificar_Estado2.jsp" method="POST">

<select name="sensor" id="sensor">
<%
Sensor sensor;
 Iterator iter = listaSensores.iterator();
        while(iter.hasNext()){

        sensor = (Sensor) iter.next();

        out.println("<option>");
        out.println(sensor.getNumero());
        out.println("</option>");

    }


%>
</select>
<br><br><br>
<input type="submit"  >
</form>
        </div>
        </div>
</div>

<%@include file="pie.jsp" %>