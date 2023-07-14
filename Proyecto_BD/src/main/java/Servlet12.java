

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Productos;
import clases.ProductosModel;
import clases.Productos_Salidas_Cabecera;
import clases.Productos_Salidas_CabeceraModel;
import clases.Productos_Salidas_Detalle;
import clases.Productos_Salidas_DetalleModel;

/**
 * Servlet implementation class Servlet12
 */
@WebServlet("/Servlet12")
public class Servlet12 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet12() {
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
		Productos_Salidas_CabeceraModel Productos_Salidas_CabecerasModel = new Productos_Salidas_CabeceraModel();
		ProductosModel unidadModel = new ProductosModel();
		List<Productos> data2 = unidadModel.listSubject();
		List<Productos_Salidas_Cabecera> data = Productos_Salidas_CabecerasModel.listSubject();
		request.setAttribute("data", data);
		request.setAttribute("data2", data2);
		request.getRequestDispatcher("Productos_Salidas_Detalle.jsp").forward(request, response);
	}

/*	private void deleteSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idSubject = request.getParameter("id");
		Productos_Salidas_CabeceraModel Productos_Salidas_CabeceraModel = new Productos_Salidas_CabeceraModel();

		int subject = Productos_Salidas_CabeceraModel.delateSubject(idSubject);
		List<Productos_Salidas_Cabecera> data = Productos_Salidas_CabeceraModel.listSubject();
		request.setAttribute("data", data);
		request.getRequestDispatcher("listaProducto.jsp").forward(request, response);
	}
*/
	private void editSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int code = Integer.parseInt(request.getParameter("code"));
		int pro = Integer.parseInt(request.getParameter("pro"));
		int precio = Integer.parseInt(request.getParameter("precio"));
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		String estado = request.getParameter("estado");
		

		Productos_Salidas_Detalle subject = new Productos_Salidas_Detalle();
		subject.setSalCod(code);
		subject.setProCod(pro);
		subject.setProCan(cantidad);
		subject.setSalDetPreTot(precio);
		subject.setEntDetEstReg(estado);
		

		Productos_Salidas_DetalleModel clienteModel = new Productos_Salidas_DetalleModel();
		int rspt = clienteModel.updateSubject(subject);
		
		List<Productos_Salidas_Detalle> data = clienteModel.listSubject();
		
		request.setAttribute("data", data);
		listSubject(request, response);
	}

	protected void registerSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		int pro = Integer.parseInt(request.getParameter("pro"));
		int precio = Integer.parseInt(request.getParameter("precio"));
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		String estado = request.getParameter("estado");
		

		Productos_Salidas_Detalle subject = new Productos_Salidas_Detalle();
		subject.setSalCod(code);
		subject.setProCod(pro);
		subject.setProCan(cantidad);
		subject.setSalDetPreTot(precio);
		subject.setEntDetEstReg(estado);
		

		// Procesos

		Productos_Salidas_DetalleModel model = new Productos_Salidas_DetalleModel();
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
		Productos_Salidas_DetalleModel clienteModel = new Productos_Salidas_DetalleModel();

		
		Productos_Salidas_CabeceraModel Productos_Salidas_CabecerasModel = new Productos_Salidas_CabeceraModel();
		ProductosModel unidadModel = new ProductosModel();
		List<Productos_Salidas_Detalle> data = clienteModel.listSubject();
		List<Productos> data2 = unidadModel.listSubject();
		List<Productos_Salidas_Cabecera> data3 = Productos_Salidas_CabecerasModel.listSubject();
		request.setAttribute("data", data);
		request.setAttribute("data2", data2);
		request.setAttribute("data3", data3);
		request.getRequestDispatcher("listaProductos_Salidas_Detalle.jsp").forward(request, response);

	}

	protected void getSubject(HttpServletRequest request, HttpServletResponse response, String opcion)
			throws ServletException, IOException {
		String respuesta = "";
		String idSubject = request.getParameter("id");
		Productos_Salidas_DetalleModel productos_Salidas_DetalleModel = new Productos_Salidas_DetalleModel();
		Productos_Salidas_Detalle subject = productos_Salidas_DetalleModel.getSubject(idSubject);
		if(opcion.equals("info"))
			respuesta = subject.getEntDetEstReg();
		else if (opcion.equals ("reac"))
			respuesta = "A";
		else if (opcion.equals("inac"))
			respuesta = "I";
		else
			respuesta = "*";
		Productos_Salidas_CabeceraModel productos_Salidas_CabecerasModel = new Productos_Salidas_CabeceraModel();
		ProductosModel unidadModel = new ProductosModel();
		List<Productos_Salidas_Detalle> data = productos_Salidas_DetalleModel.listSubject();
		List<Productos> data2 = unidadModel.listSubject();
		List<Productos_Salidas_Cabecera> data3 = productos_Salidas_CabecerasModel.listSubject();
		request.setAttribute("subject", subject);
		request.setAttribute("data", data);
		request.setAttribute("data2", data2);
		request.setAttribute("data3", data3);
		request.setAttribute("type", opcion);
		request.setAttribute("respuesta", respuesta);
		request.getRequestDispatcher("EditarProductos_Salidas_Detalle.jsp").forward(request, response);
	}

}
