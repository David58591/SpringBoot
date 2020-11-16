//package academy.digitallab.store.ServiceProduct;
//
//import java.util.Date;
//import java.util.List;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import academy.digitallab.store.ServiceProduct.entity.Category;
//import academy.digitallab.store.ServiceProduct.entity.Product;
//import academy.digitallab.store.ServiceProduct.repository.ProductRepository;
//
//@DataJpaTest
//public class ProductRepositoryMockTest {
//
//	@Autowired
//	private ProductRepository productRepository;
//	
//	@Test
//	public void whenFindByCategory_thenReturnListProduct() {
//		Product product01 = Product.builder().
//				name("computer").
//				category(Category.builder().id(1L).build()).
//				description("").
//				stock(Double.parseDouble("10")).
//				price(Double.parseDouble("1500.89")).
//				status("Create").
//				createAt(new Date()).build();
//		
//		List<Product> founds = productRepository.findByCategory(product01.getCategory());
//		
//		Assertions.assertThat(founds.size()).isEqualTo(3);
//	
//	
//	}
//}
