set schema 'customers';
-- Create the customer table
CREATE TABLE device
(
    id                     uuid NOT NULL,
    status                 VARCHAR(255),
    customer_codiceFiscale VARCHAR(255),
    CONSTRAINT pk_device PRIMARY KEY (id)
);
