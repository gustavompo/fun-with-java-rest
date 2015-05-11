# Fun with

    - JDK 7
    - Maven 3
    - Guava
    - slf4j/logback
    - Spring
    - Hibernate
    - Jersey / JAX-RS
    - Jackson
    - H2 embedded database
    - JUnit/Hamcrest
    - Mockito
    - PowerMock
    - Spring Test
    - dbUnit

A simple restfull service:

/products
/products/44
/products -> post {name:'a',price:99}

/orders
/orders/22
/orders -> post {date:'', products:[{name:'a',price:99}]}
/orders -> put {orderId:66, date:'', products:[{name:'a',price:99}]}
