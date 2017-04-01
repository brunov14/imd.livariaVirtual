package control;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exceptions.LivroNaoEncontradoException;
import model.CarrinhoCompras;
import model.Livraria;
import model.Livro;

/**
 * Servlet implementation class ServletControladorLivraria
 */
@WebServlet(name="/ServletControladorLivraria", urlPatterns={"/livros/livraria","/livros/catalogo"})
public class ServletControladorLivraria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletControladorLivraria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		String idLivro = null;
		String limpar = null;
		Livro livro = null;
		Livraria livraria = (Livraria) getServletContext().getAttribute(LivrariaContextListener.SISTEMA_LIVRARIA);
		HttpSession session = request.getSession();
		
		CarrinhoCompras carrinho = (CarrinhoCompras) session.getAttribute("cart");
		if (carrinho == null) {
			carrinho = new CarrinhoCompras();
			session.setAttribute("cart", carrinho);
		}

		String acaoSelecionada = request.getServletPath();

		// Aqui entram as operações do sistema
		if (acaoSelecionada.equals("/livros/catalogo")) {
		      idLivro = request.getParameter("Add");

		      if (!idLivro.equals("")) {
		            try {
		                  livro = livraria.getLivro(idLivro);
		                  carrinho.adicionar(livro);
		            } catch (LivroNaoEncontradoException ex) {
		                  // isso não deve acontecer
		            }
		      }
		}

		String tela = acaoSelecionada + ".jsp";

		try {
			request.getRequestDispatcher(tela).forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}

}
