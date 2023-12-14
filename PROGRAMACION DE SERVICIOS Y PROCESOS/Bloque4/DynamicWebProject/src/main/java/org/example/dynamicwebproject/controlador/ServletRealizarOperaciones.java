package org.example.dynamicwebproject.controlador;

import org.example.dynamicwebproject.modelo.GestorOperador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "realizaOperaciones", value = "/realizaOperaciones")
public class ServletRealizarOperaciones extends HttpServlet {
    private GestorOperador gestor;

    public void init() {
        gestor = new GestorOperador();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Recuperar parámetros del formulario
        String operacion = request.getParameter("operacion");
        double primerNumero = Double.parseDouble(request.getParameter("primerNumero"));
        double segundoNumero = Double.parseDouble(request.getParameter("segundoNumero"));

        // Realizar operaciones según la operación seleccionada
        String resultado = gestor.calculaRdo(operacion, primerNumero, segundoNumero);

        // Imprimir el resultado en la respuesta
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Resultado</title></head><body>");
        out.println("<h1>Resultado:</h1>");
        out.println("<p>El resultado de la operación " + operacion + " es: " + resultado + "</p>");
        out.println("<a class='btn btn-primary' href='index.html'>Volver al inicio</a>");
        out.println("</body></html>");
    }

    public void destroy() {
        gestor.cierraGestor();
    }
}
