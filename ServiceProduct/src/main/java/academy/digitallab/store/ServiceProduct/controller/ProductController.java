package academy.digitallab.store.ServiceProduct.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.instrument.web.HttpClientResponseParser;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import academy.digitallab.store.ServiceProduct.entity.Category;
import academy.digitallab.store.ServiceProduct.entity.Product;
import academy.digitallab.store.ServiceProduct.service.ProductService;

@RestController
@RequestMapping(value ="/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping(value = "/id")
	public ResponseEntity<List<Product>> listProducts(@RequestParam(name="categoryId", required = false ) Long categoryId){
		
		List<Product> productos = new ArrayList<>(); 
		if( null == categoryId) {
			productos = productService.listAllProduct();
			 if(productos.isEmpty()) {
				 return ResponseEntity.noContent().build();
			 }
		}else {
			 productos = productService.findByCategory(Category.builder().id(categoryId).build());
			 if(productos.isEmpty()) {
				 return ResponseEntity.notFound().build();
			 }
		}
		
		return ResponseEntity.ok(productos);
	}
	
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Long id){
		Product product = productService.getProduct(id);
		
		if (null == product) {
			return ResponseEntity.notFound().build();
		}else {
			ResponseEntity.ok(product);
		}
		
		return null;
	}
	
	@PostMapping
	  @ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product, BindingResult result){
		
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"No se ha podido crear el producto correctamente , revisa el JSON");
			
		}
		Product productCreate = productService.createProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(productCreate);
	}
	
	@PutMapping(value ="/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id" )Long id, @RequestBody Product product){
		product.setId(id);
		Product productDB = productService.upateProduct(product);
		if(productDB == null ) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(productDB);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id){
		Product productDelete = productService.deleteProduct(id);
		
		if(productDelete == null ) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(productDelete);
	}
	
	@GetMapping(value = "{/id}/stock")
	public ResponseEntity<Product> updateStockProduct(@PathVariable("id") Long id, @RequestParam(name="quantity", required = true) double quantity){
		Product product = productService.updateStock(id, quantity);
		
		if(product == null ) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(product);
	}
	
	
	@HttpClientResponseParser()
	@GetMapping
	public String error_page() {
		return "<h1 style = \"color:red; font-weight:bold; font-size:50px\">Error</h1>";
	}

}
