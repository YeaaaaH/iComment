INSERT INTO categories (id, description, name)
VALUES                 (0, 'fast moving consumer goods', 'FMCG');

INSERT INTO roles (id, name)
VALUES            (0, 'USER');

INSERT INTO companies (id, average_rate, description, name, category_id)
VALUES                (0, 4.4, 'top rated in FMCG category', 'Davo', 0);

INSERT INTO users (id, email, login, name, password, surname)
VALUES            (0, 'email@gmail.com', 'test', 'someName', 'test', 'someSurname');

INSERT INTO users_roles (user_id, role_id)
VALUES                  (0, 0);

INSERT INTO feedbacks (id, date, positive, negative, rate, company_id, user_id)
VALUES                (0, '2020-3-22', 'POSITIVE', 'NEGATIVE', 4, 0, 0);