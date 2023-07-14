

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Estantes;
import clases.EstantesModel;
import clases.Productos_Entradas_Cabecera;
import clases.Productos_Entradas_CabeceraModel;
import clases.Proveedores;
import clases.ProveedoresModel;

/**
 * Servlet implementation class Servlet9
 */
@WebServlet("/Servlet9")
public class Servlet9 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet9() {
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
		EstantesModel EstantessModel = new EstantesModel();
		ProveedoresModel unidadModel = new ProveedoresModel();
		List<Proveedores> data = unidadModel.listSubject();
		List<Estantes> data2 = EstantessModel.listSubject();
		request.setAttribute("data", data);
		request.setAttribute("data2", data2);
		request.getRequestDispatcher("Productos_Entrada_Cabecera.jsp").forward(request, response);
	}

/*	private void deleteSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idSubject = request.getParameter("id");
		Productos_Entradas_CabeceraModel Productos_Entradas_CabeceraModel = new Productos_Entradas_CabeceraModel();

		int subject = Productos_Entradas_CabeceraModel.delateSubject(idSubject);
		List<Productos_Entradas_Cabecera> data = Productos_Entradas_CabeceraModel.listSubject();
		request.setAttribute("data", data);
		request.getRequestDispatcher("listaProducto.jsp").forward(request, response);
	}
*/
	private void editSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int code = Integer.parseInt(request.getParameter("code"));
		int prov = Integer.parseInt(request.getParameter("prov"));
		int est = Integer.parseInt(request.getParameter("est"));
		String ano = request.getParameter("ano");
		String mes = request.getParameter("mes");
		String dia = request.getParameter("dia");
		String estado = request.getParameter("estado");
		

		Productos_Entradas_Cabecera subject = new Productos_Entradas_Cabecera();
		subject.setEntCabCod(code);
		subject.setPrvCod(prov);
		subject.setEstNum(est);
		subject.setEntcabfecAno(ano);
		subject.setEntcabfecMes(mes);
		subject.setEntcabfecDia(dia);
		subject.setEntcabestReg(estado);
		

		Productos_Entradas_CabeceraModel clienteModel = new Productos_Entradas_CabeceraModel();
		int rspt = clienteModel.updateSubject(subject);
		
		List<Productos_Entradas_Cabecera> data = clienteModel.listSubject();
		
		request.setAttribute("data", data);
		listSubject(request, response);
	}

	protected void registerSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		int prov = Integer.parseInt(request.getParameter("prov"));
		int est = Integer.parseInt(request.getParameter("est"));
		String ano = request.getParameter("ano");
		String mes = request.getParameter("mes");
		String dia = request.getParameter("dia");
		String estado = request.getParameter("estado");
		

		Productos_Entradas_Cabecera subject = new Productos_Entradas_Cabecera();
		subject.setEntCabCod(code);
		subject.setPrvCod(prov);
		subject.setEstNum(est);
		subject.setEntcabfecAno(ano);
		subject.setEntcabfecMes(mes);
		subject.setEntcabfecDia(dia);
		subject.setEntcabestReg(estado);
		

		// Procesos

		Productos_Entradas_CabeceraModel model = new Productos_Entradas_CabeceraModel();
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
		Productos_Entradas_CabeceraModel clienteModel = new Productos_Entradas_CabeceraModel();

		
		EstantesModel EstantessModel = new EstantesModel();
		ProveedoresModel unidadModel = new ProveedoresModel();
		List<Productos_Entradas_Cabecera> data = clienteModel.listSubject();
		List<Proveedores> data2 = unidadModel.listSubject();
		List<Estantes> data3 = EstantessModel.listSubject();
		request.setAttribute("data", data);
		request.setAttribute("data2", data2);
		request.setAttribute("data3", data3);
		request.getRequestDispatcher("listaProductos_Entradas_Cabecera.jsp").forward(request, response);

	}

	protected void getSubject(HttpServletRequest request, HttpServletResponse response, String opcion)
			throws ServletException, IOException {
		String respuesta = "";
		String idSubject = request.getParameter("id");
		Productos_Entradas_CabeceraModel Productos_Entradas_CabeceraModel = new Productos_Entradas_CabeceraModel();
		Productos_Entradas_Cabecera subject = Productos_Entradas_CabeceraModel.getSubject(idSubject);
		if(opcion.equals("info"))
			respuesta = subject.getEntcabestReg();
		else if (opcion.equals ("reac"))
			respuesta = "A";
		else if (opcion.equals("inac"))
			respuesta = "I";
		else
			respuesta = "*";
		EstantesModel EstantessModel = new EstantesModel();
		ProveedoresModel unidadModel = new ProveedoresModel();
		List<Productos_Entradas_Cabecera> data = Productos_Entradas_CabeceraModel.listSubject();
		List<Proveedores> data2 = unidadModel.listSubject();
		List<Estantes> data3 = EstantessModel.listSubject();
		request.setAttribute("subject", subject);
		request.setAttribute("data", data);
		request.setAttribute("data2", data2);
		request.setAttribute("data3", data3);
		request.setAttribute("type", opcion);
		request.setAttribute("respuesta", respuesta);
		request.getRequestDispatcher("EditarProductos_Entradas_Cabecera.jsp").forward(request, response);
	}
}
