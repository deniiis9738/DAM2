package org.example.dynamicwebproject.controlador;

import org.example.dynamicwebproject.modelo.GestorOperador;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletResultadoOperacion", value = "/ServletResultadoOperacion")
public class ServletResultadoOperacion extends HttpServlet {
    private GestorOperador gestor;

    public void init() {
        gestor = new GestorOperador();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String operacion = request.getParameter("operacion");
        double primerNumero = Double.parseDouble(request.getParameter("primerNumero"));
        double segundoNumero = Double.parseDouble(request.getParameter("segundoNumero"));

        // Realizar la operación utilizando el GestorOperador
        String resultado = gestor.calculaRdo(operacion, primerNumero, segundoNumero);
        String tipoOperacion = gestor.mostrarOperacion(operacion);

        // Check if the result contains a division by zero error
        boolean divisionByZeroError = resultado.contains("Error: División por cero");

        // Mostrar el resultado en una nueva página
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Resultado de la Operación</title>\n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\" crossorigin=\"anonymous\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"container\">\n" +
                "    <div class=\"row justify-content-md-center\">\n" +
                "        <div class=\"col-md-auto\">\n" +
                "            <h1>Resultado de la Operación</h1>\n");

        if (divisionByZeroError) {
            out.println("            <p style=\"color: red;\">Error: No se puede dividir por cero.</p>\n");
        } else {
            out.println("            <p>El resultado es: "+ tipoOperacion + " = " + resultado + "</p>\n");
        }

        out.println(
                "        </div>\n" +
                        "    </div>\n" +
                        "</div>\n" +
                        "</body>");
    }

    public void destroy() {
        gestor.cierraGestor();
    }
}