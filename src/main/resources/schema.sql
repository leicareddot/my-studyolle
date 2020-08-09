DROP TABLE IF EXISTS account;

CREATE TABLE account
(
    id                                  BIGINT  NOT NULL
                                        CONSTRAINT account_pkey
                                        PRIMARY KEY,
    bio                                 VARCHAR(255),
    email                               VARCHAR(255)
                                        CONSTRAINT uk_q0uja26qgu1atulenwup9rxyr
                                        UNIQUE,
    email_check_token                   VARCHAR(255),
    email_check_token_generated_at      TIMESTAMP ,
    email_verified                      BOOLEAN NOT NULL,
    joined_at                           timestamp,
    location                            VARCHAR(255),
    nickname                            VARCHAR(255)
                                        CONSTRAINT uk_s2a5omeaik0sruawqpvs18qfk
                                        UNIQUE,
    occupation                          VARCHAR(255),
    password                            VARCHAR(255),
    profile_image                       TEXT,
    study_created_by_email              BOOLEAN NOT NULL,
    study_created_by_web                BOOLEAN NOT NULL,
    study_enrollment_result_by_email    BOOLEAN NOT NULL,
    study_enrollment_result_by_web      BOOLEAN NOT NULL,
    study_updated_by_email              BOOLEAN NOT NULL,
    study_updated_by_web                BOOLEAN NOT NULL,
    url                                 VARCHAR(255)
);