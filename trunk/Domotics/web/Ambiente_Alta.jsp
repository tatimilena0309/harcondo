<%-- 
    Document   : Ambiente_Alta
    Created on : 04-sep-2012, 17:33:28
    Author     : Leo
--%>

<%@include file="cabecera.jsp" %>
<div class="clearfix grpelem" id="pu1676-6"><!-- group -->
    <div class="grpelem" id="u1268" ><!-- content -->
 <h1><b>Alta Ambiente<b></h1>
             <div class="domotics">
                 
<%@page import="java.util.Iterator"%>
<%@page import="Negocio.Sensor"%>
<%@page import="java.util.List"%>
<%@page import="Sensores.Controlador_Sensor"%>




<%

    Controlador_Sensor controlador2 = new Controlador_Sensor();
    
    //traemos los sensores para luego mostrarlos
    List<Sensor> Lista_Sensores = controlador2.getSensoresDisponibles();
    Sensor sensor;
    
    
   

%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">








<form action="Ambiente_Alta2.jsp" method="POST">


        <b>Ingresar Nombre de Ambiente:</b><br>



        <input type="text" size="35" id="ambiente" name="ambiente">


        <br><br><br>
        <b>Ingresar Descripción Ambiente:</b><br>

        <textarea cols="40" rows="5"  id="desc_ambiente" name="desc_ambiente"></textarea>

        <br><br><br>
        <b>Agregar Sensor Nro:</b>

        <select  id="nro_sensor" name="nro_sensor">
<%
        
        Iterator iter = Lista_Sensores.iterator();
        while(iter.hasNext()){

        sensor = (Sensor) iter.next();

        out.println("<option>");
        out.println(sensor.getNumero());
        out.println("</option>");
    
    }


%> 
        </select>

        <br><br><br>
        <b>Agregar Mensaje de Ingreso</b> <br>
        <!---- <textarea cols="40" rows="5"  id="mensaje_ingreso" name="mensaje_ingreso"></textarea> -->
            <form action="subir_Archivo2.jsp" enctype="MULTIPART/FORM-DATA" method="post">
                <input type="file" name="file" /><br/>
            </form>
        <br><br>
        
        
        
        
        

        <p><b>Hora de Actualización:</b><br><input type="text" value="" name="actualizacion" id="actualizacion"/></p>
        <br>
        <input type="submit"/>
    </form>
        
        </div>
        </div>
</div>

<%@include file="pie.jsp" %>