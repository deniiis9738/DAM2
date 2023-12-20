package org.example.dynamicwebproject.controlador;

import org.example.dynamicwebproject.modelo.GestorOperador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "listado", value = "/listadoDeOperaciones")
public class ServletListadoDeOperaciones extends HttpServlet {
    private GestorOperador gestor;

    public void init() {
        gestor = new GestorOperador();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String[] listadoOperaciones = gestor.listaDeOperaciones();

        PrintWriter out = response.getWriter();

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
                "\n");
        for (String operacion : listadoOperaciones) {
            out.println("            <ul>" +
                    "                <strong><li>" + operacion + "</li></strong>" +
                    "            </ul>");
        }
                out.println("            <a href='index.jsp'>Volver al inicio</a>\n" +
                        "        </div>\n" +
                        "    </div>\n" +
                        "</div>\n" +
                        "</body>\n" +
                        "</html>");
    }
}