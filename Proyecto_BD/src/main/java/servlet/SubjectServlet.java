package servlet;
import clases.Clientes;
import java.util.*;
import clases.ClienteModel;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SubjectServlet
 */
@WebServlet("/SubjectServlet")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    
  
/*    private void deleteSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String idSubject = request.getParameter("id");
    	ClienteModel clienteModel = new ClienteModel();
    	
    	int subject = clienteModel.delateSubject(idSubject);
    	List<Clientes> data = clienteModel.listSubject();
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("subject.jsp").forward(request, response);
	}
*/
	private void editSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		int code = Integer.parseInt(request.getParameter("code"));     
	    String name = request.getParameter("name");
	    String ruc = request.getParameter("ruc");
	    String direccion = request.getParameter("direc");
	    String estado = request.getParameter("estado");
	    Clientes subject = new Clientes(); 
	    subject.setCliCod(code);
	    subject.setCliNom(name);
	    subject.setCliRuc(ruc);
	    subject.setCliDir(direccion);
	    subject.setCliEst(estado);
	    ClienteModel clienteModel = new ClienteModel();
	    int rspt = clienteModel.updateSubject(subject);
	    
    	List<Clientes> data = clienteModel.listSubject();
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("ListaCliente.jsp").forward(request, response);	
	}

	protected void registerSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  int code = Integer.parseInt(request.getParameter("code"));     
	      String name = request.getParameter("name");
	      String ruc = request.getParameter("RUC");
	      String direccion = request.getParameter("direc");
	      String estado = request.getParameter("estado");
	      
	      Clientes subject = new Clientes();
	      
	      subject.setCliCod(code);
	      subject.setCliNom(name);
	      subject.setCliRuc(ruc);
	      subject.setCliDir(direccion);
	      subject.setCliEst(estado);
	          
	     // Procesos
	      
	      ClienteModel model = new ClienteModel();
	      int value = model.createSubject(subject);
	      
	      if(value == 1) {
	    	 listSubject(request, response);
	      }
	      else {
	    	  request.setAttribute("mensaje", "Ocurrio"); 
	    	  listSubject(request, response);
	    	  
	      }
    }
    
    protected void listSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ClienteModel clienteModel = new ClienteModel();
    	
    	List<Clientes> data = clienteModel.listSubject();
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("ListaCliente.jsp").forward(request, response);
    	
    }
    
    protected void getSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String idSubject = request.getParameter("id");
    	ClienteModel clienteModel = new ClienteModel();
    	Clientes subject = clienteModel.getSubject(idSubject);
    	List<Clientes> data = clienteModel.listSubject();
    	System.out.println();
    	request.setAttribute("subject", subject);
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("EditarCliente.jsp").forward(request, response);
    }
    
    protected void getSubject(HttpServletRequest request, HttpServletResponse response, String opcion)
			throws ServletException, IOException {
		String respuesta;
		String idSubject = request.getParameter("id");
		
		ClienteModel clienteModel = new ClienteModel();
		Clientes subject = clienteModel.getSubject(idSubject);
		if(opcion.equals("info"))
			respuesta = subject.getCliEst();
		else if (opcion.equals ("reac"))
			respuesta = "A";
		else if (opcion.equals("inac"))
			respuesta = "I";
		else
			respuesta = "*";
		
//		List<Unidad_Medida> data = unidadModel.listSubject();
		request.setAttribute("subject", subject);
		request.setAttribute("type", opcion);
		request.setAttribute("respuesta", respuesta);
		request.getRequestDispatcher("EditarCliente.jsp").forward(request, response);
	}

}
