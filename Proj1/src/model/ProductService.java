package model;

import java.util.ArrayList;
import java.util.List;

import model.dao.CustomerDAOJdbc;
import model.dao.ProductDAOJdbc;

public class ProductService {
	//���O  ProductDAOJdbc ��@����  ProductDAO
	private ProductDAO productDao = new ProductDAOJdbc();
	//select ��k: 
	public List<ProductBean> select(ProductBean bean) {
		List<ProductBean> result = null;
		//���p select() �����Ȥ���null�h
		if(bean!=null && bean.getId()!=0) {
			ProductBean temp = productDao.select(bean.getId());
			if(temp!=null) {
				result = new ArrayList<ProductBean>();
				result.add(temp);
			}
		} else { //���pselect() �����Ȭ�null �h�^�Ǫ�� product �����Ҧ����
			result = productDao.select(); 
		}
		return result;
	}
	public ProductBean insert(ProductBean bean) {
		ProductBean result = null;
		if(bean!=null) {
			result = productDao.insert(bean);
		}
		return result;
	}
	public ProductBean update(ProductBean bean) {
		ProductBean result = null;
		if(bean!=null) {
			result = productDao.update(bean.getName(), bean.getPrice(),
					bean.getMake(), bean.getExpire(), bean.getId());
		}
		return result;
	}
	public boolean delete(ProductBean bean) {
		boolean result = false;
		if(bean!=null) {
			result = productDao.delete(bean.getId());
		}
		return result;
	}
	public static void main(String[] args) {
		ProductService service = new ProductService();
		List<ProductBean> beans = service.select(null);
		System.out.println("beans="+beans);
	}
}
