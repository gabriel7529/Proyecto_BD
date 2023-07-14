

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Productos_Entradas_Cabecera;
import clases.Productos_Entradas_CabeceraModel;
import clases.Productos_Entradas_Detalle;
import clases.Productos_Entradas_DetalleModel;
import clases.Productos;
import clases.ProductosModel;

/**
 * Servlet implementation class Servlet10
 */
@WebServlet("/Servlet10")
public class Servlet10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet10() {
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
		Productos_Entradas_CabeceraModel Productos_Entradas_CabecerasModel = new Productos_Entradas_CabeceraModel();
		ProductosModel unidadModel = new ProductosModel();
		List<Productos> data = unidadModel.listSubject();
		List<Productos_Entradas_Cabecera> data2 = Productos_Entradas_CabecerasModel.listSubject();
		request.setAttribute("data", data);
		request.setAttribute("data2", data2);
		request.getRequestDispatcher("Productos_Entrada_Detalle.jsp").forward(request, response);
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
		int pro = Integer.parseInt(request.getParameter("pro"));
		int cabCod = Integer.parseInt(request.getParameter("cabCod"));
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		String estado = request.getParameter("estado");
		

		Productos_Entradas_Detalle subject = new Productos_Entradas_Detalle();
		subject.setEntDetCod(code);
		subject.setProCod(pro);
		subject.setEntCabCod(cabCod);
		subject.setEntCabCod(cabCod);
		subject.setProCan(cantidad);
		subject.setEntDetEstReg(estado);
		

		Productos_Entradas_DetalleModel clienteModel = new Productos_Entradas_DetalleModel();
		int rspt = clienteModel.updateSubject(subject);
		
		List<Productos_Entradas_Detalle> data = clienteModel.listSubject();
		
		request.setAttribute("data", data);
		listSubject(request, response);
	}

	protected void registerSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		int pro = Integer.parseInt(request.getParameter("pro"));
		int cabCod = Integer.parseInt(request.getParameter("cabCod"));
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		String estado = request.getParameter("estado");
		
		

		Productos_Entradas_Detalle subject = new Productos_Entradas_Detalle();
		subject.setEntDetCod(code);
		subject.setProCod(pro);
		subject.setEntCabCod(cabCod);
		subject.setProCan(cantidad);
		subject.setEntDetEstReg(estado);
		

		// Procesos

		Productos_Entradas_DetalleModel model = new Productos_Entradas_DetalleModel();
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
		Productos_Entradas_DetalleModel clienteModel = new Productos_Entradas_DetalleModel();

		
		Productos_Entradas_CabeceraModel Productos_Entradas_CabecerasModel = new Productos_Entradas_CabeceraModel();
		ProductosModel unidadModel = new ProductosModel();
		List<Productos_Entradas_Detalle> data = clienteModel.listSubject();
		List<Productos> data2 = unidadModel.listSubject();
		List<Productos_Entradas_Cabecera> data3 = Productos_Entradas_CabecerasModel.listSubject();
		request.setAttribute("data", data);
		request.setAttribute("data2", data2);
		request.setAttribute("data3", data3);
		request.getRequestDispatcher("listaProductos_Entradas_Detalle.jsp").forward(request, response);

	}

	protected void getSubject(HttpServletRequest request, HttpServletResponse response, String opcion)
			throws ServletException, IOException {
		String respuesta = "";
		String idSubject = request.getParameter("id");
		Productos_Entradas_DetalleModel productos_Entradas_DetalleModel = new Productos_Entradas_DetalleModel();
		Productos_Entradas_Detalle subject = productos_Entradas_DetalleModel.getSubject(idSubject);
		System.out.println(opcion);
		if(opcion.equals("info"))
			respuesta = subject.getEntDetEstReg();
		else if (opcion.equals ("reac"))
			respuesta = "A";
		else if (opcion.equals("inac"))
			respuesta = "I";
		else
			respuesta = "*";
		Productos_Entradas_CabeceraModel productos_Entradas_CabecerasModel = new Productos_Entradas_CabeceraModel();
		ProductosModel unidadModel = new ProductosModel();
		List<Productos_Entradas_Detalle> data = productos_Entradas_DetalleModel.listSubject();
		List<Productos> data2 = unidadModel.listSubject();
		List<Productos_Entradas_Cabecera> data3 = productos_Entradas_CabecerasModel.listSubject();
		request.setAttribute("subject", subject);
		request.setAttribute("data", data);
		request.setAttribute("data2", data2);
		request.setAttribute("data3", data3);
		request.setAttribute("type", opcion);
		request.setAttribute("respuesta", respuesta);
		request.getRequestDispatcher("EditarProductos_Entradas_Detalle.jsp").forward(request, response);
	}

}
