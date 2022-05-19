CREATE TABLE Account_Entity
(
    id NVARCHAR(40) ,
    account_type NVARCHAR(40)  NOT NULL,
    client_id NVARCHAR(40)  NOT NULL,
    balance FLOAT NOT NULL,
    withdraw_allowed BOOLEAN NOT NULL,

    CONSTRAINT PK_Account_Entity PRIMARY KEY  (id)
);

-- insert into Account_Entity values ('001000001', 'SAVING','1', 0.0, true);

