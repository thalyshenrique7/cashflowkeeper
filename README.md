## Entity: User

### Properties

+ id: Long (Not Null)
+ username: String (Not Null)
+ cpf: String (Not Null)
+ active: boolean (Default: True)
+ deleted: boolean (Default: False)
+ accounts: List<Account> (OneToMany)

## Endpoints


> GET localhost:8081/api/user/{id}

Response Body (JSON):
```
{ 
  "username": "jax teller", 
  "cpf": "01234567891", 
  "accounts": 
[ { 
    "accountTypeDescription": "Current account", 
    "categoryDescription": "Revenue", 
    "balance": "100.0" 
} ] 
}
```

> POST localhost:8081/api/user

Request Body (JSON):
```
{ 
  "username": "jax teller", 
  "cpf": "01234567891" 
}
```

#### User Rules

+ Each user must have a unique CPF
+ The CPF must follow valid formatting rules (e.g., Brazilian CPF standards)

## Entity: Account

### Properties

+ id: Long (Not Null)
+ accountType: Enum AccountType (Not Null) values (CURRENT, SAVINGS)
+ balance: BigDecimal (Not Null)
+ user: User (Not Null)
+ category: Category (Not Null)

## Endpoints

> GET localhost:8081/api/account/{id}

Response Body (JSON):
```
{ 
"accountTypeDescription": "string", 
"categoryDescription": "string", 
"balance": "BigDecimal" 
}
```

> POST localhost:8081/api/account

Request Body (JSON):
```
{ 
"accountTypeId": "1", 
"userId": "7", 
"categoryId": "2", 
"balance": "100.0" 
}
```

#### Account Rules

+ The balance cannot be less than or equal to zero when creating or updating an account
+ The userId must refer to an existing, registered user in the system

## Entity: Category

### Properties

+ id: Long (Not Null)
+ name: String (Not Null)
+ categoryType: Enum CategoryType (Not Null) values (REVENUE, EXPENSE)

#### Technologies used:

<table>
<tr align="center">
<td>Java</td>
<td>Spring Boot</td>
<td>MySQL</td>
<td>MapStruct</td>
</tr>
</table>

> Author: Thalys Henrique

https://www.linkedin.com/in/thalyshenrique7/
