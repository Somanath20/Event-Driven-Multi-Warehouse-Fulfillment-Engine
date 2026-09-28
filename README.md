# FulfillX 📦

Event-driven multi-warehouse order fulfillment workflow engine.

## Engineering highlights
- Warehouse allocation using distance + capacity utilization score
- Explicit order state machine: PLACED → ALLOCATED → PICKED → PACKED → SHIPPED → DELIVERED
- Invalid state transitions rejected
- Kafka fulfillment events
- PostgreSQL persistence
- Redis-ready runtime for future hot-path caching/locks
- Docker Compose and GitHub Actions CI
- Actuator metrics/health endpoints

## Run
```bash
docker compose up --build
```

## Create order
```bash
curl -X POST http://localhost:8081/api/orders \
 -H 'Content-Type: application/json' \
 -d '{"orderNumber":"ORD-1001","sku":"SHOE-001","quantity":2,"customerLat":22.57,"customerLon":88.36}'
```

## Advance workflow
```bash
curl -X POST 'http://localhost:8081/api/orders/ORD-1001/transition?to=PICKED'
```

## Interview talking points
Warehouse scoring, state machines, transactional updates, event-driven architecture, failure handling, scalability and API design.

## Load test
With the stack running and warehouses seeded, run:
```bash
k6 run load-test/k6.js
```
See `docs/architecture.md` for the allocation algorithm and architecture.
