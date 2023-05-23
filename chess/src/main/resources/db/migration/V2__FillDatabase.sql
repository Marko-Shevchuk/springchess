INSERT INTO chess.roles (id, name)
VALUES
    (1, 'user'),
    (2, 'admin');

INSERT INTO chess.users (bad_score, casual_rating, creation_time, creator_ip, last_login, nickname, password, ranked_rating, role_id)
VALUES
    (0, 120.0000, '2023-01-01 09:00:00', '192.168.1.100', '2023-01-01 09:00:00', 'user1', 'password1', 150.0000, 1),
    (0, 180.0000, '2023-02-01 12:30:00', '192.168.1.101', '2023-02-01 12:30:00', 'user2', 'password2', 190.0000, 1),
    (0, 160.0000, '2023-03-01 15:45:00', '192.168.1.102', '2023-03-01 15:45:00', 'user3', 'password3', 170.0000, 1),
    (0, 110.0000, '2023-04-01 18:15:00', '192.168.1.103', '2023-04-01 18:15:00', 'user4', 'password4', 130.0000, 1),
    (0, 140.0000, '2023-05-01 10:00:00', '192.168.1.104', '2023-05-01 10:00:00', 'user5', 'password5', 160.0000, 1),
    (0, 170.0000, '2023-06-01 13:30:00', '192.168.1.105', '2023-06-01 13:30:00', 'user6', 'password6', 180.0000, 1),
    (0, 130.0000, '2023-07-01 16:45:00', '192.168.1.106', '2023-07-01 16:45:00', 'user7', 'password7', 150.0000, 1),
    (0, 190.0000, '2023-08-01 19:15:00', '192.168.1.107', '2023-08-01 19:15:00', 'user8', 'password8', 200.0000, 1),
    (0, 150.0000, '2023-09-01 09:30:00', '192.168.1.108', '2023-09-01 09:30:00', 'user9', 'password9', 170.0000, 1),
    (0, 120.0000, '2023-10-01 12:45:00', '192.168.1.109', '2023-10-01 12:45:00', 'user10', 'password10', 140.0000, 1);

INSERT INTO chess.games (affiliation_distribution, black_rating, creation_time, history, ranked, result, termination_cause, time_increment, time_total, white_rating, player_black_id, player_white_id)
VALUES
    ('WHITE', 180.0000, '2023-01-01 09:00:00', '', TRUE, 'NONE', 'NONE', 10, 600, 200.0000, 1, 2),
    ('BLACK', 150.0000, '2023-02-01 12:30:00', '', FALSE, 'NONE', 'NONE', 5, 900, 170.0000, 3, 4),
    ('RANDOM', 160.0000, '2023-03-01 15:45:00', '', TRUE, 'NONE', 'NONE', 15, 1200, 190.0000, 5, 6),
    ('WHITE', 140.0000, '2023-04-01 18:15:00', '', FALSE, 'NONE', 'NONE', 20, 1800, 150.0000, 7, 8),
    ('BLACK', 170.0000, '2023-05-01 10:00:00', '', TRUE, 'NONE', 'NONE', 10, 600, 180.0000, 9, 10);

INSERT INTO chess.lobbies (affiliation_distribution, creation_time, host_casual_rating, host_ranked_rating, competitive, time_increment, time_total, host_id)
VALUES
    ('RANDOM', '2022-01-01 09:00:00', 120.0000, 140.0000, 1, 10, 600, 1),
    ('RANDOM', '2022-02-01 12:30:00', 150.0000, 170.0000, 0, 5, 300, 2),
    ('RANDOM', '2022-03-01 15:45:00', 180.0000, 200.0000, 1, 15, 900, 3),
    ('BLACK', '2022-04-01 18:15:00', 140.0000, 160.0000, 0, 10, 600, 4),
    ('WHITE', '2022-05-01 10:00:00', 170.0000, 190.0000, 1, 20, 1200, 5);