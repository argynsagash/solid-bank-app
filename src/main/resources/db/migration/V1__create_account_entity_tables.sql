CREATE TABLE Account
(
    id               NVARCHAR(40) UNIQUE,
    account_type     NVARCHAR(40) NOT NULL,
    client_id        NVARCHAR(40) NOT NULL,
    balance          FLOAT   NOT NULL,
    withdraw_allowed BOOLEAN NOT NULL,

    CONSTRAINT PK_Account PRIMARY KEY (id)
);

CREATE TABLE Transaction
(

    id               INTEGER UNIQUE,
    transaction_info NVARCHAR(128) NOT NULL,
    account_id       NVARCHAR(40) NOT NULL,

    CONSTRAINT PK_Transaction PRIMARY KEY (id),
    FOREIGN KEY (account_id) REFERENCES Account (id)
);


-- insert into Account_Entity values ('001000001', 'SAVING','1', 0.0, true);

