package com.somanath.fulfillx.repo; import com.somanath.fulfillx.model.Warehouse; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
public interface WarehouseRepo extends JpaRepository<Warehouse,Long>{List<Warehouse> findAllByOrderByLoadAsc();}
