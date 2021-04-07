package com.newtechbookstore.daoImpl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.newtechbookstore.dao.OrderDao;
import com.newtechbookstore.helpers.Flash;
import com.newtechbookstore.model.Book;
import com.newtechbookstore.model.Customer;
import com.newtechbookstore.model.Order;
import com.newtechbookstore.util.HibernateUtil;

public class OrderDaoImpl implements OrderDao {
	private BookDaoImpl bookDaoImpl;
	
	public OrderDaoImpl() {
		bookDaoImpl = new BookDaoImpl();
	}

	@Override
	public Order validateAddOrderRequest(HttpServletRequest request) {
		Integer quantity = null;
		String shippingAddress = "";
		Book book = null;
		
		if(request.getParameter("bookId") != null) {
			book = bookDaoImpl.getBookById(Integer.valueOf(request.getParameter("bookId")));
		}
		
		if(request.getParameter("quantity") != null) {
			quantity = Integer.valueOf(request.getParameter("quantity"));
		}
		
		if(request.getParameter("shippingAddress") != null) {
			shippingAddress = request.getParameter("shippingAddress");
		}

		if(book == null || quantity == null || shippingAddress.isEmpty()) {
			Flash.error(request, "Fill all the mandatory fields (*).");
			return null;
		}
		
		if(quantity > book.getQuantity()) {
			Flash.error(request, "Ordered Quantity is not available.");
			return null;
		}
		
		Customer customer = (Customer) request.getSession().getAttribute("customer");
		Order order = new Order();
		order.setBookId(book.getId());
		order.setQuantity(quantity);
		order.setCustomerId(customer.getId());
		order.setShippingAddress(shippingAddress);
		order.setOrderedAt(new Timestamp(System.currentTimeMillis()));
		
		return order;
	}

	@Override
	public Boolean add(Order order) {
		Transaction tx = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();			
			session.save(order);		
			
			// Decrease Book Quantity
			Book book = (Book) session.load(Book.class, order.getBookId());
			book.setQuantity(book.getQuantity() - order.getQuantity());
			session.update(book);
			tx.commit();
			session.close();
			return true;
		}catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
			System.out.println("Error from: " + e.getClass().getSimpleName() + ", Message: "+ e.getMessage());
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Order getById(Integer orderId) {
		List<Order> ordersList = HibernateUtil.getSessionFactory().openSession()
				   .createQuery("from Order where id = :orderId")
				   .setInteger("orderId", orderId).list();

		return ordersList.size() == 1 ? ordersList.get(0) : null;
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return null;
	}

}
