<%-- 
    Document   : Sensor_Alta
    Created on : 03/09/2012, 19:58:18
    Author     : LEO
--%>


<%@include file="cabecera.jsp" %>
<div class="clearfix grpelem" id="pu1676-6"><!-- group -->
    <div class="grpelem" id="u1268" ><!-- content -->
 <h1><b>Alta Sensor<b></h1>
             <div class="domotics">

                 
                 
<%@page import="java.util.Iterator"%>
<%@page import="Negocio.Modelo_Sensor"%>
<%@page import="java.util.List"%>
<%@page import="Sensores.Controlador_Sensor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%

    Controlador_Sensor controlador = new Controlador_Sensor();
    List<Modelo_Sensor> modelos = controlador.getModelosSensores();
    // declaro variable modelo para usar en el select
    Modelo_Sensor modelo;
   

%>
<!DOCTYPE html>


    <FORM NAME="Sensor_Alta"  method="POST" action="Sensor_Alta2.jsp">

        <p>Número:<br><input type="text" name="numero" id="numero"></p>
        <p>Número de Serie:<br><input type="text" name="numero_serie" id="numero_serie"></p>
        <hr><br>
        <p>Seleccione Modelo de Sensor<br>
            <select name="modelo">
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
        <hr>
        <br>
        <input type="submit" value="Alta Sensor">

    </FORM>
   
             
             </div>
        </div>
</div>

<%@include file="pie.jsp" %>