IF NOT EXISTS (SELECT 1 FROM category WHERE label = 'Roman')
INSERT INTO category (label, description)
VALUES ('Roman', 'Livres de fiction');

IF NOT EXISTS (SELECT 1 FROM category WHERE label = 'Science')
INSERT INTO category (label, description)
VALUES ('Science', 'Livres scientifiques');

IF NOT EXISTS (SELECT 1 FROM category WHERE label = 'Histoire')
INSERT INTO category (label, description)
VALUES ('Histoire', 'Livres historiques');

IF NOT EXISTS (SELECT 1 FROM category WHERE label = 'Informatique')
INSERT INTO category (label, description)
VALUES ('Informatique', 'Livres IT et programmation');


IF NOT EXISTS (SELECT 1 FROM users WHERE email = 'alice@mail.com')
INSERT INTO users (first_name, last_name, email, password, phone, role, active, blocked, registration_date)
VALUES ('Alice', 'Dupont', 'alice@mail.com', 'pwd123', '0600000001', 'USER', 1, 0, CURRENT_TIMESTAMP);

IF NOT EXISTS (SELECT 1 FROM users WHERE email = 'bob@mail.com')
INSERT INTO users (first_name, last_name, email, password, phone, role, active, blocked, registration_date)
VALUES ('Bob', 'Martin', 'bob@mail.com', 'pwd123', '0600000002', 'USER', 1, 0, CURRENT_TIMESTAMP);

IF NOT EXISTS (SELECT 1 FROM users WHERE email = 'charlie@mail.com')
INSERT INTO users (first_name, last_name, email, password, phone, role, active, blocked, registration_date)
VALUES ('Charlie', 'Durand', 'charlie@mail.com', 'pwd123', '0600000003', 'ADMIN', 1, 0, CURRENT_TIMESTAMP);

IF NOT EXISTS (SELECT 1 FROM users WHERE email = 'david@mail.com')
INSERT INTO users (first_name, last_name, email, password, phone, role, active, blocked, registration_date)
VALUES ('David', 'Leroy', 'david@mail.com', 'pwd123', '0600000004', 'ADMIN', 0, 1, CURRENT_TIMESTAMP);

IF NOT EXISTS (SELECT 1 FROM book WHERE isbn = '1111111111')
INSERT INTO book (title, author, isbn, description, category_id, total_copies, available_copies, average_rating, date_added)
VALUES ('Le Petit Prince', 'Antoine de Saint-Exupéry', '1111111111', 'Conte philosophique', 1, 5, 3, 4.5, CURRENT_TIMESTAMP);

IF NOT EXISTS (SELECT 1 FROM book WHERE isbn = '2222222222')
INSERT INTO book (title, author, isbn, description, category_id, total_copies, available_copies, average_rating, date_added)
VALUES ('Une brève histoire du temps', 'Stephen Hawking', '2222222222', 'Cosmologie', 2, 3, 2, 4.7, CURRENT_TIMESTAMP);

IF NOT EXISTS (SELECT 1 FROM book WHERE isbn = '3333333333')
INSERT INTO book (title, author, isbn, description, category_id, total_copies, available_copies, average_rating, date_added)
VALUES ('Sapiens', 'Yuval Noah Harari', '3333333333', 'Histoire de l’humanité', 3, 4, 4, 4.6, CURRENT_TIMESTAMP);

IF NOT EXISTS (SELECT 1 FROM book WHERE isbn = '4444444444')
INSERT INTO book (title, author, isbn, description, category_id, total_copies, available_copies, average_rating, date_added)
VALUES ('Clean Code', 'Robert C. Martin', '4444444444', 'Bonnes pratiques dev', 4, 2, 1, 4.8, CURRENT_TIMESTAMP);

   IF NOT EXISTS (
    SELECT 1 FROM loans
    WHERE id_book = 1 AND id_user = 1
)
INSERT INTO loans (id_book, id_user, borrow_date, excepted_return_date, actual_return_date, loan_status, late_days)
VALUES (1, 1, DATEADD(DAY, -10, CURRENT_TIMESTAMP), DATEADD(DAY, -2, CURRENT_TIMESTAMP), DATEADD(DAY, -1, CURRENT_TIMESTAMP), 'RENDU', 1);


      IF NOT EXISTS (
    SELECT 1 FROM reservation
    WHERE id_book = 4 AND id_user = 2
)
INSERT INTO reservation (id_book, id_user, status, date)
VALUES (4, 2, 'ATTENTE', CURRENT_TIMESTAMP);

IF NOT EXISTS (
    SELECT 1 FROM reservation
    WHERE id_book = 1 AND id_user = 3
)
INSERT INTO reservation (id_book, id_user, status, date)
VALUES (1, 3, 'DISPONIBLE', CURRENT_TIMESTAMP);

   IF NOT EXISTS (
    SELECT 1 FROM rating WHERE id_book = 1 AND id_user = 1
)
INSERT INTO rating (id_book, id_user, value, date)
VALUES (1, 1, 5, CURRENT_TIMESTAMP);


      IF NOT EXISTS (
    SELECT 1 FROM comment WHERE id_book = 1 AND id_user = 1
)
INSERT INTO comment (id_book, id_user, description, status, date_publication, date_modify)
VALUES (1, 1, 'Excellent livre !', 'VISIBLE', CURRENT_TIMESTAMP, NULL);

         IF NOT EXISTS (
    SELECT 1 FROM notification WHERE id_user = 1 AND message = 'Veuillez retourner votre livre'
)
INSERT INTO notification (id_user, type, message, is_reading, date_create, date_reading)
VALUES (1, 'RETARD', 'Veuillez retourner votre livre', 0, CURRENT_TIMESTAMP, NULL);