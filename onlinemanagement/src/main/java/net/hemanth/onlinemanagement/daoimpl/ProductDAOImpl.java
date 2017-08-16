package net.hemanth.onlinemanagement.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Query;
import net.hemanth.onlinemanagement.dao.ProductDAO;
import net.hemanth.onlinemanagement.dto.Product;

@Repository("productDao")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getProducts() {
		return sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	@Override
	public boolean saveProduct(Product p) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(p);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public Product getProductByid(Integer id) {
		
				List<Product> ProductList=sessionFactory.getCurrentSession().createQuery("from Product where id=:id")
				.setInteger("id", new Integer(id)).list();
				if(ProductList!=null && !ProductList.isEmpty()) {
					return (Product)ProductList.get(0);
				}
		return null;
	}

	@Override
	public void deleteProductByid(Integer id) {
		Product p = getProductByid(id);
		sessionFactory.getCurrentSession().delete(p);
	}
}
