package academy.digitallab.store.ServiceProduct.service;

import java.util.List;

import academy.digitallab.store.ServiceProduct.entity.Category;
import academy.digitallab.store.ServiceProduct.entity.Product;


public interface ProductService {

	public List<Product> listAllProduct();
	public Product getProduct(Long id);
	public Product createProduct(Product product);
	public Product upateProduct(Product product);
	public Product deleteProduct(Long id);
	public List<Product> findByCategory(Category category);
	public Product updateStock(Long id, Double quantity);
}
