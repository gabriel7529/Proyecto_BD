

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import clases.Productos_Salidas_Cabecera;
import clases.Productos_Salidas_CabeceraModel;
import clases.Clientes;
import clases.ClienteModel;

/**
 * Servlet implementation class Servlet11
 */
@WebServlet("/Servlet11")
public class Servlet11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet11() {
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
		
		ClienteModel unidadModel = new ClienteModel();
		List<Clientes> data = unidadModel.listSubject();
		
		request.setAttribute("data", data);
		
		request.getRequestDispatcher("Productos_Salidas_Cabecera.jsp").forward(request, response);
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
		int cli = Integer.parseInt(request.getParameter("cli"));
		int total = Integer.parseInt(request.getParameter("total"));
		String ano = request.getParameter("ano");
		String mes = request.getParameter("mes");
		String dia = request.getParameter("dia");
		int pago = Integer.parseInt(request.getParameter("pago"));
		int igv = Integer.parseInt(request.getParameter("igv"));
		double importe = Double.parseDouble(request.getParameter("importe"));
		String estado = request.getParameter("estado");
		

		Productos_Salidas_Cabecera subject = new Productos_Salidas_Cabecera();
		subject.setSalCod(code);
		subject.setCliCod(cli);
		subject.setProPreTot(total);
		subject.setEntcabfecAno(ano);
		subject.setEntcabfecMes(mes);
		subject.setEntcabfecDia(dia);
		
		subject.setSalConPag(pago);
		subject.setSalIgv(igv);
		subject.setSalImpTot(importe);
		subject.setEntcabestReg(estado);
		

		Productos_Salidas_CabeceraModel clienteModel = new Productos_Salidas_CabeceraModel();
		int rspt = clienteModel.updateSubject(subject);
		
		List<Productos_Salidas_Cabecera> data = clienteModel.listSubject();
		
		request.setAttribute("data", data);
		listSubject(request, response);
	}

	protected void registerSubject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		int cli = Integer.parseInt(request.getParameter("cli"));
		int total = Integer.parseInt(request.getParameter("total"));
		String ano = request.getParameter("ano");
		String mes = request.getParameter("mes");
		String dia = request.getParameter("dia");
		int pago = Integer.parseInt(request.getParameter("pago"));
		int igv = Integer.parseInt(request.getParameter("igv"));
		double importe = Double.parseDouble(request.getParameter("importe"));
		String estado = request.getParameter("estado");
		

		Productos_Salidas_Cabecera subject = new Productos_Salidas_Cabecera();
		subject.setSalCod(code);
		subject.setCliCod(cli);
		subject.setProPreTot(total);
		subject.setEntcabfecAno(ano);
		subject.setEntcabfecMes(mes);
		subject.setEntcabfecDia(dia);
		
		subject.setSalConPag(pago);
		subject.setSalIgv(igv);
		subject.setSalImpTot(importe);
		subject.setEntcabestReg(estado);
		

		// Procesos

		Productos_Salidas_CabeceraModel model = new Productos_Salidas_CabeceraModel();
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
		Productos_Salidas_CabeceraModel clienteModel = new Productos_Salidas_CabeceraModel();

		
		
		ClienteModel unidadModel = new ClienteModel();
		List<Productos_Salidas_Cabecera> data = clienteModel.listSubject();
		List<Clientes> data2 = unidadModel.listSubject();
		
		request.setAttribute("data", data);
		request.setAttribute("data2", data2);
		
		request.getRequestDispatcher("listaProductos_Salidas_Cabecera.jsp").forward(request, response);

	}

	protected void getSubject(HttpServletRequest request, HttpServletResponse response, String opcion)
			throws ServletException, IOException {
		String respuesta = "";
		String idSubject = request.getParameter("id");
		Productos_Salidas_CabeceraModel Productos_Salidas_CabeceraModel = new Productos_Salidas_CabeceraModel();
		Productos_Salidas_Cabecera subject = Productos_Salidas_CabeceraModel.getSubject(idSubject);
		if(opcion.equals("info"))
			respuesta = subject.getEntcabestReg();
		else if (opcion.equals ("reac"))
			respuesta = "A";
		else if (opcion.equals("inac"))
			respuesta = "I";
		else
			respuesta = "*";
		
		ClienteModel unidadModel = new ClienteModel();
		List<Productos_Salidas_Cabecera> data = Productos_Salidas_CabeceraModel.listSubject();
		List<Clientes> data2 = unidadModel.listSubject();
		
		request.setAttribute("subject", subject);
		request.setAttribute("data", data);
		request.setAttribute("data2", data2);
		
		request.setAttribute("type", opcion);
		request.setAttribute("respuesta", respuesta);
		request.getRequestDispatcher("EditarProductos_Salidas_Cabecera.jsp").forward(request, response);
	}

}
