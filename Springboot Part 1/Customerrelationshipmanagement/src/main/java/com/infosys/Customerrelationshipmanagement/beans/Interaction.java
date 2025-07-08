package com.infosys.Customerrelationshipmanagement.beans;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "interactions")
public class Interaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int interactionId;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customer;
    private LocalDate date;
    private String notes;
    private String product;
    private int rating;

    public Interaction(int interactionId, Customers customer, LocalDate date,
                       String notes, String product, int rating) {
        this.interactionId = interactionId;
        this.customer = customer;
        this.date = date;
        this.notes = notes;
        this.product = product;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Interaction{" +
                "interactionId=" + interactionId +
                ", customer=" + customer +
                ", date=" + date +
                ", notes='" + notes + '\'' +
                ", product='" + product + '\'' +
                ", rating=" + rating +
                '}';
    }
}
