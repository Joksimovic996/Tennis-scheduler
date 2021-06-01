insert into tennis_player (date_of_birth,email,last_name,name) values
('1993-03-03','milanMilankovic@gmail.com', 'Milankovic','Milan');
insert into tennis_player (date_of_birth,email,last_name,name) values
('1997-09-23','jovanaJovanovic@gmail.com', 'Jovanovic','Jovana');
insert into tennis_player (date_of_birth,email,last_name,name) values
('1990-12-12','petarPetrovic@gmail.com', 'Petrovic','Petar');
insert into tennis_player (date_of_birth,email,last_name,name) values
('1989-06-13','danicaDanic@gmail.com', 'Danic','Danica');
insert into tennis_player (date_of_birth,email,last_name,name) values
('1991-09-14','nikolaNikolic@gmail.com', 'Nikolic','Nikola');
insert into tennis_player (date_of_birth,email,last_name,name) values
('2000-07-25','anaAntic@gmail.com', 'Antic','Ana');
insert into tennis_player (date_of_birth,email,last_name,name) values
('1999-06-23','saraSaric@gmail.com', 'Saric','Sara');
insert into tennis_player (date_of_birth,email,last_name,name) values
('1981-01-11','viktorMitic@gmail.com', 'Mitic','Vikor');

insert into court_price (court_type,price_per_minute) values (1,0.5);
insert into court_price (court_type,price_per_minute) values (2,0.25);
insert into court_price (court_type,price_per_minute) values (3,1);
insert into court_price (court_type,price_per_minute) values (4,0.75);
insert into court_price (court_type,price_per_minute) values (5,1.5);
insert into court_price (court_type,price_per_minute) values (6,1.25);
insert into court_price (court_type,price_per_minute) values (7,2);
insert into court_price (court_type,price_per_minute) values (8,1.76);

insert into reservation (reservation_date,tennis_player_id) values (CURRENT_DATE,1);
insert into reservation (reservation_date,tennis_player_id) values (CURRENT_DATE,2);
insert into reservation (reservation_date,tennis_player_id) values (CURRENT_DATE,3);
insert into reservation (reservation_date,tennis_player_id) values (CURRENT_DATE,4);
insert into reservation (reservation_date,tennis_player_id) values (CURRENT_DATE,5);
insert into reservation (reservation_date,tennis_player_id) values (CURRENT_DATE,6);
insert into reservation (reservation_date,tennis_player_id) values (CURRENT_DATE,7);
insert into reservation (reservation_date,tennis_player_id) values (CURRENT_DATE,8);

insert into tennis_court (tennis_court_name,court_price_id) values ('ClayA1',1);
insert into tennis_court (tennis_court_name,court_price_id) values ('ClayA17',2);
insert into tennis_court (tennis_court_name,court_price_id) values ('Grass6Y9',3);
insert into tennis_court (tennis_court_name,court_price_id) values ('Grass012',4);
insert into tennis_court (tennis_court_name,court_price_id) values ('Court num8',5);
insert into tennis_court (tennis_court_name,court_price_id) values ('Court num9',6);
insert into tennis_court (tennis_court_name,court_price_id) values ('Carpet6',7);
insert into tennis_court (tennis_court_name,court_price_id) values ('CarpetE78',8);

insert into time_slot (end_date_and_time,start_date_and_time,reservation_id,tennis_court_id)
values ('2021-06-02 14:00:00','2021-06-02 13:00:00',1,1);
insert into time_slot (end_date_and_time,start_date_and_time,reservation_id,tennis_court_id)
values ('2021-06-12 18:30:00','2021-06-12 19:30:00',1,2);
insert into time_slot (end_date_and_time,start_date_and_time,reservation_id,tennis_court_id)
values ('2021-06-02 19:00:00','2021-06-02 20:00:00',2,3);
insert into time_slot (end_date_and_time,start_date_and_time,reservation_id,tennis_court_id)
values ('2021-06-03 14:00:00','2021-06-03 13:00:00',3,4);
insert into time_slot (end_date_and_time,start_date_and_time,reservation_id,tennis_court_id)
values ('2021-06-05 20:00:00','2021-06-05 21:00:00',4,5);
insert into time_slot (end_date_and_time,start_date_and_time,reservation_id,tennis_court_id)
values ('2021-06-09 17:00:00','2021-06-09 18:20:00',5,6);
insert into time_slot (end_date_and_time,start_date_and_time,reservation_id,tennis_court_id)
values ('2021-06-02 19:00:00','2021-06-02 20:00:00',7,7);