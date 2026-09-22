# Документация
## Компоненты проекта

# 1) Item в нашей системе

Каких типов может быть **Item** на marketplace:
Например, товар может быть *оружием*, *кейсом*, *агентом*, *брелком*, *граффити*, *наклейкой* и др.

**А в чем отличие для системы?**
- разные типы
- разные атрибуты - у **оружий**, например, есть класс оружия, модель оружия, поношенность, редкость и типы изношенности(качество). У **кейса** таких параметров нет

## Виды предметов и их атрибуты

### 1) Оружие
Огнестрельное и холодное оружие будут под этим типом.
1) *Id* - Если это шаблон, то тип будет int или long, если экземпляр, то uuid
2) *name* - String
3) *Wear* - Enum, хранящий Factory New, Minimal Wear, Field-Tested, Well-Worn, Battle-Scarred
4) *ItemType* - Enum категории предметов - Pistol, Rifle, Knife, SMG, Heavy, Knife, Container, Gloves и другие
5) *Weapon Model* - Enum типа оружия. Например, категория *Pistol* и тип *USP-S*
6) *Weapon Rarity* - Enum. Раритетность для оружий: **Consumer Grade**, **Industrial Grade**, **Mil-Spec Grade**, **Restricted**, **Classified**, **Covert**
7) *Image Url* - String. Просто храним ссылку
8) *Slug* - String. Имя для ресурса, чтобы было легче делать страницы.
   Например, есть *Ak-47 Redline и его качество Battle-Scarred*, то в пути ресурса у него будет преобразовано в
   .../Rifle/AK-47/AK-47%20%7C%20Redline%20%28Battle-Scarred%29
9) *Quality* - Enum. Категория для любых предметов. Хранит в себе *Common*, *StatTrack*, *Souvenir*

### 2) Перчатки
1) *Id* - Если это шаблон, то тип будет int или long, если экземпляр, то uuid
2) *name* - String
3) *Slug* - String
4) *Wear* - поношенность
5) *Image Url*
6) *Rarity* - Enum. Хранит только один тип - *Extraordinary*
7) *Quality* - хранит в себе *★*
8) *Gloves Model*
9) *ItemType*

### 3) Контейнеры
Кейсы и капсулы.
1) *Id* - long
2) *name* - String
3) *slug* - String
4) *Item Type* - будет *Container*
5) *itemPool* - List, хранящий в себе предметы, которые выпадают из этого контейнера.
6) *Rarity* - Enum. Хранит только один тип - *Base Grade*
7) *image url*
8) *Quality* - хранит в себе *Common*

### 4) Агенты
1) *Id* - long
2) *name* - String
3) *Slug* - String
4) *Image Url*
5) *AgentRarity* - Enum. Хранит в себе **Master**, **Superior**, **Exceptional**, **Distinguished**
6) *Quality* - хранит в себе *Common*
7) *ItemType* - будет *Agent*

### 5) Наклейки
1) *Id* - long
2) *name* - String
3) *Slug* - String
4) *Image Url*
5) *StikerRarity* - Enum: **High Grade**, *Remarkable**, **Exotic**
6) *ItemType* - будет *Sticker*
7) *Quality* - хранит в себе *Common*

## Что общего у них всех?
Можно сделать абстрактный класс-сущность:
**Item**
1) *name*
2) *slug*
3) *imageUrl*
4) *itemType*
5) *quality*

## Таблицы
- Items
  - WeaponsTemplates
    - weaponsInstanses
  - GlovesTemplates
    - glovesInstanses
  - Agents
  - Stickers
    - stikersInstanses
  - Containers

Также, они будут хранить в себе *userId*, чтобы можно было сделать get-запрос.

# 2) Listing Service
Сервис, который отвечает за объявления продаж: выставление товаров на продажу, изменение цены и убрать объявление с продажи

### Модель Listing

| Поле          | Тип           | Обязательное | Ограничения                  | Описание                                                      |
|---------------|---------------|--------------|------------------------------|---------------------------------------------------------------|
| id            | UUID          | да           | —                            | Генерируется сервером                                         |
| listingStatus | ListingStatus | да           | `ACTIVE`, `RESERVED`, `SOLD` | Статус объявления                                             |
| item          | Item          | да           | —                            | Продаваемый товар                                             |
| sellerId      | UUID          | да           | —                            | Получаем, когда пользователь выставляет свой товар на продажу |
| createdAt     | ISO-8601      | да           | UTC                          | Дата создания объявления                                      |
| reservedUntil | ISO-8601      | нет          | UTC                          | Дата то какого момента времени товар зарезервирован           |
| price         | Decimial      | да           | больше 0                     | Цена объявления                                               |

Пример
```json
{
  "id": "uuid",
  "listingStatus": "ACTIVE",
  "item": {
    "данные о предмете": "???"
  },
  "sellerId": "uuid",
  "createdAt": "2026-09-14T10:30:00Z",
  "reservedUntil": "2026-09-14T12:30:00Z",
  "price": 1337.00
}
```

### API сервиса

- получить свой список объявлений продаж
```http request
GET /api/v1/listings/me

returns
{   
    "listings": [
        {
            "поля сущности listing": "значения полей"
        },
        
    ]
}

```

- получить свой список объявлений продаж
```http request
GET /api/v1/listings

returns
{   
    "listings": [
        {
            "поля сущности listing": "значения полей"
        },
        
    ]
}

```

- создать объявление о продажи

```http request
POST /api/v1/listings

{
  "item": {
    "данные о предмете": "???"
  },
  "price": 1337.00
}

returns CREATED
{
    "listingId": "uuid",
    "listingStatus": "ACTIVE",
    "item": { ... },
    "sellerId": "uuid",
    "createdAt": "2026-09-14T10:30:00Z",
    "reservedUntil": null,
    "price": 85000.00
}

```

- изменить цену объявления

```http request

PATCH /api/v1/listings/{listing-id}/price

{
    "price": 100.00
}

```

- снять объявление с продажи
```http request
POST /api/v1/listings/{listing-id}/archive

returns OK
{
    "listingId": "uuid",
    "listingStatus": "ARCHIVED"
}
```
- вернуть в продажу
```http request
POST /api/v1/listings/{listing-id}/publish

returns OK
{
    "listingId": "uuid",
    "listingStatus": "ACTIVE"
}
```

- резервация покупателем

```http request
POST /api/v1/listings/{listing-id}/reserve

returns OK
{
    "listingId": "uuid",
    "listingStatus": "RESERVED",
    "reservedUntil": "2026-09-14T12:30:00Z",
    "price": 85000.00
}
```

# 3) Purchase-service

Сервис, отвечающий за цикл покупки.

Через его api начинается процесс покупки, отслеживается выполнения требований для продолжения покупки, и он же завершает процесс покупки.

(на момент 14.09.26) Я думаю, что он будет оркестратором в паттерне Saga


### Модель

| Поле           | Тип            | Обязательное | Ограничения                                   | Описание                                                                                                                                         |
|----------------|----------------|--------------|-----------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------|
| id             | UUID           | да           | —                                             | Генерируется сервером                                                                                                                            |
| buyerId        | UUID           | да           | —                                             | Id покупателя. Получаем из заголовка запроса                                                                                                     |
| sellerId       | UUID           | да           | —                                             | Id продавца. Полачем либо из дто в запросе                                                                                                       |
| listingId      | UUID           | да           | —                                             | Id объявление о продажи. При помощи него можно зарезервировать нужное объявление и в конце процесса покупки изменить статус объявления на 'SOLD' |
| totalAmount    | Decimial       | да           | не может быть меньше нуля                     | Цена за покупку                                                                                                                                  |
| purchaseStatus | PurchaseStatus | да           | `STARTED`, `COMPLETED`, `FAILED`, `CANCELLED` | Статус покупки                                                                                                                                   |
| createdAt      | ISO-8601      | да           | UTC                          | Дата начала процесса покупки                                                                                                                     |
| completedAt    | ISO-8601      | да           | UTC                          | Дата завершения процесса покупки                                                                                                                 |


### API Сервиса
- начать процесс покупки
```http request
POST /api/v1/purchases

{
    "listingId": "uuid",
    "expectedPrice": 5252.52
}
```
