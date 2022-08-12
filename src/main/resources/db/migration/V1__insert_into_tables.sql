INSERT INTO address (id, building_number, city, country, postcode, street, created_at, created_by) VALUES
(42413814214, '4A', 'Zenica', 'Bosnia and Herzegovina', '72000', 'Makovi', '2022-05-18 11:42:50', 'flyway'),
(42413855751, '7A', 'Sarajevo', 'Bosnia and Herzegovina', '71000', 'Bascarscija', '2022-05-18 11:42:50', 'flyway');

INSERT INTO brand (id, brand_desc, brand_name, email, phone_number, website,created_at, created_by) VALUES
(1922443234, 'A Bosnian brand that produces medications', 'Bosnalijek', 'info@bosnalijek.ba', '033213456', 'www.bosnalijek.ba', '2022-05-18 11:42:50', 'flyway'),
(1123543131, 'A Bosnian brand that produces medications', 'ZadaPharmaceuticals', 'info@zadapharma.ba', '035243486', 'www.zadapharma.ba', '2022-05-18 11:42:50', 'flyway');

INSERT INTO customer(id, drug_allergic_to, email, first_name, is_verified, last_name, phone_number, address_id, date_joined, created_at, created_by) VALUES
(2828282822, 'PARACETAMOL', 'avdotigar@gmail.com', 'Avdo', true, 'Hamzic', '062355221', 42413814214, '2022-02-10 11:42:50', '2022-05-18 11:42:50', 'flyway'),
(2145236589, 'ANDOL', '', 'Izet', false, 'Nanovic', '060325444', 42413855751, '2021-03-1 11:42:50', '2022-05-18 11:42:50', 'flyway');

INSERT INTO supplier (id, contract_expires, contract_signed, supplier_desc, supplier_name, created_at,created_by) VALUES
(2941782423, '2032-04-25', '2022-04-25', 'A famous French supplier of medical supplies', 'Aventis', '2022-05-18 11:42:50', 'flyway'),
(2456987452, '2033-08-15', '2022-04-20', 'A famous French supplier of beauty products', 'Channel', '2022-05-18 11:42:50', 'flyway');

INSERT INTO product_type (id, product_type, product_type_desc, created_at, created_by) VALUES
(2828847862, 'Skincare', 'An ointment to keep your skin moisturized', '2022-05-18 11:42:50', 'flyway'),
(1493654785, 'Medication', 'One pill a day keeps the doctor away', '2022-05-18 11:42:50', 'flyway');

INSERT INTO inventory (id, description, expiry_date, item_name, price, quantity, sku, sold, brand_id , product_type_id, supplier_id, created_at, created_by) VALUES
(2940486483, 'A pill that keeps your heart well', '2032-04-25', 'PARACETAMOL', 1, 100, '927832675', 50, 1922443234, 2828847862, 2941782423, '2022-05-18 11:42:50', 'flyway'),
(2140025635, 'A pill that regulates blood pressure', '2032-11-14', 'ANDOL', 1, 150, '997532175', 75, 1123543131, 1493654785, 2456987452, '2022-05-18 11:42:50', 'flyway');

INSERT INTO orders (id, date_time_ordered, instructions_to_customer, customer_id, inventory_id, created_at, created_by) VALUES
(2827345800, '2022-04-25 08:40:57', 'Do not forget to consult with your doctor first.', 2828282822, 2940486483, '2022-05-18 11:42:50', 'flyway'),
(2451788896, '2022-04-26 09:20:32', 'Do not forget to consult with your doctor first.', 2145236589, 2140025635, '2022-05-18 11:42:50', 'flyway');

INSERT INTO facility (id, created_at, created_by, date_opened, email, facility_name, phone_number, website, address_id, inventory_id, orders_id) VALUES
(2140025135, '2022-05-18 11:42:50', 'flyway', '2012-05-18 11:42:50', 'zadapharm@gmail.com', 'ZadaPharm', '035123457', 'www.zadapharm.com', 42413814214, 2940486483, 2451788896),
(2946486483, '2022-05-18 11:42:50', 'flyway', '2002-05-18 11:42:50', 'pharmamed@hotmail.com', 'Pharmamed', '030123457', 'www.pharmamed.com', 42413855751, 2140025635, 2827345800);

INSERT INTO roles(id, name) VALUES
(1234767802, 'MODERATOR'),
(2234267803, 'ADMIN'),
(3234167806, 'STAFF'),
(4234667804, 'CUSTOMER'),
(5234067808, 'GUEST');

INSERT INTO users(id, name, username, password, created_at, created_by) VALUES
(1235654784521, 'Muharem', 'MukiMod', '$2a$10$OAnWVEaX5Jqfz1XsEh2tU.J61X4lYERFUyYt1KDJapitBg2Me6c4i', '2022-05-18 11:42:50', 'flyway'),
(2354478854412, 'Izet', 'IzetAdm', '$2a$10$8lDTb5fX.HVTyUjvtZbO9eWtzz8l.vCalYioyrG38cFLARbmVWj5K', '2022-05-18 11:42:52', 'flyway'),
(1023445234789, 'Nail', 'NailSta', '$2a$10$mME6BQyNyx3lBtGuWaT3p.ZcOzYeQWu/F5jUnkBR5J6ojbD5ri0TG', '2022-05-18 11:42:55', 'flyway'),
(1215489523654, 'Meho', 'MehoCust', '$2a$10$mMA6BQyNyx3lBtGuWaT7p.ZcOzYeQWu/F5jUnkBR5J6ojbD1ri0TG', '2022-05-18 11:42:56', 'flyway'),
(9123654785922, 'Ahmed', 'AhmedGue', '$2a$10$mDE6BQyNyx3lBtGuWaT1p.ZcOzYeQWu/F5jUnkBR5J6ojbD7ri0TG', '2022-05-18 11:42:58', 'flyway');

INSERT INTO users_roles(users_entity_id, roles_id) VALUES
(1235654784521, 1234767802),
(2354478854412, 2234267803),
(1023445234789, 3234167806),
(1215489523654, 4234667804),
(9123654785922, 5234067808);

