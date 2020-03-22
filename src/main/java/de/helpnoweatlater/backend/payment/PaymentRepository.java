package de.helpnoweatlater.backend.payment;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface PaymentRepository extends ReactiveMongoRepository<Payment, String> {

    Mono<Boolean> existsByOrderId(String orderId);

}
