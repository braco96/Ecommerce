package com.icodeap.ecommerce.infrastructure.configuration;

import com.icodeap.ecommerce.application.repository.ProductRepository;
import com.icodeap.ecommerce.application.repository.StockRepository;
import com.icodeap.ecommerce.application.service.UserService;
import com.icodeap.ecommerce.domain.Product;
import com.icodeap.ecommerce.domain.Stock;
import com.icodeap.ecommerce.domain.User;
import com.icodeap.ecommerce.domain.UserType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Creates a default administrator account if one does not already exist.
 */
@Component
public class AdminUserInitializer implements CommandLineRunner {
    private final UserService userService;
    private final ProductRepository productRepository;
    private final StockRepository stockRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminUserInitializer(UserService userService,
                               ProductRepository productRepository,
                               StockRepository stockRepository,
                               PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.productRepository = productRepository;
        this.stockRepository = stockRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        String email = "admin@admin.com";
        User admin;
        if (!userService.existsByEmail(email)) {
            admin = new User(null, email, "Admin", "User", email, "", "", passwordEncoder.encode("admin123"), UserType.ADMIN, LocalDateTime.now());
            admin = userService.createUser(admin);
        } else {
            admin = userService.findByEmail(email);
        }

        if (!productRepository.getProducts().iterator().hasNext()) {
            Product product = new Product();
            product.setName("Sample Product");
            product.setDescription("Default product");
            product.setPrice(BigDecimal.valueOf(9.99));
            product.setImage("default.jpg");
            product.setDateCreated(LocalDateTime.now());
            product.setDateUpdated(LocalDateTime.now());
            product.setUser(admin);
            product = productRepository.saveProduct(product);

            Stock stock = new Stock();
            stock.setDateCreated(LocalDateTime.now());
            stock.setUnitIn(10);
            stock.setUnitOut(0);
            stock.setBalance(10);
            stock.setDescription("Initial stock");
            stock.setProduct(product);
            stockRepository.saveStock(stock);
        }
    }
}
