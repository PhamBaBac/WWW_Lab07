package vn.edu.iuh.fit.www_lab07.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.www_lab07.models.Product;

public  interface ProductRepository extends JpaRepository<Product, Long> {
}
