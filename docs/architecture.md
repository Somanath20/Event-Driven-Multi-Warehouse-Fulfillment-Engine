# FulfillX Architecture

```mermaid
flowchart LR
  C[Client] --> O[Order API]
  O --> W[Warehouse Scoring Engine]
  W --> D[(PostgreSQL)]
  O --> K[Kafka fulfillment-events]
  K --> N[Async Consumers]
```

## Allocation score
`score = 0.7 × geographic distance + 0.3 × warehouse utilization penalty`

The scoring function favors nearby warehouses while avoiding overloaded facilities.
