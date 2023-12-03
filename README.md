# bookstore

CRUD Operations
1) Retrieving a list of all books.
-> GET : localhost:9000/book-service/books

2)  Retrieving a single book by ID.
-> GET : localhost:9000/book-service/book/1

3) Adding a new book
-> POST : localhost:9000/book-service/book
    Request body: {
    "title": "C++",
    "author": "Alex",
    "isbn": 2324567888,
    "publishedDate": 30-11-2023T07:26:14,
    "genre": Computing
}

4) Updating an existing book.
-> PUT : localhost:9000/book-service/book/3
   Request body: {
    "title": "Java",
    "author": "Alex",
    "isbn": 2324567889,
    "publishedDate": 30-11-2023T05:26:14,
    "genre": Computing
}

5) Deleting a book by ID.
->  DELETE: localhost:9000/book-service/book/3


