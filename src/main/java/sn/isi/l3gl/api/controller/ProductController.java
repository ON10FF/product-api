package sn.isi.l3gl.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.isi.l3gl.core.entity.Product;
import sn.isi.l3gl.core.service.ProductService;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // POST /api/products
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    // GET /api/products
    @GetMapping
    public List<Product> listProducts() {
        return productService.listProducts();
    }

    // PUT /api/products/{id}
    @PutMapping("/{id}")
    public Product updateQuantity(@PathVariable Long id,
            @RequestParam Integer quantity) {
        return productService.updateQuantity(id, quantity);
    }

    // GET /api/products/low-stock/count
    @GetMapping("/low-stock/count")
    public Long countLowStockProducts() {
        return productService.countLowStockProducts();
    }
}