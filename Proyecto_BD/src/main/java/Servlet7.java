

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Almacenes;
import clases.Categoria;
import clases.CategoriaModel;
import clases.Estantes;
import clases.EstantesModel;
import clases.Unidad_Medida;
import clases.Unidad_MedidaModel;
import clases.AlmacenesModel;

/**
 * Servlet implementation class Servlet7
 */
@WebServlet("/Servlet7")
public class Servlet7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet7() {
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
		case "inicio":
			initSubject(request, response);
			break;
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

	private void initSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AlmacenesModel almacenesModel = new AlmacenesModel();
		
		List<Almacenes> data = almacenesModel.listSubject();
		
		request.setAttribute("data", data);
		request.getRequestDispatcher("Estante.jsp").forward(request, response);
	}

/*	private void deleteSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idSubject = request.getParameter("id");
		EstantesModel EstantesModel = new EstantesModel();

		int subject = EstantesModel.delateSubject(idSubject);
		List<Estantes> data = EstantesModel.listSubject();
		request.setAttribute("data", data);
		request.getRequestDispatcher("listaProducto.jsp").forward(request, response);
	}
*/
	private void editSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int code = Integer.parseInt(request.getParameter("code"));
		int codeAlm = Integer.parseInt(request.getParameter("alm"));
		int capacidad = Integer.parseInt(request.getParameter("cap"));
		String estado = request.getParameter("estado");
		

		Estantes subject = new Estantes();
		subject.setEstNum(code);
		subject.setAlmNum(codeAlm);
		subject.setEstCap(capacidad);
		subject.setEstReg(estado);
		

		EstantesModel estanteModel = new EstantesModel();
		int rspt = estanteModel.updateSubject(subject);
		
		List<Estantes> data = estanteModel.listSubject();
		
		request.setAttribute("data", data);
		listSubject(request, response);
	}

	protected void registerSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		int codeAlm = Integer.parseInt(request.getParameter("alm"));
		int capacidad = Integer.parseInt(request.getParameter("cap"));
		String estado = request.getParameter("estado");
		

		Estantes subject = new Estantes();
		subject.setEstNum(code);
		subject.setAlmNum(codeAlm);
		subject.setEstCap(capacidad);
		subject.setEstReg(estado);

		// Procesos

		EstantesModel model = new EstantesModel();
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
		EstantesModel clienteModel = new EstantesModel();

		
		AlmacenesModel almacenesModel = new AlmacenesModel();
	
		List<Estantes> data = clienteModel.listSubject();
		List<Almacenes> data2 = almacenesModel.listSubject();
		
		request.setAttribute("data", data);
		request.setAttribute("data2", data2);
		
		request.getRequestDispatcher("listaEstante.jsp").forward(request, response);

	}

	protected void getSubject(HttpServletRequest request, HttpServletResponse response, String opcion)
			throws ServletException, IOException {
		String respuesta = "";
		String idSubject = request.getParameter("id");
		EstantesModel EstantesModel = new EstantesModel();
		Estantes subject = EstantesModel.getSubject(idSubject);
		if(opcion.equals("info"))
			respuesta = subject.getEstReg();
		else if (opcion.equals ("reac"))
			respuesta = "A";
		else if (opcion.equals("inac"))
			respuesta = "I";
		else
			respuesta = "*";
		AlmacenesModel categoriasModel = new AlmacenesModel();
		
		List<Estantes> data = EstantesModel.listSubject();
		List<Almacenes> data2 = categoriasModel.listSubject();
		request.setAttribute("subject", subject);
		request.setAttribute("data", data);
		request.setAttribute("data2", data2);
		request.setAttribute("type", opcion);
		request.setAttribute("respuesta", respuesta);
		request.getRequestDispatcher("EditarEstante.jsp").forward(request, response);
	}
}

