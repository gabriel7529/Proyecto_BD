

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import clases.Unidad_Medida;
import clases.Unidad_MedidaModel;

/**
 * Servlet implementation class Servlet4
 */
@WebServlet("/Servlet4")
public class Servlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet4() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			deleteSubject(request, response);
			break;
		case "info":
			getSubject(request, response);
			break;
		default:
			request.setAttribute("mensaje", "Ocurrió un problema");
		}
	}

	private void deleteSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idSubject = request.getParameter("id");
		Unidad_MedidaModel unidadModel = new Unidad_MedidaModel();

		int subject = unidadModel.delateSubject(idSubject);
		List<Unidad_Medida> data = unidadModel.listSubject();
		request.setAttribute("data", data);
		request.getRequestDispatcher("listaUnidad.jsp").forward(request, response);
	}

	private void editSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int code = Integer.parseInt(request.getParameter("code"));
		String name = request.getParameter("name");

		Unidad_Medida subject = new Unidad_Medida();
		subject.setUniMedCod(code);
		subject.setUniMedNom(name);

		Unidad_MedidaModel unidadModel = new Unidad_MedidaModel();
		int rspt = unidadModel.updateSubject(subject);
		List<Unidad_Medida> data = unidadModel.listSubject();
		request.setAttribute("data", data);
		request.getRequestDispatcher("listaUnidad.jsp").forward(request, response);
	}

	protected void registerSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		String name = request.getParameter("name");

		Unidad_Medida subject = new Unidad_Medida();
		subject.setUniMedCod(code);
		subject.setUniMedNom(name);

		Unidad_MedidaModel model = new Unidad_MedidaModel();
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
		Unidad_MedidaModel unidadModel = new Unidad_MedidaModel();

		List<Unidad_Medida> data = unidadModel.listSubject();
		request.setAttribute("data", data);
		request.getRequestDispatcher("listaUnidad.jsp").forward(request, response);

	}

	protected void getSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idSubject = request.getParameter("id");
		Unidad_MedidaModel unidadModel = new Unidad_MedidaModel();
		Unidad_Medida subject = unidadModel.getSubject(idSubject);
		List<Unidad_Medida> data = unidadModel.listSubject();
		request.setAttribute("subject", subject);
		request.setAttribute("data", data);
		request.getRequestDispatcher("EditarUnidad.jsp").forward(request, response);
	}

}
