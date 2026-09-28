package com.somanath.fulfillx.controller;
import com.somanath.fulfillx.dto.CreateOrderRequest; import com.somanath.fulfillx.model.Order; import com.somanath.fulfillx.service.FulfillmentService; import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/orders") public class FulfillmentController{
 private final FulfillmentService s; public FulfillmentController(FulfillmentService s){this.s=s;}
 @PostMapping public Order create(@Valid @RequestBody CreateOrderRequest r){return s.create(r);}
 @PostMapping("/{number}/transition") public Order transition(@PathVariable String number,@RequestParam Order.Status to){return s.transition(number,to);}
}
