package com.springboot.configurations;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.springboot.entities.Category;
import com.springboot.entities.Order;
import com.springboot.entities.OrderItem;
import com.springboot.entities.Payment;
import com.springboot.entities.Product;
import com.springboot.entities.User;
import com.springboot.entities.enums.OrderStatus;
import com.springboot.repositories.CategoryRepository;
import com.springboot.repositories.OrderItemRepository;
import com.springboot.repositories.OrderRepository;
import com.springboot.repositories.ProductRepository;
import com.springboot.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfiguration implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		User guilherme = new User(null, "Guilherme", "vilatorog@gmail.com", "(44)999758094", "123456");
		User maria = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User alex = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		List<User> usuarios = Arrays.asList(guilherme, maria, alex);
		userRepository.saveAll(usuarios);

		Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, guilherme);
		Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID, maria);
		Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.CANCELED, guilherme);

		List<Order> orders = Arrays.asList(order1, order2, order3);
		orderRepository.saveAll(orders);

		Category category1 = new Category(null, "Electronics");
		Category category2 = new Category(null, "Books");
		Category category3 = new Category(null, "Computers");

		List<Category> categories = Arrays.asList(category1, category2, category3);
		categoryRepository.saveAll(categories);

		Product product1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5,
				"");
		Product product2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product product3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product product4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product product5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99,	"");

		List<Product> products = Arrays.asList(product1, product2, product3, product4, product5);
		productRepository.saveAll(products);

		product1.getCategories().add(category2);
		product2.getCategories().add(category1);
		product2.getCategories().add(category3);
		product3.getCategories().add(category3);
		product4.getCategories().add(category3);
		product5.getCategories().add(category2);

		products = Arrays.asList(product1, product2, product3, product4, product5);
		productRepository.saveAll(products);
		
		OrderItem orderItem1 = new OrderItem(2, product1.getPrice(), product1, order1);
		OrderItem orderItem2 = new OrderItem(1, product3.getPrice(), product3, order1);
		OrderItem orderItem3 = new OrderItem(2, product3.getPrice(), product3, order2);
		OrderItem orderItem4 = new OrderItem(2, product5.getPrice(), product5, order3);
		
		orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3, orderItem4));
		
		Payment payment1 = new Payment(null, Instant.parse("2019-06-21T19:53:07Z"), order1);
		order1.setPayment(payment1);	
		
		orderRepository.save(order1);
	}
}