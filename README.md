# TransactionswithSpringBoot
This is a simple example that shows how to implement transactions in Spring Boot using the @Transactional annotation.
Note: The @transactional annotations only work with Unchecked Exceptions.

This example uses two database tables to show how rollback works then data is entered simultaneously.
Here data in two tables get entered, both using same id. So if the id is deleted in one table and it remains in other
while we enter data with that same id, it will rollback because ok primary key exception as that Id is available there.

It is a bit tricky but you have understand how it works.

Happy Coding!
