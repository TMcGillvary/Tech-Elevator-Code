BEGIN TRANSACTION;

DROP TABLE IF EXISTS art, artist, customer, transaction_history CASCADE;

CREATE TABLE artist (
  artist_id SERIAL,
  art_id INT,
  name VARCHAR(100),
  CONSTRAINT PK_artist_id PRIMARY KEY(artist_id)
);

CREATE TABLE art (
  art_id SERIAL,
  artist_id INT NOT NULL,
  title VARCHAR(100),
  CONSTRAINT PK_art_id PRIMARY KEY(art_id)
);

ALTER TABLE art ADD CONSTRAINT FK_art_artist FOREIGN KEY(artist_id) REFERENCES artist(artist_id);

CREATE TABLE customer (
  customer_id SERIAL,
  name VARCHAR(100),
  street_address VARCHAR(100),
  city VARCHAR(100),
  state_abbreviation CHAR(2),
  postal_code VARCHAR(6),
  phone_number INT,
  CONSTRAINT PK_customer_id PRIMARY KEY(customer_id)
);

CREATE TABLE transaction_history (
  id SERIAL,
  art_id INT NOT NULL,
  customer_id INT NOT NULL,
  purchase_date DATE,
  sale_price MONEY,
  CONSTRAINT PK_transaction_id PRIMARY KEY(id),
  CONSTRAINT FK_art_transaction FOREIGN KEY(art_id) REFERENCES art(art_id),
  CONSTRAINT FK_customer_transaction FOREIGN KEY(customer_id) REFERENCES customer(customer_id)
);

COMMIT;