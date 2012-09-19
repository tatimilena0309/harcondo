<%-- 
    Document   : Ambiente_Baja
    Created on : 18-sep-2012, 21:18:12
    Author     : Leo
--%>

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
List<Ambiente> ambientes = controlador.getAmbientes();

%>
<p><h2>Seleccione Ambiente a Modificar Estado</h2></p>

<form action="Ambiente_Modificar_Estado2.jsp" method="POST">

<select name="ambiente" id="ambiente">
<%
Ambiente ambiente;
 Iterator iter = ambientes.iterator();
        while(iter.hasNext()){

        ambiente = (Ambiente) iter.next();

        out.println("<option>");
        out.println(ambiente.getNombre());
        out.println("</option>");

    }


%>
</select>
<br>
<input type="submit"  >
</form>
    </body>
</html>
