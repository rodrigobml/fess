
create table DUMMY_MEMBER(
    MEMBER_ID INTEGER IDENTITY NOT NULL PRIMARY KEY,
    MEMBER_NAME VARCHAR(200) NOT NULL,
    MEMBER_ACCOUNT VARCHAR(50) NOT NULL,
    MEMBER_STATUS_CODE CHAR(3) NOT NULL,
    FORMALIZED_DATETIME DATETIME,
    BIRTHDATE DATE,
    REGISTER_DATETIME DATETIME NOT NULL,
    REGISTER_USER VARCHAR(200) NOT NULL,
    UPDATE_DATETIME DATETIME NOT NULL,
    UPDATE_USER VARCHAR(200) NOT NULL,
    VERSION_NO BIGINT NOT NULL
);