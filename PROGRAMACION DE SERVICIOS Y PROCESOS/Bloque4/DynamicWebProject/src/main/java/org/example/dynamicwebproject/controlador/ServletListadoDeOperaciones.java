package org.example.dynamicwebproject.controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "listado", value = "/listadoDeOperaciones")
public class ServletListadoDeOperaciones extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

//        out.println("<html><head>");
//        out.println("<title>Listado de Operaciones</title>");
//        out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3' crossorigin='anonymous'>");
//        out.println("</head><body>");
//
//        out.println("<div class='container'><div class='row justify-content-md-center'><div class='col-md-auto'>");
//        out.println("<h1>Listado de Operaciones</h1>");
//
//        out.println("<ul>");
//        out.println("<strong><li><a href='realizaOperaciones?operacion=division'>División</a></li></strong>");
//        out.println("<strong><li><a href='realizaOperaciones?operacion=resta'>Resta</a></li></strong>");
//        out.println("<strong><li><a href='realizaOperaciones?operacion=suma'>Suma</a></li></strong>");
//        out.println("<strong><li><a href='realizaOperaciones?operacion=producto'>Producto</a></li></strong>");
//        out.println("</ul>");
//
//        out.println("<a class='btn btn-primary' href='index.denis'>Volver al inicio</a>");
//        out.println("</div></div></div></body></html>");

        out.println("<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Listado de Operaciones</title>\n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"container\">\n" +
                "    <div class=\"row justify-content-md-center\">\n" +
                "        <div class=\"col-md-auto\">\n" +
                "\n" +
                "            <h1>Listado de Operaciones</h1>\n" +
                "\n" +
                "            <ul>\n" +
                "                <strong><li>División</li></strong>\n" +
                "                <strong><li>Resta</li></strong>\n" +
                "                <strong><li>Suma</li></strong>\n" +
                "                <strong><li>Producto</li></strong>\n" +
                "            </ul>\n" +
                "            \n" +
                "            <a href='index.jsp'>Volver al inicio</a>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");
    }
}