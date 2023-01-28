CREATE TYPE landlord_app.user_type AS ENUM ('TENANT', 'LANDLORD');

CREATE TABLE landlord_app.users
(
    id         serial PRIMARY KEY,
    name       VARCHAR(50) UNIQUE NOT NULL,
    type       user_type          not null,
    created_at TIMESTAMP          NOT NULL,
    updated_at TIMESTAMP          not NULL,
    created_by VARCHAR(50)        not NULL
);

CREATE TABLE landlord_app.agreements
(
    id               serial PRIMARY KEY,
    start_date       TIMESTAMP   not null,
    end_date         TIMESTAMP,
    tenant_id        INT         not null,
    landlord_id      INT         not null,
    FOREIGN KEY (tenant_id)
        REFERENCES users (id),
    FOREIGN KEY (landlord_id)
        REFERENCES users (id),
    rent_amount      NUMERIC     not null,
    rent_currency    VARCHAR(3)  not null,
    utility_amount   NUMERIC     not null,
    utility_currency VARCHAR(3)  not null,
    milestone_day    INTEGER     not null,
    created_at       TIMESTAMP   NOT NULL,
    updated_at       TIMESTAMP   not NULL,
    created_by       VARCHAR(50) not NULL
);

CREATE TYPE landlord_app.cost_category AS ENUM ('COMMUNAL_COST', 'ELECTRICITY', 'INTERNET', 'HEATING', 'COOLING', 'COLD_WATER', 'HOT_WATER', 'SEWAGE_TREATMENT', 'WATER_HEATING', 'OTHER');

CREATE TABLE landlord_app.invoices
(
    id            serial PRIMARY KEY,
    start_date    TIMESTAMP     not null,
    end_date      TIMESTAMP     not null,
    agreement_id  INT           not null,
    FOREIGN KEY (agreement_id)
        REFERENCES agreements (id),
    amount        NUMERIC       not null,
    cost_category cost_category not null,
    file_name     VARCHAR(100)  not null,
    file_content  BYTEA         not null,
    created_at    TIMESTAMP     NOT NULL,
    updated_at    TIMESTAMP     not NULL,
    created_by    VARCHAR(50)   not NULL
);

CREATE TABLE landlord_app.costs
(
    id            serial PRIMARY KEY,
    start_date    TIMESTAMP     not null,
    end_date      TIMESTAMP     not null,
    agreement_id  INT           not null,
    FOREIGN KEY (agreement_id)
        REFERENCES agreements (id),
    amount        NUMERIC       not null,
    cost_category cost_category not null,
    file_name     VARCHAR(100)  not null,
    file_content  BYTEA         not null,
    created_at    TIMESTAMP     NOT NULL,
    updated_at    TIMESTAMP     not NULL,
    created_by    VARCHAR(50)   not NULL
);