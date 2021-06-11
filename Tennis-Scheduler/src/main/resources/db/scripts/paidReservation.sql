alter table reservation add column paied boolean;
alter table reservation alter column paied set default false;