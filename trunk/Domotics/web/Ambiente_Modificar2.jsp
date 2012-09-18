<%--
    Document   : Ambiente_Modificar
    Created on : 18-sep-2012, 15:48:05
    Author     : Leo
--%>

<%@page import="Sensores.Controlador_Sensor"%>
<%@page import="Negocio.Sensor"%>
<%@page import="java.util.Iterator"%>
<%@page import="Negocio.Ambiente"%>
<%@page import="java.util.List"%>
<%@page import="Ambientes.Controlador_Ambiente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Ambiente</title>
    </head>
    <body>
        <h1>Modificar Ambiente</h1>

<%

Controlador_Ambiente controlador = new Controlador_Ambiente();
Ambiente ambiente = controlador.getAmbiente(request.getParameter("ambiente"));


Controlador_Sensor controlador2 = new Controlador_Sensor();
//traemos los sensores para luego mostrarlos
List<Sensor> Lista_Sensores = controlador2.getSensores();
Sensor sensor;

%>
<p><h2>Ambiente a Modificar  "<%=ambiente.getNombre()%>"</h2></p>

<form action="Ambiente_Modificar3.jsp?nombre_original='<%=ambiente.getNombre()%>'" method="POST">


<p>Nombre<br><input type="text" value="<%=ambiente.getNombre()%>" name="nombre" id="nombre"/></p>
<p>Descripción<br><input type="text" value="<%=ambiente.getDescripcion()%>" name="descripcion" id="descripcion"/></p>
<p>Sensor<br>
    <select name="nro_sensor" id="nro_sensor">
        <option><%=ambiente.getSensor().getNumero()%></option>
        <%
        Iterator iter = Lista_Sensores.iterator();
        while(iter.hasNext()){

        sensor = (Sensor) iter.next();

        //Si el sensor es el mismo que el actual no lo muestra
        if(sensor.getNumero() != ambiente.getSensor().getNumero()){
        out.println("<option>");
        out.println(sensor.getNumero());
        out.println("</option>");
        }

        }
        %>
    </select>
</p>
<p>Mensaje<br><textarea cols="38" rows="5"  id="mensaje" name="mensaje"><%=ambiente.getMensaje().getDescripcion()%></textarea></p>
<p>Hora de Actualización:<br><input type="text" value="<%=ambiente.getHora_actualizacion()%>" name="mensaje" id="mensaje"/></p>
<hr>
<p>Fecha Alta:<br><%=ambiente.getFecha_alta()%></p>

<p>Fecha Ultima Modificación:<br><%=ambiente.getFecha_ultima_modificacion()%></p>
<p>Último acceso:<br><%=ambiente.getHora_ultimo_acceso()%></p>


<input type="submit">

</form>
    </body>
</html>
