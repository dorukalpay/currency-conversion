DROP TABLE IF EXISTS exchange_rates;

CREATE TABLE exchange_rates (
  id INTEGER PRIMARY KEY NOT NULL,
  source_currency VARCHAR(3) NOT NULL,
  target_currency VARCHAR(3) NOT NULL,
  rate VARCHAR(300) NOT NULL,
  date_time TIMESTAMP NOT NULL
);