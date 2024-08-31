-- Create the database
CREATE DATABASE books_db;

-- Connect to the newly created database
\c books_db;

-- Create the 'book' table
CREATE TABLE book (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255),
    inventory_quantity INT NOT NULL,
    publisher VARCHAR(255),
    publisher_date DATE,
    isbn VARCHAR(20) UNIQUE
);

-- Insert some sample data
INSERT INTO book (title, author, inventory_quantity, publisher, publisher_date, isbn)
VALUES
    ('The Great Gatsby', 'F. Scott Fitzgerald', 10, 'Scribner', '1925-04-10', '9780743273565'),
    ('1984', 'George Orwell', 8, 'Secker & Warburg', '1949-06-08', '9780451524935'),
    ('To Kill a Mockingbird', 'Harper Lee', 12, 'J.B. Lippincott & Co.', '1960-07-11', '9780060935467'),
    ('The Catcher in the Rye', 'J.D. Salinger', 5, 'Little, Brown and Company', '1951-07-16', '9780316769488'),
    ('Moby-Dick', 'Herman Melville', 6, 'Harper & Brothers', '1851-10-18', '9781503280786');
