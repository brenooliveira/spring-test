# Spring Boot Test

First build project:

```sh
./gradlew build
```

To run:

```sh
docker-compose up --build
```

## Requisições
### Adicionar produto

```curl
curl --request POST \
  --url http://localhost:8080/v1/inventory \
  --header 'Content-Type: application/json' \
  --data '{
    "sku": 432643,
    "name": "Uma descrição de um produto qualquer",
    "inventory": {
        "quantity": 15,
        "warehouses": [
            {
                "locality": "SP",
                "type": "ECOMMERCE"
            },
            {
                "locality": "MOEMA",
                "type": "PHYSICAL_STORE"
            }
        ]
    }
}'
```

### Buscar produto
```curl
curl --request GET \
--url http://localhost:8080/v1/inventory/432643
```

### Editar produto
```curl
curl --request PUT \
  --url http://localhost:8080/v1/inventory/432643 \
  --header 'Content-Type: application/json' \
  --data '{
    "sku": 432643,
    "name": "Uma descrição de um produto qualquer2",
    "inventory": {
        "quantity": 15,
        "warehouses": [
            {
                "locality": "SP",
                "type": "ECOMMERCE"
            },
            {
                "locality": "MOEMA",
                "type": "PHYSICAL_STORE"
            }
        ]
    }
}'
```

### Deletar produto
```
curl --request DELETE \
  --url http://localhost:8080/v1/inventory/432643
```