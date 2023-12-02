package vn.edu.iuh.fit.www_lab07;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.www_lab07.enums.ProductStatus;
import vn.edu.iuh.fit.www_lab07.models.Product;
import vn.edu.iuh.fit.www_lab07.models.ProductImage;
import vn.edu.iuh.fit.www_lab07.models.ProductPrice;
import vn.edu.iuh.fit.www_lab07.repositories.ProductImageRepository;
import vn.edu.iuh.fit.www_lab07.repositories.ProductPriceRepository;
import vn.edu.iuh.fit.www_lab07.repositories.ProductRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WwwLab07Application {

    public static void main(String[] args) {
        SpringApplication.run(WwwLab07Application.class, args);
    }

    @Bean
    public CommandLineRunner initializeData(ProductRepository productRepository, ProductImageRepository productImageRepository, ProductPriceRepository productPriceRepository) {
        return args -> {
            for (int i = 1; i <= 10; i++) {
                Product product = createSampleProduct(i);
                ProductImage productImage = createSampleProductImage(product, i);
                ProductPrice productPrice = createSampleProductPrice(product, i);

                productRepository.save(product);
                productImageRepository.save(productImage);
                productPriceRepository.save(productPrice);
            }
        };
    }

    private Product createSampleProduct(int i) {
        Product product = new Product();
        product.setName("Iphone 15 Pro");
        product.setDescription("512Gb, pink, chip A17");
        product.setUnit("cái ");
        product.setManufacturer("Apple ");
        product.setStatus(ProductStatus.ACTIVE);  // Set the status as needed

        return product;
    }

    private ProductImage createSampleProductImage(Product product, int i) {
        ProductImage productImage = new ProductImage();
        productImage.setPath("https://salt.tikicdn.com/cache/750x750/ts/product/6c/6c/9e/a45bc5d76cec3c11c5f8cbcdf9e27929.png.webp");
        productImage.setAlternative("Image " + i + " for " + product.getName());
        productImage.setProduct(product);

        return productImage;
    }
    private ProductPrice createSampleProductPrice(Product product, int i) {
        ProductPrice productPrice = new ProductPrice();
        productPrice.setProduct(product);
        productPrice.setPrice(33000000);
        productPrice.setPrice_date_time(LocalDateTime.now());
        productPrice.setNote("Note " + i);
        return productPrice;
    }
}
