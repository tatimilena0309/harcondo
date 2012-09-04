<%-- 
    Document   : Sensor_Alta
    Created on : 03/09/2012, 19:58:18
    Author     : LEO
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Negocio.Modelo_Sensor"%>
<%@page import="java.util.List"%>
<%@page import="Sensores.Controlador_Sensor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

    Controlador_Sensor controlador = new Controlador_Sensor();
    List<Modelo_Sensor> modelos = controlador.getModelosSensores();
    Modelo_Sensor modelo;
   

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta Sensor</title>
    </head>
    <body>
        <h1>Alta Sensor</h1>

    <FORM NAME="Sensor_Alta"  method="POST" action="Sensor_Alta2.jsp">

        <p>Número:<br><input type="text" name="numero" id="numero"></p>
        <p>Número de Serie:<br><input type="text" name="numero_serie" id="numero_serie"></p>
        <p>
            <select>
<%
Iterator iter = modelos.iterator();
    while(iter.hasNext()){

        modelo = (Modelo_Sensor) iter.next();

        out.println("<option>");
        out.println(modelo.getModelo());
      
        out.println("</option>");
    
    }



%>
            </select>
            
        </p>
        <input type="submit" value="Alta Sensor">

    </FORM>
    </body>
</html>
