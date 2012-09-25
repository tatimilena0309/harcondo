<%-- 
    Document   : Alta_Sensor2
    Created on : 04-sep-2012, 18:26:54
    Author     : Leo
--%>


<%@include file="cabecera.jsp" %>
<div class="clearfix grpelem" id="pu1676-6"><!-- group -->
    <div class="grpelem" id="u1268" ><!-- content -->
 <h1><b>Alta Sensor<b></h1>
             <div class="domotics">

<%@page import="Negocio.Sensor"%>
<%@page import="Sensores.Controlador_Sensor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%

    Controlador_Sensor controlador = new Controlador_Sensor();
    int numero = Integer.parseInt(request.getParameter("numero"));
    String numero_serie = request.getParameter("numero_serie");
    String modelo = request.getParameter("modelo");
    Sensor sensor = controlador.Alta_Sensor(numero, numero_serie, modelo);


%>


         <p>
<%
 if(!sensor.equals(null)){
%>

            El sensor número <%=sensor.getNumero()%> fue dado de alta con exito!
<%
 }else{
%>
            Falla en el alta!
<%
}
%>
        </p>
  </div>
        </div>
</div>

<%@include file="pie.jsp" %>