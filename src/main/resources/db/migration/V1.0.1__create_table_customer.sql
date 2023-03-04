set schema 'customers';
-- Create the customer table
CREATE TABLE  customer
(
    nome          VARCHAR(255) NOT NULL,
    cognome       VARCHAR(255) NOT NULL,
    codiceFiscale VARCHAR(255) NOT NULL,
    indirizzo     VARCHAR(255) NOT NULL,
    PRIMARY KEY (codiceFiscale)
);
