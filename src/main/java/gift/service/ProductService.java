package gift.service;


import gift.dto.ProductDto;
import gift.model.product.Product;
import gift.model.product.ProductName;
import gift.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public boolean addNewProduct(ProductDto productDto){
        Product product = new Product(new ProductName(productDto.name()),productDto.price(),productDto.imageUrl(),productDto.amount());
        if (productRepository.existsByName(product.getName())) {
            return false;
        }
        productRepository.save(product);
        return true;
    }

    public boolean updateProduct(Long id, ProductDto productDto) {
        Product product = new Product(new ProductName(productDto.name()),productDto.price(),productDto.imageUrl(),productDto.amount());
        if (productRepository.existsById(id)) {
            product.setId(id);
            productRepository.save(product);
            return true;
        }
        return false;
    }

    public boolean purchaseProduct(Long id, int amount) {
        Product product = productRepository.findById(id).get();
        if (product.isProductEnough(amount)) {
            productRepository.purchaseProductById(id, amount);
            return true;
        }
        return false;
    }

    public Product selectProduct(Long id) {
        return productRepository.findById(id).get();
    }

    public List<Product> selectAllProducts(){
        return productRepository.findAll();
    }

    public void DeleteProduct(Long id){
        productRepository.deleteById(id);
    }
}
