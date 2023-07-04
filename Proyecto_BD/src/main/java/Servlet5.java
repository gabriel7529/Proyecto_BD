

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.RubroProveedor;
import clases.RubroProveedorModel;

/**
 * Servlet implementation class Servlet5
 */
@WebServlet("/Servlet5")
public class Servlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");

		switch (type) {
		case "list":
			listSubject(request, response);
			break;
		case "register":
			registerSubject(request, response);
			break;
		case "edit":
			editSubject(request, response);
			break;
		case "delete":
			getSubject(request, response, type);
			break;
		case "info":
			getSubject(request, response, type);
			break;
		case "reac":
			getSubject(request, response, type);
			break;
		case "inac":
			getSubject(request, response, type);
			break;
		default:
			request.setAttribute("mensaje", "Ocurrió un problema");
		}
	}

/*	private void deleteSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idSubject = request.getParameter("id");
		RubroProveedorModel unidadModel = new RubroProveedorModel();

		int subject = unidadModel.delateSubject(idSubject);
		List<RubroProveedor> data = unidadModel.listSubject();
		request.setAttribute("data", data);
		request.getRequestDispatcher("listaUnidad.jsp").forward(request, response);
	}
*/
	private void editSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int code = Integer.parseInt(request.getParameter("code"));
		String name = request.getParameter("name");
		String estado = request.getParameter("estado");

		RubroProveedor subject = new RubroProveedor();
		subject.setRubProCod(code);
		subject.setRubNom(name);
		subject.setRubEstReg(estado);

		RubroProveedorModel unidadModel = new RubroProveedorModel();
		int rspt = unidadModel.updateSubject(subject);
		List<RubroProveedor> data = unidadModel.listSubject();
		request.setAttribute("data", data);
		request.getRequestDispatcher("listaRubroProveedor.jsp").forward(request, response);
	}

	protected void registerSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		String name = request.getParameter("name");
		String estado = request.getParameter("estado");

		RubroProveedor subject = new RubroProveedor();
		subject.setRubProCod(code);
		subject.setRubNom(name);
		subject.setRubEstReg(estado);

		RubroProveedorModel model = new RubroProveedorModel();
		int value = model.createSubject(subject);

		if (value == 1) {
			listSubject(request, response);
		} else {
			request.setAttribute("mensaje", "Ocurrio");
			listSubject(request, response);

		}
	}

	protected void listSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RubroProveedorModel unidadModel = new RubroProveedorModel();

		List<RubroProveedor> data = unidadModel.listSubject();
		request.setAttribute("data", data);
		request.getRequestDispatcher("listaRubroProveedor.jsp").forward(request, response);

	}

	protected void getSubject(HttpServletRequest request, HttpServletResponse response, String opcion)
			throws ServletException, IOException {
		String respuesta;
		String idSubject = request.getParameter("id");
		
		RubroProveedorModel rubroModel = new RubroProveedorModel();
		RubroProveedor subject = rubroModel.getSubject(idSubject);
		if(opcion.equals("info"))
			respuesta = subject.getRubEstReg();
		else if (opcion.equals ("reac"))
			respuesta = "A";
		else if (opcion.equals("inac"))
			respuesta = "I";
		else
			respuesta = "*";
		
		List<RubroProveedor> data = rubroModel.listSubject();
		request.setAttribute("subject", subject);
		request.setAttribute("type", opcion);
		request.setAttribute("respuesta", respuesta);
		request.getRequestDispatcher("EditarRubroProveedor.jsp").forward(request, response);
	}

}
