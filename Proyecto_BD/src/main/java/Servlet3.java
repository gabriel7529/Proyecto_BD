

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Categoria;
import clases.CategoriaModel;

/**
 * Servlet implementation class Servlet3
 */
@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String type = request.getParameter("type");
	    
	    switch (type) {
	    case "list": listSubject(request, response); break;
	    case "register" : registerSubject(request, response); break;
	    case "edit": editSubject(request, response); break;
	    case "delete" : deleteSubject(request, response); break;
	    case "info" : getSubject(request, response); break;
	    default:
	    	request.setAttribute("mensaje", "Ocurrió un problema");
	    }
	}
    
  
    private void deleteSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String idSubject = request.getParameter("id");
    	CategoriaModel productosModel = new CategoriaModel();
    	
    	int subject = productosModel.delateSubject(idSubject);
    	List<Categoria> data = productosModel.listSubject();
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("listaCategoria.jsp").forward(request, response);
	}

	private void editSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		int code = Integer.parseInt(request.getParameter("code"));     
	    String name = request.getParameter("name");
	    String estado = request.getParameter("estado"); 
	    
	    Categoria subject = new Categoria(); 
	    subject.setCatProCod(code);
	    subject.setNombre(name);
	    subject.setEstado(estado);
	   
	    CategoriaModel clienteModel = new CategoriaModel();
    	int rspt = clienteModel.updateSubject(subject);
    	List<Categoria> data = clienteModel.listSubject();
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("listaCategoria.jsp").forward(request, response);	
	}

	protected void registerSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));     
	    String name = request.getParameter("name");
	    String estado = request.getParameter("estado");


	    
	    Categoria subject = new Categoria(); 
	    subject.setCatProCod(code);
	    subject.setNombre(name);
	    subject.setEstado(estado);
	     // Procesos
	      
	      CategoriaModel model = new CategoriaModel();
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
    	CategoriaModel clienteModel = new CategoriaModel();
    	
    	List<Categoria> data = clienteModel.listSubject();
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("listaCategoria.jsp").forward(request, response);
    	
    }
    
    protected void getSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String idSubject = request.getParameter("id");
    	CategoriaModel clienteModel = new CategoriaModel();
    	Categoria subject = clienteModel.getSubject(idSubject);
    	List<Categoria> data = clienteModel.listSubject();
    	System.out.println();
    	request.setAttribute("subject", subject);
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("EditarCategoria.jsp").forward(request, response);
    }
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

}
