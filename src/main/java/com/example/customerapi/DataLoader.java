package com.example.customerapi;

import com.example.customerapi.entity.Article;
import com.example.customerapi.entity.Category;
import com.example.customerapi.entity.Customer;
import com.example.customerapi.entity.Address;
import com.example.customerapi.repository.AddressRepository;
import com.example.customerapi.repository.ArticleRepository;
import com.example.customerapi.repository.CategoryRepository;
import com.example.customerapi.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataLoader {
    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final CategoryRepository categoryRepository;
    private final ArticleRepository articleRepository;

    public DataLoader(CustomerRepository customerRepository, AddressRepository addressRepository, CategoryRepository categoryRepository, ArticleRepository articleRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
        this.categoryRepository = categoryRepository;
        this.articleRepository = articleRepository;
    }

    @PostConstruct
    private void loadData() {
        customerRepository.deleteAll();
        articleRepository.deleteAll();

        //Create example customers with addresses
        Address address1 = new Address(1, "Test street", "Test city", "test", "Zip1");
        Address address2 = new Address(2, "Street2", "City2", "State2", "Zip2");
        Address address3 = new Address(3, "Street3", "City3", "State3", "Zip3");
        Customer customer1 = new Customer(1L, "Max", "Mustermann", "MaxM@Email.com", address1);
        Customer customer2 = new Customer(2L, "Lisa", "L","Test@Testmail.com", address2);
        Customer customer3 = new Customer(3L, "John", "Test","John@gmail.com", address3);
        Customer customer4 = new Customer(4L, "Jane", "Mustermann","email", address3);
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);

        Category category1 = new Category( "Category1", "d");
        Category category2 = new Category( "Category2", "h");
        Article article = new Article(1L, "Article1", "This is an article", 12.99, category1);
        Article article2 = new Article(2L, "Article2", "This is an article", 12.99, category1);
        Article article3 = new Article(3L, "Article3", "This is an article", 12.99, category2);
        Article article4 = new Article(4L, "Article4", "This is an article", 12.99, category2);

        articleRepository.save(article);
        articleRepository.save(article2);
        articleRepository.save(article3);
        articleRepository.save(article4);

    }
}
