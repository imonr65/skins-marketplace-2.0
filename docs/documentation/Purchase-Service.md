# Purchase-service

Сервис, отвечающий за цикл покупки.

Через его api начинается процесс покупки, отслеживается выполнения требований для продолжения покупки, и он же завершает процесс покупки.


(на момент 14.09.26) Я думаю, что он будет оркестратором в паттерне Saga

## API
- купить
```http request
POST /api/v1/purchase

{
    "buyer_id": uuid,
    "date": "timestamp"
    "listings":[
    {
        "id": "uuid",
        "seller_id": "uuid",
        "skin": {
            "id": "uuid",
            "float": "double",
            "skit_template_id": "int",
            "owner_id": "uuid"             
        }
        "price": "decimial",
        "createdDate": "timestamp",
           
    }
    ]
}

```

