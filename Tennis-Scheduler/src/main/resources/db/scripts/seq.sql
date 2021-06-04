drop sequence if exists tennis_player_seq;
drop sequence if exists tennis_court_seq;
drop sequence if exists reservation_seq;
drop sequence if exists time_slot_seq;

create sequence tennis_player_seq increment 1;
create sequence tennis_court_seq increment 1;
create sequence reservation_seq increment 1;
create sequence time_slot_seq increment 1;

ALTER TABLE tennis_player ALTER COLUMN id SET DEFAULT nextval(tennis_player_seq);
ALTER TABLE tennis_court ALTER COLUMN id SET DEFAULT nextval(tennis_court_seq);
ALTER TABLE reservation ALTER COLUMN id SET DEFAULT nextval(reservation_seq);
ALTER TABLE time_slot ALTER COLUMN id SET DEFAULT nextval(time_slot_seq);
