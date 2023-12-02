package vn.edu.iuh.fit.www_lab07.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.www_lab07.dto.ProductDTO;
import vn.edu.iuh.fit.www_lab07.models.Product;
import vn.edu.iuh.fit.www_lab07.repositories.ProductRepository;
import vn.edu.iuh.fit.www_lab07.utils.ProductUtil;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductUtil::convertToDTO)
                .collect(Collectors.toList());
    }
    public ProductDTO getProductById(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        return productOptional.map(ProductUtil::convertToDTO).orElse(null);
    }
}
