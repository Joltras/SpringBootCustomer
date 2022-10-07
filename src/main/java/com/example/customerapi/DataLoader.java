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


/**
 * This class is used for creating test data.
 */
@Component
public class DataLoader {

    /**
     * Customer repository
     */
    private final CustomerRepository customerRepository;

    /**
     * Article repository
     */
    private final ArticleRepository articleRepository;

    /**
     * Category repository
     */
    private final CategoryRepository categoryRepository;

    /**
     * Address repository
     */
    private final AddressRepository addressRepository;

    /**
     * Creates a new data loader object with the given repositories.
     * @param customerRepository repository for customer entities
     * @param articleRepository repository for article entities
     */
    public DataLoader(CustomerRepository customerRepository, ArticleRepository articleRepository,
                      CategoryRepository categoryRepository, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
        this.addressRepository = addressRepository;
    }

    /**
     * Creates test data.
     */
    @PostConstruct
    private void loadData() {

        //Create example customers with addresses
        Address address1 = new Address("Test street", "Test city", "test", "Zip1");
        Address address2 = new Address("Street2", "City2", "State2", "Zip2");
        Address address3 = new Address("Street3", "City3", "State3", "Zip3");
        addressRepository.save(address1);
        addressRepository.save(address2);
        addressRepository.save(address3);

        Customer customer1 = new Customer("Max", "Mustermann", "MaxM@Email.com", address1);
        Customer customer2 = new Customer("Lisa", "L","Test@Testmail.com", address2);
        Customer customer3 = new Customer("John", "Test","John@gmail.com", address3);
        Customer customer4 = new Customer("Jane", "Mustermann","email", address3);
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);

        Category category1 = new Category( "Category1", "d");
        Category category2 = new Category( "Category2", "h");
        this.categoryRepository.save(category1);
        this.categoryRepository.save(category2);

        Article article = new Article("Article1", "This is an article", 12.99, category1);
        Article article2 = new Article("Article2", "This is an article", 12.99, category1);
        Article article3 = new Article("Article3", "This is an article", 12.99, category2);
        Article article4 = new Article("Article4", "This is an article", 12.99, category2);

        this.articleRepository.save(article);
        this.articleRepository.save(article2);
        this.articleRepository.save(article3);
        this.articleRepository.save(article4);

    }
}
