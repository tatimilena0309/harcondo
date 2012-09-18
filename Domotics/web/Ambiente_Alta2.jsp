<%-- 
    Document   : Ambiente_Alta2
    Created on : 13/09/2012, 21:35:34
    Author     : LEO
--%>

<%@page import="Negocio.Ambiente"%>
<%@page import="Ambientes.Controlador_Ambiente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

    Controlador_Ambiente controlador = new Controlador_Ambiente();
    
    Ambiente ambiente = controlador.Alta_Ambiente(request.getParameter("ambiente"), request.getParameter("desc_ambiente"), request.getParameter("nro_sensor"), request.getParameter("mensaje_ingreso"), request.getParameter("actualizacion"));


%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta Ambiente</title>
    </head>
    <body>
        <h1>Alta Ambiente</h1>
         <p>
<%
 if(ambiente != null){
%>

            El Ambiente "<%=ambiente.getNombre()%>" fue dado de alta con exito!
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