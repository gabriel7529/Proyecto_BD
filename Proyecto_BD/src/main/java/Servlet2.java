
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.*;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet2() {
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
		CategoriaModel categoriasModel = new CategoriaModel();
		Unidad_MedidaModel unidadModel = new Unidad_MedidaModel();
		List<Unidad_Medida> data = unidadModel.listSubject();
		List<Categoria> data2 = categoriasModel.listSubject();
		request.setAttribute("data", data);
		request.setAttribute("data2", data2);
		request.getRequestDispatcher("Producto.jsp").forward(request, response);
	}

/*	private void deleteSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idSubject = request.getParameter("id");
		ProductosModel productosModel = new ProductosModel();

		int subject = productosModel.delateSubject(idSubject);
		List<Productos> data = productosModel.listSubject();
		request.setAttribute("data", data);
		request.getRequestDispatcher("listaProducto.jsp").forward(request, response);
	}
*/
	private void editSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int code = Integer.parseInt(request.getParameter("code"));
		String name = request.getParameter("name");
		int uniMed = Integer.parseInt(request.getParameter("coduni"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		double precioVenta = Double.parseDouble(request.getParameter("preciov"));
		double precioCompra = Double.parseDouble(request.getParameter("precioc"));
		String estado = request.getParameter("estado");
		int cat = Integer.parseInt(request.getParameter("codcat"));

		Productos subject = new Productos();
		subject.setProCod(code);
		subject.setProNom(name);
		subject.setUniMedCod(uniMed);
		subject.setProSto(stock);
		subject.setProPreVen(precioVenta);
		subject.setProPreCom(precioCompra);
		subject.setProEstReg(estado);
		subject.setProCat(cat);
		

		ProductosModel clienteModel = new ProductosModel();
		int rspt = clienteModel.updateSubject(subject);
		
		List<Productos> data = clienteModel.listSubject();
		
		request.setAttribute("data", data);
		listSubject(request, response);
	}

	protected void registerSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		String name = request.getParameter("name");
		int uniMed = Integer.parseInt(request.getParameter("coduni"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		double precioVenta = Double.parseDouble(request.getParameter("preciov"));
		double precioCompra = Double.parseDouble(request.getParameter("precioc"));
		String estado = request.getParameter("estado");
		int cat = Integer.parseInt(request.getParameter("codcat"));

		Productos subject = new Productos();
		subject.setProCod(code);
		subject.setProNom(name);
		subject.setUniMedCod(uniMed);
		subject.setProSto(stock);
		subject.setProPreVen(precioVenta);
		subject.setProPreCom(precioCompra);
		subject.setProEstReg(estado);
		subject.setProCat(cat);

		// Procesos

		ProductosModel model = new ProductosModel();
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
		ProductosModel clienteModel = new ProductosModel();

		
		CategoriaModel categoriasModel = new CategoriaModel();
		Unidad_MedidaModel unidadModel = new Unidad_MedidaModel();
		List<Productos> data = clienteModel.listSubject();
		List<Unidad_Medida> data3 = unidadModel.listSubject();
		List<Categoria> data2 = categoriasModel.listSubject();
		request.setAttribute("data", data);
		request.setAttribute("data2", data2);
		request.setAttribute("data3", data3);
		request.getRequestDispatcher("listaProducto.jsp").forward(request, response);

	}

	protected void getSubject(HttpServletRequest request, HttpServletResponse response, String opcion)
			throws ServletException, IOException {
		String respuesta = "";
		String idSubject = request.getParameter("id");
		ProductosModel productosModel = new ProductosModel();
		Productos subject = productosModel.getSubject(idSubject);
		if(opcion.equals("info"))
			respuesta = subject.getProEstReg();
		else if (opcion.equals ("reac"))
			respuesta = "A";
		else if (opcion.equals("inac"))
			respuesta = "I";
		else
			respuesta = "*";
		CategoriaModel categoriasModel = new CategoriaModel();
		Unidad_MedidaModel unidadModel = new Unidad_MedidaModel();
		List<Productos> data = productosModel.listSubject();
		List<Unidad_Medida> data3 = unidadModel.listSubject();
		List<Categoria> data2 = categoriasModel.listSubject();
		request.setAttribute("subject", subject);
		request.setAttribute("data", data);
		request.setAttribute("data2", data2);
		request.setAttribute("data3", data3);
		request.setAttribute("type", opcion);
		request.setAttribute("respuesta", respuesta);
		request.getRequestDispatcher("EditarProducto.jsp").forward(request, response);
	}
}
