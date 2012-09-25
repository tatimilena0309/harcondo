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

<%@page import="java.util.Iterator"%>
<%@page import="Negocio.Ambiente"%>
<%@page import="java.util.List"%>
<%@page import="Ambientes.Controlador_Ambiente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">



<%

Controlador_Ambiente controlador = new Controlador_Ambiente();
List<Ambiente> ambientes = controlador.getAmbientes();

%>
<p><h2>Seleccione Ambiente a Modificar Estado</h2></p>
<br>
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
<br><br>
<input type="submit"  >
</form>
       </div>
        </div>
</div>
<%@include file="pie.jsp"%>