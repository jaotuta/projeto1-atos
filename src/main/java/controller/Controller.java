package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.Services;


@WebServlet(urlPatterns = {"", "/home", "/novoproduto", "/produtos", "/alterarproduto"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Services service = new Services();

	public Controller() throws IOException {

    }
	

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
        String method = request.getMethod();
        if(method.equals("GET")) {
            doGet(request, response);
        }
        if(method.equals("POST")) {
            doPost(request, response);
        }
        if(method.equals("DELETE")) {
            //doDelete(request, response);
        }
        if(method.equals("PUT")) {
            //doPut(request, response);
        }
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		// Entrara neste if caso o caminho passado seja vazio e redireciona para o /home
		if (path.equals("")) {
			response.sendRedirect("/projeto-backend/home");
		}
		
		if (path.equals("/home")) {
			try {
				System.out.println(service.buscarTodosProduto());
				request.setAttribute("listaProdutos", service.buscarTodosProduto());
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		if (path.equals("/novoproduto")) {
			RequestDispatcher rd = request.getRequestDispatcher("novo-produto.jsp");
			rd.forward(request, response);
			System.out.println("Teste GET /novoproduto");			
		}
		if (path.equals("/produtos")) {
			System.out.println("Teste GET /produtos");			
		}
		if (path.equals("/alterarproduto")) {
			System.out.println("Teste GET /alterarproduto");			
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//service.novoProduto("1524632597512", "Iphone 13 Pro - Gray 128gb", "Telefonia", 5699.90f, 25);
		super.doPost(request, response);
	}




}
