<%-- 
    Document   : Ambiente_Modificar_Estado2
    Created on : 18-sep-2012, 21:22:15
    Author     : Leo
--%>
<%@page import="Negocio.Estado_Ambiente"%>
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
        <title>Modificar Estado Ambiente</title>
    </head>
    <body>
        <h1>Modificar Estado Ambiente</h1>

<%

Controlador_Ambiente controlador = new Controlador_Ambiente();
Ambiente ambiente = controlador.getAmbiente(request.getParameter("ambiente"));

List<Estado_Ambiente> estados = controlador.getEstados_Ambiente();
//Creo un estadoAmbiente para usar luego en el loop while de mas abajo
Estado_Ambiente estado;

%>
<p><h2>Ambiente a Modificar</h2></p>

<form action="Ambiente_Modificar_Estado3.jsp?id=<%=ambiente.getId()%>" method="POST">

    <p>Nombre<br><%=ambiente.getNombre()%></p>
<p>Descripción<br><%=ambiente.getDescripcion()%></p>
<p>Estado Ambiente<br>
    <select name="estado" id="estado">
        <option><%=ambiente.getEstado_ambiente().getNombre()%></option>
        <%
        Iterator iter = estados.iterator();
        while(iter.hasNext()){

        estado = (Estado_Ambiente) iter.next();

        //Si el sensor es el mismo que el actual no lo muestra
        if(estado.getNombre() != ambiente.getEstado_ambiente().getNombre()){
        out.println("<option>");
        out.println(estado.getNombre());
        out.println("</option>");
        }

        }
        %>
    </select>


<input type="submit">

</form>
    </body>
</html>
