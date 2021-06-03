insert into tennis_player (id,date_of_birth,email_address,last_name,first_name) values
(1,'1993-03-03','milan@gmail.com', 'Milankovic','Milan');
insert into tennis_player (id,date_of_birth,email_address,last_name,first_name) values
(2,'1997-09-23','jovana@gmail.com', 'Jovanovic','Jovana');
insert into tennis_player (id,date_of_birth,email_address,last_name,first_name) values
(3,'1990-12-12','petar@gmail.com', 'Petrovic','Petar');
insert into tennis_player (id,date_of_birth,email_address,last_name,first_name) values
(4,'1989-06-13','danica@gmail.com', 'Danic','Danica');
insert into tennis_player (id,date_of_birth,email_address,last_name,first_name) values
(5,'1991-09-14','nikola@gmail.com', 'Nikolic','Nikola');
insert into tennis_player (id,date_of_birth,email_address,last_name,first_name) values
(6,'2000-07-25','ana@gmail.com', 'Antic','Ana');
insert into tennis_player (id,date_of_birth,email_address,last_name,first_name) values
(7,'1999-06-23','sara@gmail.com', 'Saric','Sara');
insert into tennis_player (id,date_of_birth,email_address,last_name,first_name) values
(8,'1981-01-11','viktor@gmail.com', 'Mitic','Vikor');

insert into reservation (id,reservation_date,tennis_player_id) values (1,CURRENT_DATE,1);
insert into reservation (id,reservation_date,tennis_player_id) values (2,CURRENT_DATE,2);
insert into reservation (id,reservation_date,tennis_player_id) values (3,CURRENT_DATE,3);
insert into reservation (id,reservation_date,tennis_player_id) values (4,CURRENT_DATE,4);
insert into reservation (id,reservation_date,tennis_player_id) values (5,CURRENT_DATE,5);
insert into reservation (id,reservation_date,tennis_player_id) values (6,CURRENT_DATE,6);
insert into reservation (id,reservation_date,tennis_player_id) values (7,CURRENT_DATE,7);
insert into reservation (id,reservation_date,tennis_player_id) values (8,CURRENT_DATE,8);

insert into tennis_court (id,tennis_court_name,court_type,price_per_minute) values (1,'ClayA1',1,0.5);
insert into tennis_court (id,tennis_court_name,court_type,price_per_minute) values (2,'ClayA17',2,0.25);
insert into tennis_court (id,tennis_court_name,court_type,price_per_minute) values (3,'Grass6Y9',3,1);
insert into tennis_court (id,tennis_court_name,court_type,price_per_minute) values (4,'Grass012',4,0.75);
insert into tennis_court (id,tennis_court_name,court_type,price_per_minute) values (5,'Court num8',5,1.5);
insert into tennis_court (id,tennis_court_name,court_type,price_per_minute) values (6,'Court num9',6,1.25);
insert into tennis_court (id,tennis_court_name,court_type,price_per_minute) values (7,'Carpet6',7,2);
insert into tennis_court (id,tennis_court_name,court_type,price_per_minute) values (8,'CarpetE78',0,0.76);

insert into time_slot (id,end_date_and_time,start_date_and_time,reservation_id,tennis_court_id)
values (1,'2021-06-02 14:00:00','2021-06-02 13:00:00',1,1);
insert into time_slot (id,end_date_and_time,start_date_and_time,reservation_id,tennis_court_id)
values (2,'2021-06-12 18:30:00','2021-06-12 19:30:00',1,2);
insert into time_slot (id,end_date_and_time,start_date_and_time,reservation_id,tennis_court_id)
values (3,'2021-06-02 19:00:00','2021-06-02 20:00:00',2,3);
insert into time_slot (id,end_date_and_time,start_date_and_time,reservation_id,tennis_court_id)
values (4,'2021-06-03 14:00:00','2021-06-03 13:00:00',3,4);
insert into time_slot (id,end_date_and_time,start_date_and_time,reservation_id,tennis_court_id)
values (5,'2021-06-05 20:00:00','2021-06-05 21:00:00',4,5);
insert into time_slot (id,end_date_and_time,start_date_and_time,reservation_id,tennis_court_id)
values (6,'2021-06-09 17:00:00','2021-06-09 18:20:00',5,6);
insert into time_slot (id,end_date_and_time,start_date_and_time,reservation_id,tennis_court_id)
values (7,'2021-06-02 19:00:00','2021-06-02 20:00:00',7,7);