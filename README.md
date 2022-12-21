**ports**

`discovery-server: 8761`

`config-server: 8888`

`api-gateway: 8766`

`client-service: 8082`

`book-service: 8083`

**check work**

api-gateway -> client-service -> book-service -> mongodb

http://localhost:8766/client/getAllBooksByFeignClient

http://localhos:8766/client/getAllBooksByRestTemplate# api-gateway
