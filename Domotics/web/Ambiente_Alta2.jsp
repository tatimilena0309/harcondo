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



                        <%@ page import="java.util.*" %>

                        <%@ page import="org.apache.commons.fileupload.*" %>

                        <%@ page import="org.apache.commons.fileupload.disk.*" %>

                        <%@ page import="org.apache.commons.fileupload.servlet.*" %>

                        <%@ page import="org.apache.commons.io.*" %>

                        <%@ page import="java.io.*" %>



                        <%

                        //seteamos variable para control de archivo
                            boolean control_upload = true;

                        //variable de ruta de mensaje
                            String ruta_mensaje = null;
                            try {
                                /*FileItemFactory es una interfaz para crear FileItem*/

                                FileItemFactory file_factory = new DiskFileItemFactory();



                                /*ServletFileUpload esta clase convierte los input file a FileItem*/

                                ServletFileUpload servlet_up = new ServletFileUpload(file_factory);

                                /*sacando los FileItem del ServletFileUpload en una lista */

                                List items = servlet_up.parseRequest(request);



                                for (int i = 0; i < items.size(); i++) {

                                    /*FileItem representa un archivo en memoria que puede ser pasado al disco duro*/

                                    FileItem item = (FileItem) items.get(i);

                                    /*item.isFormField() false=input file; true=text field*/

                                    if (!item.isFormField()) {

                                        /*cual sera la ruta al archivo en el servidor*/

                                        File archivo_server = new File("c:/tmp/" + item.getName());

                                        /*y lo escribimos en el servido*/

                                        item.write(archivo_server);

                                        out.print("Nombre --> " + item.getName());

                                        out.print("<br> Tipo --> " + item.getContentType());

                                        out.print("<br> tamaño --> " + (item.getSize() / 1240) + "KB");

                                        out.print("<br>");
                                        ruta_mensaje = archivo_server.getAbsolutePath();
                                    }

                                }
                            } catch (Exception ex) {
                                out.println("Error al cargar el archivo:  " + ex.getMessage());
                                control_upload = false;
                            }
                        %>




                        <%

                            Controlador_Ambiente controlador = new Controlador_Ambiente();

                            Ambiente ambiente = controlador.Alta_Ambiente(request.getParameter("ambiente"), request.getParameter("desc_ambiente"), request.getParameter("nro_sensor"), ruta_mensaje, request.getParameter("actualizacion"));


                        %>

                        <p>
                            <%
                                if (ambiente != null) {
                            %>

                            El Ambiente "<%=ambiente.getNombre()%>" fue dado de alta con exito!
                            <%
                            } else {
                            %>
                            Falla en el alta!
                            <%    }
                            %>
                        </p>

                        </div>
                        </div>
                        </div>

                        <%@include file="pie.jsp" %>