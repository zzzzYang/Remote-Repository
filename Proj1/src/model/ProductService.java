package model;

import java.util.ArrayList;
import java.util.List;

import model.dao.CustomerDAOJdbc;
import model.dao.ProductDAOJdbc;

public class ProductService {
	//類別  ProductDAOJdbc 實作介面  ProductDAO
	private ProductDAO productDao = new ProductDAOJdbc();
	//select 方法: 
	public List<ProductBean> select(ProductBean bean) {
		List<ProductBean> result = null;
		//假如 select() 內的值不為null則
		if(bean!=null && bean.getId()!=0) {
			ProductBean temp = productDao.select(bean.getId());
			if(temp!=null) {
				result = new ArrayList<ProductBean>();
				result.add(temp);
			}
		} else { //假如select() 內的值為null 則回傳表格 product 內的所有資料
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
