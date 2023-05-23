
-- -----------------------------------------------------
-- Schema chess
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS chess DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE chess ;

-- -----------------------------------------------------
-- Table chess.roles
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS chess.roles (
                                           id BIGINT NOT NULL AUTO_INCREMENT,
                                           name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table chess.users
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS chess.users (
                                           id BIGINT NOT NULL AUTO_INCREMENT,
                                           bad_score SMALLINT NOT NULL,
                                           casual_rating DECIMAL(13,4) NOT NULL,
    creation_time DATETIME(6) NOT NULL,
    creator_ip VARCHAR(255) NOT NULL,
    last_login DATETIME(6) NOT NULL,
    nickname VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    ranked_rating DECIMAL(13,4) NOT NULL,
    role_id BIGINT NULL DEFAULT NULL,
    PRIMARY KEY (id),
    INDEX FKp56c1712k691lhsyewcssf40f (role_id ASC) VISIBLE,
    CONSTRAINT FKp56c1712k691lhsyewcssf40f
    FOREIGN KEY (role_id)
    REFERENCES chess.roles (id))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table chess.games
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS chess.games (
                                           id BIGINT NOT NULL AUTO_INCREMENT,
                                           affiliation_distribution VARCHAR(255) NULL DEFAULT NULL,
    black_rating DECIMAL(13,4) NOT NULL,
    creation_time DATETIME(6) NOT NULL,
    history VARCHAR(255) NOT NULL,
    ranked BIT(1) NOT NULL,
    result VARCHAR(255) NULL DEFAULT NULL,
    termination_cause VARCHAR(255) NULL DEFAULT NULL,
    time_increment INT NOT NULL,
    time_total BIGINT NOT NULL,
    white_rating DECIMAL(13,4) NOT NULL,
    player_black_id BIGINT NULL DEFAULT NULL,
    player_white_id BIGINT NULL DEFAULT NULL,
    PRIMARY KEY (id),
    INDEX FKow104ihs0fq7faa4j780f630n (player_black_id ASC) VISIBLE,
    INDEX FKot6i68aeejgqda66wnuinksvg (player_white_id ASC) VISIBLE,
    CONSTRAINT FKot6i68aeejgqda66wnuinksvg
    FOREIGN KEY (player_white_id)
    REFERENCES chess.users (id),
    CONSTRAINT FKow104ihs0fq7faa4j780f630n
    FOREIGN KEY (player_black_id)
    REFERENCES chess.users (id))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table chess.lobbies
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS chess.lobbies (
                                             id BIGINT NOT NULL AUTO_INCREMENT,
                                             affiliation_distribution VARCHAR(255) NULL DEFAULT NULL,
    creation_time DATETIME(6) NOT NULL,
    host_casual_rating DECIMAL(13,4) NOT NULL,
    host_ranked_rating DECIMAL(13,4) NOT NULL,
    competitive BIT(1) NOT NULL,
    time_increment INT NOT NULL,
    time_total BIGINT NOT NULL,
    host_id BIGINT NULL DEFAULT NULL,
    PRIMARY KEY (id),
    INDEX FKku0xjuv3yydatips0sn2cb3ji (host_id ASC) VISIBLE,
    CONSTRAINT FKku0xjuv3yydatips0sn2cb3ji
    FOREIGN KEY (host_id)
    REFERENCES chess.users (id))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

