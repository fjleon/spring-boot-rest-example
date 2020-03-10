# spring-boot-rest-example
Demo project for Spring Boot API Rest


# Collection of requests to test


- GET Request to get a Full User

```
curl --request GET 'http://localhost:8080/user/full?id=1'
```

- GET Request to get a Basic User

```
curl --request GET 'http://localhost:8080/user/basic?id=1'
```

- POST Request to create a new user

```
curl --request POST 'http://localhost:8080/user' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 4,
    "name": "Kevin",
    "email": "kevin@gmail.com",
    "score": "5"
}'
```

- PUT Request to modify an existing user

```
curl --request PUT 'http://localhost:8080/user' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 1,
    "name": "John",
    "email": "new_email@gmail.com",
    "score": 8
}'
```

- DELETE Request to delete an existing user

```
curl --request DELETE 'http://localhost:8080/user?id=4'
```
