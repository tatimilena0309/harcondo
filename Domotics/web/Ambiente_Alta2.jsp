<%-- 
    Document   : Ambiente_Alta2
    Created on : 13/09/2012, 21:35:34
    Author     : LEO
--%>



<%@include file="cabecera.jsp" %>
<div class="clearfix grpelem" id="pu1676-6"><!-- group -->
    
    <div class="grpelem" id="u1268" ><!-- content -->
        <div class="domotics">
 <h1><b>Alta Ambiente<b></h1>
        

<%@page import="Negocio.Ambiente"%>
<%@page import="Ambientes.Controlador_Ambiente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

    Controlador_Ambiente controlador = new Controlador_Ambiente();
    
    Ambiente ambiente = controlador.Alta_Ambiente(request.getParameter("ambiente"), request.getParameter("desc_ambiente"), request.getParameter("nro_sensor"), request.getParameter("mensaje_ingreso"), request.getParameter("actualizacion"));


%>

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

        </div>
        </div>
</div>

<%@include file="pie.jsp" %>