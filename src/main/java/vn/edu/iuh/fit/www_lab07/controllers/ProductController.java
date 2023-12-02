package vn.edu.iuh.fit.www_lab07.controllers;

import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.edu.iuh.fit.www_lab07.dto.ProductDTO;
import vn.edu.iuh.fit.www_lab07.services.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String getAllProducts(Model model) {
        List<ProductDTO> productDTOs = productService.getAllProducts();
        System.out.println("products"+productDTOs);
        model.addAttribute("products", productDTOs);

        return "/home";
    }
    @GetMapping("/buy/{id}")
    public String buy(HttpSession session, @PathVariable ("id") long id){
        Optional<ProductDTO> productDTO = Optional.ofNullable(productService.getProductById(id));

        List<ProductDTO> lst = null;
        Object obj = session.getAttribute("cart");
        if(obj==null)
            lst=new ArrayList<>();
        else
            lst=(ArrayList<ProductDTO>)obj;
        if(productDTO.isPresent()){
            lst.add(productDTO.get());
        }
        session.setAttribute("cart", lst);
        return "redirect:/";
    }
    @GetMapping("/checkout")
    public String checkout(Model model, HttpSession session){
        List<ProductDTO> productDTOs = (List<ProductDTO>) session.getAttribute("cart");
        model.addAttribute("products", productDTOs);
        return "carts";
    }
    @GetMapping("/pay")
    public String pay(HttpSession session){
        session.removeAttribute("cart");
        return "redirect:/checkout";
    }

}
