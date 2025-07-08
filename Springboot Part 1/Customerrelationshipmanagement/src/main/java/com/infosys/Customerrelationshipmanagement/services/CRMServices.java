package com.infosys.Customerrelationshipmanagement.services;
import com.infosys.Customerrelationshipmanagement.beans.Customers;
import com.infosys.Customerrelationshipmanagement.beans.Interaction;
import com.infosys.Customerrelationshipmanagement.repos.CustomerRepo;
import com.infosys.Customerrelationshipmanagement.repos.InteractionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CRMServices implements CRMServicesInterface {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private InteractionRepo interactionRepo;
    // Customer Services
    @Override
    public Customers addCustomer(Customers customer) {
        return customerRepo.save(customer);
    }
    @Override
    public Customers getCustomerById(int id) {
        return customerRepo.findById(id).orElse(null);
    }
    @Override
    public List<Customers> getAllCustomer() {
        return customerRepo.findAll();
    }
    @Override
    public void deleteCustomer(int id) {
        customerRepo.deleteById(id);
    }
    @Override
    public Customers updateCustomer(Customers customer) {
        return customerRepo.save(customer);
    }
    @Override
    public Interaction addInteraction(int customerId, Interaction interaction) {
        Optional<Customers> customerOpt = customerRepo.findById(customerId);
        if (customerOpt.isPresent()) {
            interaction.setCustomer(customerOpt.get());
            interaction.setDate(LocalDate.now());
            return interactionRepo.save(interaction);
        } else {
            throw new IllegalArgumentException("Customer with ID " + customerId + " not found.");
        }
    }
    @Override
    public List<Interaction> getFeedbackByProduct(String product) {
        return interactionRepo.findByProduct(product);
    }
    @Override
    public List<Interaction> getFeedbackByDateRange(LocalDate start, LocalDate end) {
        return interactionRepo.findByDateBetween(start, end);
    }
    @Override
    public List<Interaction> getFeedbackByRating(int rating) {
        return interactionRepo.findByRating(rating);
    }
}
