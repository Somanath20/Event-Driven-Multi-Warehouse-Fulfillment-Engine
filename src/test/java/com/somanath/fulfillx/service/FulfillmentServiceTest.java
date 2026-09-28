package com.somanath.fulfillx.service;
import com.somanath.fulfillx.model.Order; import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;
class FulfillmentServiceTest { @Test void workflowOrderIsDefined(){ assertEquals(Order.Status.PLACED, Order.Status.valueOf("PLACED")); } }
