CREATE TABLE donor (
                       id SERIAL PRIMARY KEY,
                       fullname VARCHAR(255) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE payment_type (
                              id SERIAL PRIMARY KEY,
                              name VARCHAR(50) NOT NULL UNIQUE
);

INSERT INTO payment_type (name) VALUES
                                    ('ORANGE_MONEY'),
                                    ('MVOLA'),
                                    ('AIRTEL_MONEY');

CREATE TABLE payment_status (
                                id SERIAL PRIMARY KEY,
                                name VARCHAR(50) NOT NULL UNIQUE
);

INSERT INTO payment_status (name) VALUES
                                      ('VERIFYING'),
                                      ('SUCCEEDED'),
                                      ('FAILED');

CREATE TABLE payment (
                         id VARCHAR(255) PRIMARY KEY,
                         payment_date TIMESTAMP WITH TIME ZONE NOT NULL,
                         amount BIGINT NOT NULL,
                         donor_id INTEGER NOT NULL REFERENCES donor(id),
                         payment_type_id INTEGER NOT NULL REFERENCES payment_type(id),
                         payment_status_id INTEGER NOT NULL REFERENCES payment_status(id),
                         created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE donation (
                          id SERIAL PRIMARY KEY,
                          payment_id VARCHAR(255) NOT NULL UNIQUE REFERENCES payment(id),
                          created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE beneficiary (
                             id SERIAL PRIMARY KEY,
                             email VARCHAR(255) NOT NULL UNIQUE,
                             created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE help (
                      id SERIAL PRIMARY KEY,
                      amount BIGINT NOT NULL,
                      description TEXT NOT NULL,
                      beneficiary_id INTEGER NOT NULL REFERENCES beneficiary(id),
                      created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tsinjo (
                        id SERIAL PRIMARY KEY,
                        cash BIGINT NOT NULL DEFAULT 0,
                        updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO tsinjo (cash) VALUES (0);

CREATE INDEX idx_payment_donor ON payment(donor_id);
CREATE INDEX idx_payment_status ON payment(payment_status_id);
CREATE INDEX idx_help_beneficiary ON help(beneficiary_id);