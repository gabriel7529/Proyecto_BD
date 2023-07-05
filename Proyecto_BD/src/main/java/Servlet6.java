

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Almacenes;
import clases.AlmacenesModel;

/**
 * Servlet implementation class Servlet6
 */
@WebServlet("/Servlet6")
public class Servlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet6() {
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
		AlmacenesModel unidadModel = new AlmacenesModel();

		int subject = unidadModel.delateSubject(idSubject);
		List<Almacenes> data = unidadModel.listSubject();
		request.setAttribute("data", data);
		request.getRequestDispatcher("listaUnidad.jsp").forward(request, response);
	}
*/
	private void editSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int code = Integer.parseInt(request.getParameter("code"));
		String dir = request.getParameter("dir");
		String estado = request.getParameter("estado");

		Almacenes subject = new Almacenes();
		subject.setAlmNum(code);
		subject.setAlmDir(dir);
		subject.setAlmEstReg(estado);

		AlmacenesModel unidadModel = new AlmacenesModel();
		int rspt = unidadModel.updateSubject(subject);
		List<Almacenes> data = unidadModel.listSubject();
		request.setAttribute("data", data);
		request.getRequestDispatcher("listaAlmacenes.jsp").forward(request, response);
	}

	protected void registerSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		String dir = request.getParameter("dir");
		String estado = request.getParameter("estado");

		Almacenes subject = new Almacenes();
		subject.setAlmNum(code);
		subject.setAlmDir(dir);
		subject.setAlmEstReg(estado);

		AlmacenesModel model = new AlmacenesModel();
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
		AlmacenesModel unidadModel = new AlmacenesModel();

		List<Almacenes> data = unidadModel.listSubject();
		request.setAttribute("data", data);
		request.getRequestDispatcher("listaAlmacenes.jsp").forward(request, response);

	}

	protected void getSubject(HttpServletRequest request, HttpServletResponse response, String opcion)
			throws ServletException, IOException {
		String respuesta;
		String idSubject = request.getParameter("id");
		
		AlmacenesModel almacenModel = new AlmacenesModel();
		Almacenes subject = almacenModel.getSubject(idSubject);
		if(opcion.equals("info"))
			respuesta = subject.getAlmEstReg();
		else if (opcion.equals ("reac"))
			respuesta = "A";
		else if (opcion.equals("inac"))
			respuesta = "I";
		else
			respuesta = "*";
		
//		List<Almacenes> data = almacenModel.listSubject();
		request.setAttribute("subject", subject);
		request.setAttribute("type", opcion);
		request.setAttribute("respuesta", respuesta);
		request.getRequestDispatcher("EditarAlmacenes.jsp").forward(request, response);
	}

}
