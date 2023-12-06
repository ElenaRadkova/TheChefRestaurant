-- https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto.data-initialization.using-basic-sql-scripts

-- user roleEntities
INSERT INTO roles (id, role)
VALUES (1, 'ADMIN');
INSERT INTO roles (id, role)
VALUES (2, 'USER');

-- some test users
INSERT INTO users (id, email, full_name, password, username)
VALUES (1, 'admin@admin.com', 'Admin Adminov', '26dd1ba9ae974a70136ea4463046371516661b0601ca0fb83a905876ca549b3473dd524d578e241b', 'admin');

INSERT INTO users (id, email, full_name, password, username)
VALUES (2, 'user@user.com', 'User Userov', '26dd1ba9ae974a70136ea4463046371516661b0601ca0fb83a905876ca549b3473dd524d578e241b', 'user');

INSERT INTO users (id, email, full_name, password, username)
VALUES (3, 'ivan@ivan.com', 'Ivan Ivanov', '26dd1ba9ae974a70136ea4463046371516661b0601ca0fb83a905876ca549b3473dd524d578e241b', 'ivan');
-- user roleEntities
-- admin
INSERT INTO users_roles (`user_entity_id`, `roles_id`)
VALUES (1, 1);
INSERT INTO users_roles (`user_entity_id`, `roles_id`)
VALUES (1, 2);
-- user
INSERT INTO users_roles (`user_entity_id`, `roles_id`)
VALUES (2, 2);
-- user 2
INSERT INTO users_roles (`user_entity_id`, `roles_id`)
VALUES (3, 2);
INSERT INTO users_roles (`user_entity_id`, `roles_id`)
VALUES (3, 1);

-- categories
INSERT INTO categories (id, description, name)
VALUES ('1', 'Reservation for individual guests.', 'INDIVIDUAL');
INSERT INTO categories (id, description, name)
VALUES ('2', 'Reservation for company parties and cocktails.', 'COCKTAIL');
INSERT INTO categories (id, description, name)
VALUES ('3', 'Reservation for special event.', 'CELEBRATE');



-- reservationEntity
INSERT INTO reservations ( name, phone_number, special_request, date_time, section, count_people, author_id)
VALUES
    ('Иван Иванов',
     '+359887005887',
     'Бихме искали масата да бъде далеч от музиката и в близост до бара.',
     '2023-12-09 19:30:00',
     'SALON', '3', 1);


INSERT INTO reservations ( name, phone_number, special_request, date_time, section, count_people, author_id)
VALUES
    ('Гергана Иванова',
     '+359886123123',
     'Бихме желали, масите да бъдат тип щъркели за правостоящи, без жива музика. Храната да бъде на хапки, вода, безалкохолно, вино. Допълнително ще се поръчва на място.',
     '2023-12-22 18:00:00',
     'TERRACE', '35', 2);

INSERT INTO reservations ( name, phone_number, special_request, date_time, section, count_people, author_id)
VALUES
    ('Gabriela Jonson',
     '+40100213546',
     'I would like to celebrate my birthday and have a birthday cake',
     '2023-12-05 19:00:00',
     'VIP_ZONE', '15', 1);

INSERT INTO reservations ( name, phone_number, special_request, date_time, section, count_people, author_id)
VALUES
    ('Ваня Маринова',
     '+359885321123',
     'Желаем романтична вечеря в по-уединена маса',
     '2023-12-01 20:00:00',
     'SALON', '2', 1);

INSERT INTO reservations ( name, phone_number, special_request, date_time, section, count_people, author_id)
VALUES
    ('Петър Петров',
     '+359883654123',
     'Бихме искали да отпразнуваме кръщенето на сина ни. Бихме искали да има жива музика и място за танци',
     '2023-12-01 14:30:00',
     'SALON', '50', 1);

INSERT INTO comments (`approved`, `created`, `text_content`, `author_id`, `reservation_id`)
VALUES
    (1, '2021-11-14 08:10:40', 'Perfect dinner!', 1, 1),
    (0, '2021-11-14 08:10:40', 'Excellent food', 1, 1);


INSERT INTO reservations_categories VALUES (1,1);
INSERT INTO reservations_categories VALUES (1,2);
INSERT INTO reservations_categories VALUES (2,1);
INSERT INTO reservations_categories VALUES (2,2);
INSERT INTO reservations_categories VALUES (2,3);
INSERT INTO reservations_categories VALUES (3,1);
INSERT INTO reservations_categories VALUES (3,2);


INSERT INTO pictures(title, url, author_id, reservation_id)
VALUES ('Кръщенка', 'http://res.cloudinary.com/elenak/image/upload/v1701779984/ybv4upn1yn11nypucxas.jpg', 1, 1);

INSERT INTO pictures(title, url, author_id, reservation_id)
VALUES ('Рожден ден', 'http://res.cloudinary.com/elenak/image/upload/v1701779940/b7qb9gblqv3kyhfietaw.jpg', 1, 1);

INSERT INTO pictures(title, url, author_id, reservation_id)
VALUES ('Коктейл', 'http://res.cloudinary.com/elenak/image/upload/v1701779964/mzcfwvsybyydcs0g6fvt.jpg', 1, 2);

INSERT INTO pictures(title, url, author_id, reservation_id)
VALUES ('Вечеря', 'http://res.cloudinary.com/elenak/image/upload/v1701780762/awgd8jimjidlz7yuavbp.jpg', 1, 2);

INSERT INTO pictures(title, url, author_id, reservation_id)
VALUES ('Елена-абитуриент', 'http://res.cloudinary.com/elenak/image/upload/v1701779897/otaucya2y5kuhzzryf8x.jpg', 1, 3);

INSERT INTO pictures(title, url, author_id, reservation_id)
VALUES ('Алекс-кръщене', 'http://res.cloudinary.com/elenak/image/upload/v1701779914/ebmwnnxyrvg16oijzuao.jpg', 1, 3);

INSERT INTO pictures(title, url, author_id, reservation_id)
VALUES ('Gabriela-birthday', 'http://res.cloudinary.com/elenak/image/upload/v1701780010/y5tnahwatpuytyyyjuxz.jpg', 1, 4);





