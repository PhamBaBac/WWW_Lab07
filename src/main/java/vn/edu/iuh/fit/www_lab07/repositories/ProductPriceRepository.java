package vn.edu.iuh.fit.www_lab07.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.www_lab07.models.Product;
import vn.edu.iuh.fit.www_lab07.models.ProductImage;
import vn.edu.iuh.fit.www_lab07.models.ProductPrice;

public  interface ProductPriceRepository extends JpaRepository<ProductPrice, Long> {
}
