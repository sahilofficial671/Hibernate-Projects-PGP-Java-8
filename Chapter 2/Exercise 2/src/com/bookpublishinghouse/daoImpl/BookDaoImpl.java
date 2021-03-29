package com.bookpublishinghouse.daoImpl;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bookpublishinghouse.dao.BookDao;
import com.bookpublishinghouse.helpers.Flash;
import com.bookpublishinghouse.model.Author;
import com.bookpublishinghouse.model.Book;
import com.bookpublishinghouse.util.HibernateUtil;

public class BookDaoImpl implements BookDao{

	public BookDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Book validateBookRequest(HttpServletRequest request) {
		try {
			String name, edition, publisher, category, author_name;
			name = edition = publisher = category = author_name = "";
			
			Integer publishingYear, price, quantity;
			publishingYear = price = quantity = null;
			
			if(request.getParameter("name") != null) {
				name = request.getParameter("name");
			}
			
			if(request.getParameter("edition") != null) {
				edition = request.getParameter("edition");
			}
			
			if(request.getParameter("publisher") != null) {
				publisher = request.getParameter("publisher");
			}
			
			if(request.getParameter("category") != null) {
				category = request.getParameter("category");
			}
			
			if(request.getParameter("author_name") != null) {
				author_name = request.getParameter("author_name");
			}
			
			if(request.getParameter("publishingYear") != null) {
				publishingYear = Integer.valueOf(request.getParameter("publishingYear"));
			}
			
			if(request.getParameter("price") != null) {
				price = Integer.valueOf(request.getParameter("price"));
			}
			
			if(request.getParameter("quantity") != null) {
				quantity = Integer.valueOf(request.getParameter("quantity"));
			}
			
			if(name.isEmpty() || edition.isEmpty() || category.isEmpty() || publisher.isEmpty()
					|| author_name.isEmpty() || publishingYear == null || price == null || quantity == null) {
				Flash.error(request, Flash.error_fill_all_fields);
			}
			
			// Book
			Book book = new Book();
			book.setName(name);
			book.setEdition(edition);
			book.setCategory(category);
			book.setPublisher(publisher);
			book.setPublishingYear(publishingYear);
			book.setPrice(price);
			book.setQuantity(quantity);
			
			// Author
			Author author = new Author();
			author.setName(author_name);
			book.setAuthor(author);
			return book;
		} catch (Exception e) {
			e.printStackTrace();
			String message = "Error From: "+ this.getClass().getSimpleName() +" ["+Thread.currentThread().getStackTrace()[1].getMethodName()+"], Error Class: " + e.getClass().getSimpleName() + ", Message: "+ e.getMessage();
			Flash.error(request, message);
			return null;
		}
	}
	
	@Override
	public Boolean add(Book book) {
		Transaction tx = null;
		try {
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(book);
			tx.commit();
			session.close();
			return true;
			
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			String message = "Error From: "+ this.getClass().getName() +"."+Thread.currentThread().getStackTrace()[1].getMethodName()+"(), Error Class: " + e.getClass().getSimpleName() + ", Message: "+ e.getMessage();
			System.out.println(message);
			return false;
		}
	}
}
