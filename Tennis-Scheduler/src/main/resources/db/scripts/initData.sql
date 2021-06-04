insert into tennis_player (date_of_birth,email_address,last_name,first_name) values
    ('1993-03-03','milan@gmail.com', 'Milankovic','Milan');
insert into tennis_player (date_of_birth,email_address,last_name,first_name) values
    ('1997-09-23','jovana@gmail.com', 'Jovanovic','Jovana');
insert into tennis_player (date_of_birth,email_address,last_name,first_name) values
    ('1990-12-12','petar@gmail.com', 'Petrovic','Petar');
insert into tennis_player (date_of_birth,email_address,last_name,first_name) values
    ('1989-06-13','danica@gmail.com', 'Danic','Danica');
insert into tennis_player (date_of_birth,email_address,last_name,first_name) values
    ('1991-09-14','nikola@gmail.com', 'Nikolic','Nikola');
insert into tennis_player (date_of_birth,email_address,last_name,first_name) values
    ('2000-07-25','ana@gmail.com', 'Antic','Ana');
insert into tennis_player (date_of_birth,email_address,last_name,first_name) values
    ('1999-06-23','sara@gmail.com', 'Saric','Sara');
insert into tennis_player (date_of_birth,email_address,last_name,first_name) values
    ('1981-01-11','viktor@gmail.com', 'Mitic','Vikor');

insert into reservation (reservation_date,tennis_player_id) values (CURRENT_DATE,1);
insert into reservation (reservation_date,tennis_player_id) values (CURRENT_DATE,2);
insert into reservation (reservation_date,tennis_player_id) values (CURRENT_DATE,3);
insert into reservation (reservation_date,tennis_player_id) values (CURRENT_DATE,4);
insert into reservation (reservation_date,tennis_player_id) values (CURRENT_DATE,5);
insert into reservation (reservation_date,tennis_player_id) values (CURRENT_DATE,6);
insert into reservation (reservation_date,tennis_player_id) values (CURRENT_DATE,7);
insert into reservation (reservation_date,tennis_player_id) values (CURRENT_DATE,8);

insert into tennis_court (tennis_court_name,court_type,price_per_minute) values ('ClayA1',1,0.5);
insert into tennis_court (tennis_court_name,court_type,price_per_minute) values ('ClayA17',2,0.25);
insert into tennis_court (tennis_court_name,court_type,price_per_minute) values ('Grass6Y9',3,1);
insert into tennis_court (tennis_court_name,court_type,price_per_minute) values ('Grass012',4,0.75);
insert into tennis_court (tennis_court_name,court_type,price_per_minute) values ('Court num8',5,1.5);
insert into tennis_court (tennis_court_name,court_type,price_per_minute) values ('Court num9',6,1.25);
insert into tennis_court (tennis_court_name,court_type,price_per_minute) values ('Carpet6',7,2);
insert into tennis_court (tennis_court_name,court_type,price_per_minute) values ('CarpetE78',0,0.76);

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