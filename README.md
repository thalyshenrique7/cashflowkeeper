## Entity: User

### Properties

+ id: Long (Not Null)
+ firstName: String (Not Null)
+ lastName: String
+ cpf: String (Not Null)
+ active: boolean (Default: True)
+ deleted: boolean (Default: False)
+ accounts: List<Account> (OneToMany)

## Endpoints


> GET localhost:8081/api/user/{id}
Response Body (JSON):
```
{ 
  "firstName": "jax",
  "lastName": "teller", 
  "cpf": "01234567891", 
  "accounts": 
[{
    "accountTypeDescription": "Current account",
    "categoryTypeDescription": "Revenue",
    "categoryName": "test",
    "balance": 100.00
}] 
}
```

> POST localhost:8081/api/user
Request Body (JSON):
```
{ 
  "firstName": "jax",
  "lastName": "teller",
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
+ initialBalance: BigDecimal (Not Null)
+ user: User (Not Null)
+ category: Category (Not Null)
+ balance: BigDecimal (Not Null)

## Endpoints

> GET localhost:8081/api/account/{id}
Response Body (JSON):
```
{
  "accountTypeDescription": "Current account",
  "categoryTypeDescription": "Revenue",
  "categoryName": "test",
  "balance": 100.00
}
```

> POST localhost:8081/api/account
Request Body (JSON):
```
{ 
  "accountType": "CURRENT", 
  "userId": "7", 
  "categoryId": "2", 
  "balance": "100.0" 
}
```

#### Account Rules

+ The balance cannot be less than or equal to zero when creating or updating an account
+ The userId must refer to an existing, registered user in the system
+ The categoryId must refer to an existing, registered category in the system

## Entity: Category

### Properties

+ id: Long (Not Null)
+ name: String (Not Null)
+ categoryType: Enum CategoryType (Not Null) values (REVENUE, EXPENSE)

## Entity: Transaction

### Properties

+ id: Long (Not Null)
+ originAccount: Account (ManyToOne) (Not Null)
+ destinationAccount: Account (ManyToOne)
+ valueTransaction: BigDecimal (Not Null)
+ transactionType: Enum TransactionType (Not Null) values (TRANSFER, DEPOSIT, WITHDRAW)

## Endpoints

> POST localhost:8081/api/transaction
Request Body (JSON):
```
{
  "originAccountId": 3,
  "destinationAccountId": 5,
  "valueTransaction": 100,
  "transactionType": "TRANSFER"
}
```
##### Obs: To transaction type: DEPOSIT and WITHDRAW does not need informed destionationAccountId

#### Transaction Rules

+ Withdrawal value must be greather than zero
+ Balance value must be greather than withdrawal value
+ Savings account don't pay tax for deposit and withdraw transactions <b>(Savings account don't has transfer transaction)</b>
+ Current account has 3 transactions free for month, after that paid two percent tax
+ For transfer transaction, destinationAccountId is required

#### Technologies used:

<table>
<tr align="center">
<td>Java</td>
<td>Spring Boot</td>
<td>MySQL</td>
<td>MapStruct</td>
<td>Kafka</td>
<td>JUnit</td>
</tr>
</table>

> Author: Thalys Henrique
https://www.linkedin.com/in/thalyshenrique7/
