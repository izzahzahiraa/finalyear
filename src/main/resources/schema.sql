CREATE TABLE ORGANIZATION(
ORGANIZATION_ID INTEGER AUTO_INCREMENT PRIMARY KEY,
ORGANIZATION_NAME VARCHAR (255) NOT NULL,
ORGANIZATION_ADDRESS VARCHAR (255) NOT NULL,
STATE VARCHAR (255) NOT NULL,
ORGANIZATION_EMAIL VARCHAR (255) NOT NULL UNIQUE,
ORGANIZATION_PASS VARCHAR (255) NOT NULL,
ORGANIZATION_ROLE VARCHAR (255) NOT NULL,
ORGANIZATION_ENABLED INTEGER NOT NULL,
ADMIN_ID INTEGER NOT NULL
);

CREATE TABLE CAMPAIGN(
CAMPAIGN_ID INTEGER AUTO_INCREMENT PRIMARY KEY,
CAMPAIGN_PIC BLOB NULL,
CAMPAIGN_TITLE VARCHAR(255) NOT NULL,
CAMPAIGN_GOAL INTEGER NOT NULL,
DATE_START DATE NOT NULL,
DATE_END DATE NOT NULL,
CAMPAIGN_STATUS VARCHAR(50) NOT NULL,
CAMPAIGN_ENABLED INTEGER NOT NULL,
CAMPAIGN_OUTCOME VARCHAR (50) NULL,
);

CREATE TABLE FUNDER(
FUNDER_ID INTEGER AUTO_INCREMENT PRIMARY KEY,
FUNDER_NAME VARCHAR (255) NOT NULL,
FUNDER_EMAIL VARCHAR (255) NOT NULL,
);

CREATE TABLE DONATION(
DONATION_ID INTEGER AUTO_INCREMENT PRIMARY KEY,
DONATION_TYPE VARCHAR(50) NOT NULL,
DONATION_AMOUNT INTEGER NOT NULL,
)

ALTER TABLE CAMPAIGN ADD FOREIGN KEY (ORGANIZATION_ID) REFERENCES ORGANIZATION(ORGANIZATION_ID);
ALTER TABLE DONATION ADD FOREIGN KEY (CAMPAIGN_ID) REFERENCES CAMPAIGN(CAMPAIGN_ID);
ALTER TABLE DONATION ADD FOREIGN KEY (FUNDER_ID) REFERENCES FUNDER(CAMPAIGN_ID);