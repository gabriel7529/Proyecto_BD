

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.RubroProveedor;
import clases.RubroProveedorModel;
import clases.Proveedores;
import clases.ProveedoresModel;

/**
 * Servlet implementation class Servlet8
 */
@WebServlet("/Servlet8")
public class Servlet8 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet8() {
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
		RubroProveedorModel RubroProveedorModel = new RubroProveedorModel();
		
		List<RubroProveedor> data = RubroProveedorModel.listSubject();
		
		request.setAttribute("data", data);
		request.getRequestDispatcher("Proveedores.jsp").forward(request, response);
	}

/*	private void deleteSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idSubject = request.getParameter("id");
		ProveedoresModel ProveedoresModel = new ProveedoresModel();

		int subject = ProveedoresModel.delateSubject(idSubject);
		List<Proveedores> data = ProveedoresModel.listSubject();
		request.setAttribute("data", data);
		request.getRequestDispatcher("listaProducto.jsp").forward(request, response);
	}
*/
	private void editSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int code = Integer.parseInt(request.getParameter("code"));
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String dir = request.getParameter("dir");
		int rub = Integer.parseInt(request.getParameter("rub"));
		String estado = request.getParameter("estado");
		

		Proveedores subject = new Proveedores();
		subject.setPrvCod(code);
		subject.setPrvNom(name);
		subject.setPrvTel(phone);
		subject.setProDir(dir);
		subject.setRubPrv(rub);
		subject.setPrvEstReg(estado);
		

		ProveedoresModel ProveedoreModel = new ProveedoresModel();
		int rspt = ProveedoreModel.updateSubject(subject);
	
		listSubject(request, response);
	}

	protected void registerSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String dir = request.getParameter("dir");
		int rub = Integer.parseInt(request.getParameter("rub"));
		String estado = request.getParameter("estado");
		

		Proveedores subject = new Proveedores();
		subject.setPrvCod(code);
		subject.setPrvNom(name);
		subject.setPrvTel(phone);
		subject.setProDir(dir);
		subject.setRubPrv(rub);
		subject.setPrvEstReg(estado);

		// Procesos

		ProveedoresModel model = new ProveedoresModel();
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
		ProveedoresModel clienteModel = new ProveedoresModel();

		
		RubroProveedorModel RubroProveedorModel = new RubroProveedorModel();
	
		List<Proveedores> data = clienteModel.listSubject();
		List<RubroProveedor> data2 = RubroProveedorModel.listSubject();
		
		request.setAttribute("data", data);
		request.setAttribute("data2", data2);
		
		request.getRequestDispatcher("listaProveedores.jsp").forward(request, response);

	}

	protected void getSubject(HttpServletRequest request, HttpServletResponse response, String opcion)
			throws ServletException, IOException {
		String respuesta = "";
		String idSubject = request.getParameter("id");
		ProveedoresModel ProveedoresModel = new ProveedoresModel();
		Proveedores subject = ProveedoresModel.getSubject(idSubject);
		if(opcion.equals("info"))
			respuesta = subject.getPrvEstReg();
		else if (opcion.equals ("reac"))
			respuesta = "A";
		else if (opcion.equals("inac"))
			respuesta = "I";
		else
			respuesta = "*";
		RubroProveedorModel categoriasModel = new RubroProveedorModel();
		
		
		List<RubroProveedor> data2 = categoriasModel.listSubject();
		request.setAttribute("subject", subject);
		request.setAttribute("data2", data2);
		request.setAttribute("type", opcion);
		request.setAttribute("respuesta", respuesta);
		request.getRequestDispatcher("EditarProveedor.jsp").forward(request, response);
	}

}
