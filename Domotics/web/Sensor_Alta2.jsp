<%-- 
    Document   : Alta_Sensor2
    Created on : 04-sep-2012, 18:26:54
    Author     : Leo
--%>

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

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta Sensor</title>
    </head>
    <body>
        <h1>Alta Sensor</h1>
         <p>
<%
 if(sensor.equals(null)){
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

   </body>
</html>
