package com.infosys.Customerrelationshipmanagement.services;

import com.infosys.Customerrelationshipmanagement.beans.Customers;
import com.infosys.Customerrelationshipmanagement.beans.Interaction;
import java.time.LocalDate;
import java.util.List;

public interface CRMServicesInterface {
    Customers addCustomer(Customers customer);
    Customers getCustomerById(int id);
    List<Customers> getAllCustomer();
    void deleteCustomer(int id);
    Customers updateCustomer(Customers customer);
    Interaction addInteraction(int customerId, Interaction interaction);
    List<Interaction> getFeedbackByProduct(String product);
    List<Interaction> getFeedbackByDateRange(LocalDate from, LocalDate to);
    List<Interaction> getFeedbackByRating(int rating);
}
