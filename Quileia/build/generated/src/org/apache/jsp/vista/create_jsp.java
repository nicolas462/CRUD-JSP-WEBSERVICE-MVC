package org.apache.jsp.vista;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.DecimalFormat;
import PModelo.Medico;
import PModelo.CRUDMedico;

public final class create_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <!-- Required meta tags -->\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("        <!-- Bootstrap CSS -->\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0\" crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"/Quileia/css/styles.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <title>Ingresar Médico</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light\" style=\"background-color: #e3f2fd;\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <a class=\"navbar-brand\" href=\"/Quileia/index.jsp\">Navbar</a>\n");
      out.write("                <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarTogglerDemo02\" aria-controls=\"navbarTogglerDemo02\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                </button>\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"navbarTogglerDemo02\">\n");
      out.write("                    <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link active\" aria-current=\"page\" href=\"#\">Home</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"#\">Link</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link disabled\" href=\"#\" tabindex=\"-1\" aria-disabled=\"true\">Disabled</a>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class =\"container\">\n");
      out.write("            <div class=\"row head\">\n");
      out.write("                <div class=\"col\"><h3>Añadir Médico</h3></div>\n");
      out.write("            </div>\n");
      out.write("            <hr>\n");
      out.write("            <!-- form -->\n");
      out.write("            <form class=\"row g-3 needs-validation\" novalidate>\n");
      out.write("                <div class=\"col-md-7\">\n");
      out.write("                    <input type=\"hidden\" name=\"medicoId\" value=\"\">\n");
      out.write("                    <label class=\"form-label\">Nombre Completo</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"nombreMedico\" value=\"\" placeholder=\"Nombres y Apellidos\" required>\n");
      out.write("                    <div class=\"invalid-feedback\">\n");
      out.write("                            Ingrese un nombre válido.\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-3\">\n");
      out.write("                    <label class=\"form-label\">Número de identificacion</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"identificacionMedico\" placeholder=\"51955221\" value=\"\" required>\n");
      out.write("                    <div class=\"invalid-feedback\">\n");
      out.write("                            Ingrese una identificacion válida.\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-2\">\n");
      out.write("                    <label class=\"form-label\">Tipo identificación</label>\n");
      out.write("                    <select class=\"form-select\" name=\"tipoIDMedico\" required>\n");
      out.write("                        <option selected disabled value=\"\">Selecciona...</option>\n");
      out.write("                        <option value=\"CC\">CC</option>\n");
      out.write("                        <option value=\"CE\">CE</option>\n");
      out.write("                    </select>\n");
      out.write("                    <div class=\"invalid-feedback\">\n");
      out.write("                        Ingrese una tipo de identificacion válido.\n");
      out.write("                    </div>\n");
      out.write("                </div>                \n");
      out.write("                    <div class=\"col-md-6\">\n");
      out.write("                    <label class=\"form-label\">Especialización</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"especializacionMedico\" value=\"\" placeholder=\"Cirugía, Dermatología, ...\" required>\n");
      out.write("                    <div class=\"invalid-feedback\">\n");
      out.write("                            Ingrese una especialización válida.\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-3\">\n");
      out.write("                    <label class=\"form-label\">Número Tarjeta Profesional</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"tarjetaProfesionalMedico\" placeholder=\"218066-E\" value=\"\" required>\n");
      out.write("                    <div class=\"invalid-feedback\">\n");
      out.write("                            Ingrese una tarjeta profesional válida.\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-3\">\n");
      out.write("                    <label class=\"form-label\">Años de experiencia</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"anosExpMedico\" placeholder=\"1.2\" value=\"\" required>\n");
      out.write("                    </select>\n");
      out.write("                    <div class=\"invalid-feedback\">\n");
      out.write("                        Ingrese años válidos.\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md\"></div>\n");
      out.write("                <div class=\"col-md-3\">\n");
      out.write("                    <label class=\"form-label\">Hora Inicio Atención</label>\n");
      out.write("                    <div class=\"input-group\">\n");
      out.write("                        <select class=\"scheduleSelect form-select form-label\" name=\"horaInicioMedico\" required>\n");
      out.write("                            <option selected disabled value=\"\">...</option>\n");
      out.write("                        </select>\n");
      out.write("                        <label style=\"margin:    0 10px 0 10px\">:</label>\n");
      out.write("                        <select class=\"scheduleSelect form-select form-label\" name=\"minutosInicioMedico\" required>\n");
      out.write("                            <option selected disabled value=\"\">...</option>\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-3\">\n");
      out.write("                    <label class=\"form-label\">Hora Fin Atención</label>\n");
      out.write("                    <div class=\"input-group\">\n");
      out.write("                        <select class=\"scheduleSelect form-select form-label\" name=\"horaFinMedico\" required>\n");
      out.write("                            <option selected disabled value=\"\">...</option>\n");
      out.write("                        </select>\n");
      out.write("                        <label style=\"margin:    0 10px 0 10px\">:</label>\n");
      out.write("                        <select class=\"scheduleSelect form-select form-label\" name=\"minutosFinMedico\" required>\n");
      out.write("                            <option selected disabled value=\"\">...</option>\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md\"></div>\n");
      out.write("                \n");
      out.write("                <div class=\"col-12 text-center\">\n");
      out.write("                    <input class=\"btn btn-primary\" type=\"submit\" name=\"action\" value=\"Agregar\" text>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("            <!-- end form -->\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"/Quileia/js/scripts.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
