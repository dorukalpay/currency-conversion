DROP TABLE IF EXISTS conversions;

CREATE TABLE conversions (
  id INTEGER PRIMARY KEY NOT NULL,
  source_currency VARCHAR(3) NOT NULL,
  target_currency VARCHAR(3) NOT NULL,
  source_amount DECIMAL (18,2) NOT NULL,
  converted_amount DECIMAL (18,2) NOT NULL,
  exchange_rate DECIMAL(19,4) NOT NULL,
  date_time TIMESTAMP NOT NULL
);