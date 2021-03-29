package com.newtechbookstore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newtechbookstore.daoImpl.BookDaoImpl;
import com.newtechbookstore.model.Book;

@WebServlet("/")
public class AppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = new BookDaoImpl().getBookById(1);
		System.out.println(book);
		System.out.println(book.toJson());
//		List<Book> bookList = HibernateUtil.getSessionFactory().openSession().createQuery("from Book where id = :bookId").setInteger("bookId", 1).list();
//		System.out.println(bookList);
//		Book book = bookList.get(0);
//		return ;
//		SessionFactory sessionfactory;
//		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
//		sessionfactory = configuration.buildSessionFactory();
//		Session session = sessionfactory.openSession();
//		Transaction t = session.beginTransaction();
//		Book book =  new Book();
//		book.setName("New Book");
//		Author author = new Author();
//		author.setName("Sahil Bhatia");
//		book.setAuthor(author);
//		System.out.println(book);
//		session.save(book);
//		t.commit();
//		session.close();
		request.getRequestDispatcher("pages/index.jsp").forward(request, response);
//		return ;
	}
}
