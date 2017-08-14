package net.hemanth.onlinemanagement.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
		/*String selectActiveCategory = "FROM Product";

		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		return query.getResultList();*/
	}

	@Override
	public void saveProduct(Product p) {
		sessionFactory.getCurrentSession().saveOrUpdate(p);
	}

	@Override
	public Product getProductByid(Integer id) {
	 Product p=(Product)sessionFactory.getCurrentSession().createQuery("from Product where id=:id")
			 .setInteger("id",new Integer(id)).list().get(0);
	 System.out.println("sent->"+id+"     got ->"+p.getId());
		return p;
	}

	@Override
	public void deleteProductByid(Integer id) {
		Product p=getProductByid(id);
		sessionFactory.getCurrentSession().delete(p);
	}
}
