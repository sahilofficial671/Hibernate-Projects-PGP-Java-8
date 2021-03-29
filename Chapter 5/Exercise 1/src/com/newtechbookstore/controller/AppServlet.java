package com.newtechbookstore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
//		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
//		SessionFactory sessionfactory = configuration.buildSessionFactory();		
//		Session session = sessionfactory.openSession();
//		Transaction t = session.beginTransaction();
//		
//		// Save Book
//		Book book =  new Book();
//		book.setName("Twight Saga");
//		book.setEdition("2.0");
//		book.setCategory("techincal");
//		Author author = new Author();
//		author.setName("Sahil Bhatia");
//		book.setAuthor(author);
//		book.setPublishingYear(2021);
//		book.setPrice(145);
//		book.setQuantity(40);
//		session.save(book);
//		System.out.println(book);
//		
//		// Save Customer
//		Customer customer = new Customer();
//		customer.setUserName("sahil");
//		customer.setFirstName("Sahil");
//		customer.setLastName("Bhatia");
//		customer.setGender("Male");
//		try {
//			customer.setDob(new SimpleDateFormat("YYYY-mm-dd").parse("1998-03-24"));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		customer.setEmail("sahil@sahil.com");
//		customer.setPhone("9560487757");
//		customer.setPassword("sahil1234");
//		
//		// Save Customer's Addresss
//		Address address = new Address();
//		address.setLine_1("H No. 20, Faridabad");
//		customer.setAddress(address);
//		address.setCustomer(customer);
//		System.out.println(customer);
//		session.save(customer);
//
//		// Save Order
//		Order order = new Order();
//		order.setBookId(1);
//		order.setCustomerId(1);
//		order.setQuantity(10);
//		order.setShippingAddress("H No. 20");
//		order.setOrderedAt(new Timestamp(System.currentTimeMillis()));
//		System.out.println(order);
//		session.save(order);
//		
//		Book book = new BookDaoImpl().getBookById(1);
//		System.out.println(book);
//		System.out.println(new BookDaoImpl().decreaseBookQuantityBy(book, 10));
//		System.out.println(new BookDaoImpl().getBookById(1));
//		t.commit();
//		session.close();
		
		request.getRequestDispatcher("pages/index.jsp").forward(request, response);
		return ;
	}
}
