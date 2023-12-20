package org.example.dynamicwebproject.controlador;

import org.example.dynamicwebproject.modelo.GestorOperador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "formOperacion", value = "/formOperacion")
public class ServletRealizarOperaciones extends HttpServlet {
    private GestorOperador gestor;

    public void init() {
        gestor = new GestorOperador();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Realizar Operaciones</title>\n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"container\">\n" +
                "    <div class=\"row justify-content-md-center\">\n" +
                "        <div class=\"col-md-auto\">\n" +
                "\n" +
                "            <strong><h1>\"Operaciones a realizar...\"</h1></strong>\n" +
                "\n" +
                "            <form action=\"ServletResultadoOperacion\" method=\"post\">\n" +
                "                <div class=\"mb-3\">\n" +
                "                    <label for=\"operacion\" class=\"form-label\">Operaciones</label>\n" +
                "                    <select name=\"operacion\" id=\"operacion\" class=\"form-select\">\n" +
                "                        <option value=\"suma\">Suma</option>\n" +
                "                        <option value=\"resta\">Resta</option>\n" +
                "                        <option value=\"producto\">Producto</option>\n" +
                "                        <option value=\"division\">División</option>\n" +
                "                    </select>\n" +
                "                </div>\n" +
                "\n" +
                "                <div class=\"mb-3\">\n" +
                "                    <label for=\"primerNumero\" class=\"form-label\">Primer Número</label>\n" +
                "                    <input type=\"number\" name=\"primerNumero\" id=\"primerNumero\" class=\"form-control\" placeholder=\"Ingrese el primer número\">\n" +
                "                </div>\n" +
                "\n" +
                "                <div class=\"mb-3\">\n" +
                "                    <label for=\"segundoNumero\" class=\"form-label\">Segundo Número</label>\n" +
                "                    <input type=\"number\" name=\"segundoNumero\" id=\"segundoNumero\" class=\"form-control\" placeholder=\"Ingrese el segundo número\">\n" +
                "                </div>\n" +
                "\n" +
                "                <button type=\"submit\" class=\"btn btn-primary\">Enviar Datos</button>\n" +
                "                <button type=\"reset\" class=\"btn btn-secondary\">Borrar Datos</button>\n" +
                "            </form>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>\n" +
                "</body>");
    }

    public void destroy() {
        gestor.cierraGestor();
    }
}