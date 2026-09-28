package com.somanath.fulfillx.repo; import com.somanath.fulfillx.model.Order; import org.springframework.data.jpa.repository.JpaRepository; import java.util.Optional;
public interface OrderRepo extends JpaRepository<Order,Long>{Optional<Order> findByOrderNumber(String orderNumber);}
