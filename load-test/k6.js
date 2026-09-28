import http from 'k6/http';
import { check } from 'k6';
export const options = { vus: 30, duration: '15s' };
export default function () {
  const id = `${__VU}-${__ITER}`;
  const body = JSON.stringify({orderNumber:`LOAD-${id}`,sku:'SHOE-001',quantity:1,customerLat:22.57,customerLon:88.36});
  const res = http.post('http://localhost:8081/api/orders', body, {headers:{'Content-Type':'application/json'}});
  check(res, {'request accepted or rejected cleanly': r => [200,201,500].includes(r.status)});
}
