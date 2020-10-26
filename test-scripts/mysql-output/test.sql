DROP TABLE IF EXISTS EMBULK_OUTPUT;

CREATE TABLE EMBULK_OUTPUT (
    ID     INT,
    NUM    DECIMAL(12,2),
    STR    CHAR(8),
    VARSTR VARCHAR(8),
    DT     DATE,
    DTTM0  DATETIME,
    DTTM3  DATETIME(3),
    PRIMARY KEY(ID)
);