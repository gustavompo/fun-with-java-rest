# Interface (resources) documentation #
The avenuecode.jChallenge RESTfull API provides access to the following resources:

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


# About me and the project #
I definitelly knew when I read the challenge description that it would really be a challenge for me. 
For a "native" Java developer, it would be pretty much straightforward and simple, well, a simple RESTfull API with two resources, some integrations and testing is what almost all developers deal with daily... But for me this is the really first time almost every single framework, tool and even the environment. Even what was not actually listed there, like jetty.
So I just had 3 days of exhausting reading, searching and learning about the Spring framework, it's integration with Jersey, persistence with Hibernate, literally everything.

Testing is something I consider really important in a project, it's present in all my works (in C# .Net), but unfortunatelly I couldn't make it work in a simple and professional way. The testing implementations I tried actually could work with some workarounds, but the code was getting uglier... I made the decision to not send it along with the solution. Not doing a professional work is something I don't consider, when it comes to a real project, I preffer to take some time to read a book and documentation and then continue to develop the right way, using the right tools.
I'm not saying the solution I'm presenting is the best one could ever do, of course not, but that was the best I could do given time constraints and this being my first contact with almost all tools presents in it. My attentions and worries were not what have in projects I work daily, just like the best pattern to use, application and service layers, features, etc. My worries were all about the technology (tools, frameworks, libraries, environment) and I confess I could have missed something in the others aspects.

My intention was to keep it empty, but considering everything I stated above, I couldn't let the TODO list of the project empty, here are some items:

* Unit testing the API layer, check for right URL routing and calls to the dependencies
* Integration testing: check for... hmm.. the features, persistence in database and so on
* Error handling - Check for bad inputs and improve the response error messages
* Security - this is something that actually depends on the requirements of the API, but for a "presentation", if I could, I would not let it apart

Probably I'm missing some more items in the TODO list, but these were I remember and took note.