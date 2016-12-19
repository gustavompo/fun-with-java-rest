# Interface (resources) documentation #
The jChallenge RESTfull API provides access to the following resources:

/orders
/products

Just following RESTfull concepts, the resources provides operations through HTTP verbs and mapping items and properties by url path:

**Orders resource**

GET  -> /orders         >> Lists all orders

GET  -> /orders/{id}    >> Retrieves the order with the informed id

POST -> /orders         >> Inserts a new order

PUT  -> /orders/{id}    >> Updates the order with the informed id



**Products resource**

GET  -> /products       >> Lists all products

GET  -> /products/{id}  >> Retrieves the product with the informed id

For the list methods, two aditional (and optional) arguments are available in the query string: limit and offset.
Limit parameter determines the quantity of results to be returned and offset the ammount of elements to skip at the start.
For example: /orders?offset=15&limit=5 will retrieve 5 orders starting at the 16th.


### Adding a new order ###
To add a new order, as stated above, the http verb is POST in the /orders resource.
- Request: This resource accepts a Order(input) object defined by the following structure:

```
#!javascript

{
    date: @date,                    //the order date and time
    orderItems: [{                  //collection with the order items
        product: { 
            productId: @integer     //id of the productg
        }, 
        quantity: @integer          //quantity of the product
    }]
}
```

- Result: The result to be expected is a 302 CREATED status code


### Modifying an existing order ###
To modify an existing order the .verb to be used is PUT in the /orders/{id} resource where {id} is the id of the order to be modified
- Request: This resource accepts the same Order(input) object as the insert method (POST).
- Result: The result to be expected is a 200 OK status code


### Retrieving a list of orders ###
To retrieve a list of orders just do a GET in the /orders resource.
Limit and offset parameters are available in this method (see above).

- Result: The result to be expected is a 200 OK status code with the following data structure:

```
#!javascript

[
    {
        orderId: @integer,          
        orderDate: @date
        orderItems: [{
            productId: @integer,
            quantity: @integer
        }]
    }
    /* more orders */
]
```


### Retrieving an order ###
To retrieve an order just do a GET in the /orders/{id} resource where {id} is the id of the order to be retrieved.

- Result: The result to be expected is a 200 OK status code with the following data structure:

```
#!javascript

{
    orderId: @integer,          
    orderDate: @date
    orderItems: [{
        productId: @integer,
        quantity: @integer
    }]
}
```


### Retrieving a list of products ###
To retrieve a list of products, use GET verb in the /products resource.
Limit and offset parameters are available in this method (see above).

- Result: The result to be expected is a 200 OK status code with the following data structure:

```
#!javascript

[
    {
        productId: @integer,            
        name: @string,
        price: @double
    }
    /* more products */
]
```


### Retrieving a product ###
To retrieve a single product just do a GET in the /products/{id} resource where {id} is the id of the product to be retrieved.

- Result: The result to be expected is a 200 OK status code with the following data structure:

```
#!javascript

{
    productId: @integer,            
    name: @string,
    price: @double
}
```



# Solution documentation #

The dependencies are pretty much the ones already included in the original project, the only one added was modelmapper which helped mapping objects to output dtos.

To run, just: **mvn jetty:run**

To test: **mvn test**

