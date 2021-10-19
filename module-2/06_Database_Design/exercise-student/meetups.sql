BEGIN TRANSACTION;

DROP TABLE IF EXISTS member, interestgroup, event, member_group, member_event_list CASCADE;

CREATE TABLE member (
  id SERIAL,
  last_name VARCHAR(200) NOT NULL,
  first_name VARCHAR(200) NOT NULL,
  email_address VARCHAR(200) NOT NULL,
  phone_number BIGINT NULL,
  date_of_birth DATE NOT NULL,
  reminder_email_flag BOOLEAN DEFAULT FALSE NULL,
  CONSTRAINT PK_member_id PRIMARY KEY(id)
);

CREATE TABLE interestgroup (
  id SERIAL,
  group_name VARCHAR(200) NOT NULL,
  CONSTRAINT PK_group_id PRIMARY KEY(id)
);

CREATE TABLE event (
  id SERIAL,
  name VARCHAR(200) NOT NULL,
  description TEXT NOT NULL,
  start_date_time TIMESTAMP NOT NULL,
  duration INTERVAL DEFAULT '30m' CHECK (duration >= '30m') NULL,
  event_organizer INT NULL,
  CONSTRAINT PK_event_id PRIMARY KEY(id),
  CONSTRAINT FK_event_interestgroup FOREIGN KEY(event_organizer) REFERENCES interestgroup(id)
);

CREATE TABLE member_group (
  member_id INT NOT NULL,
  group_id INT NOT NULL,
  CONSTRAINT PK_member_group PRIMARY KEY(member_id, group_id),
  CONSTRAINT FK_member_group_member FOREIGN KEY(member_id) REFERENCES member(id),
  CONSTRAINT FK_member_group_group FOREIGN KEY(group_id) REFERENCES interestgroup(id)
);

CREATE TABLE member_event_list (
  event_id INT NOT NULL,
  member_id INT NOT NULL,
  CONSTRAINT PK_member_event_list PRIMARY KEY(event_id, member_id),
  CONSTRAINT FK_member_event_event FOREIGN KEY(event_id) REFERENCES event(id),
  CONSTRAINT FK_member_event_member FOREIGN KEY(member_id) REFERENCES member(id)
);

INSERT INTO member(last_name, first_name, email_address, phone_number, date_of_birth, reminder_email_flag)
VALUES ('Rodriguez', 'Lauren', 'LorenaGRodriquez@rhyta.com', 7817261511, '1937-02-12', true);

INSERT INTO member(last_name, first_name, email_address, date_of_birth, reminder_email_flag)
VALUES ('Rawlins', 'Justin', 'JustinMRawlins@dayrep.com', '1994-03-01', true);

INSERT INTO member(last_name, first_name, email_address, date_of_birth, reminder_email_flag)
VALUES ('Opitz', 'Stephen', 'StephanSOpitz@dayrep.com', '1951-10-16', true);

INSERT INTO member(last_name, first_name, email_address, phone_number, date_of_birth, reminder_email_flag)
VALUES ('Marshall', 'Kay', 'KayNMarshall@rhyta.com', 2103921107, '1998-01-16', true);

INSERT INTO member(last_name, first_name, email_address, phone_number, date_of_birth)
VALUES ('Chung', 'Megan', 'MeganJChung@teleworm.us', 6508557250, '1956-11-20');

INSERT INTO member(last_name, first_name, email_address, date_of_birth)
VALUES ('Burcham', 'John', 'JohnDBurcham@dayrep.com', '1961-12-25');

INSERT INTO member(last_name, first_name, email_address, date_of_birth)
VALUES ('McDowell', 'Caroline', 'CarolineHMcDowell@dayrep.com', '1954-02-03');

INSERT INTO member(last_name, first_name, email_address, phone_number, date_of_birth)
VALUES ('Real', 'Benjamin', 'BenjaminLReal@rhyta.com', 2133284220, '1966-04-29');

INSERT INTO interestgroup(group_name)
VALUES ('Tarot Obsessives');

INSERT INTO interestgroup(group_name)
VALUES ('Collective Wild Ones');

INSERT INTO interestgroup(group_name)
VALUES ('Bald Eagle Awakenings');

INSERT INTO interestgroup(group_name)
VALUES ('Tango and Beyond Social Club');

INSERT INTO member_group(member_id, group_id)
VALUES (
(SELECT member.id FROM member WHERE last_name = 'Rodriguez'), 
(SELECT interestgroup.id FROM interestgroup WHERE group_name = 'Tarot Obsessives'));

INSERT INTO member_group(member_id, group_id)
VALUES ((SELECT member.id FROM member WHERE last_name = 'Rawlins'), (SELECT interestgroup.id FROM interestgroup WHERE group_name = 'Tarot Obsessives'));

INSERT INTO member_group(member_id, group_id)
VALUES ((SELECT member.id FROM member WHERE last_name = 'Opitz'), (SELECT interestgroup.id FROM interestgroup WHERE group_name = 'Collective Wild Ones'));

INSERT INTO member_group(member_id, group_id)
VALUES ((SELECT member.id FROM member WHERE last_name = 'Marshall'), (SELECT interestgroup.id FROM interestgroup WHERE group_name = 'Collective Wild Ones'));

INSERT INTO member_group(member_id, group_id)
VALUES ((SELECT member.id FROM member WHERE last_name = 'Chung'), (SELECT interestgroup.id FROM interestgroup WHERE group_name = 'Bald Eagle Awakenings'));

INSERT INTO member_group(member_id, group_id)
VALUES ((SELECT member.id FROM member WHERE last_name = 'Burcham'), (SELECT interestgroup.id FROM interestgroup WHERE group_name = 'Bald Eagle Awakenings'));

INSERT INTO member_group(member_id, group_id)
VALUES ((SELECT member.id FROM member WHERE last_name = 'McDowell'), (SELECT interestgroup.id FROM interestgroup WHERE group_name = 'Tango and Beyond Social Club'));

INSERT INTO member_group(member_id, group_id)
VALUES ((SELECT member.id FROM member WHERE last_name = 'Real'), (SELECT interestgroup.id FROM interestgroup WHERE group_name = 'Tango and Beyond Social Club'));

INSERT INTO event(name, description, start_date_time, duration, event_organizer)
VALUES ('Oh How Come Factor', 'A deep dive into the reasons why we ditch party invites', '2021-11-01 2:30 PM', '1h', 1);

INSERT INTO event(name, description, start_date_time, duration, event_organizer)
VALUES ('Checklist Time', 'Create checklists in time for the new year', '2021-12-31 9:30 PM', '2h 15m', 2);

INSERT INTO event(name, description, start_date_time, duration, event_organizer)
VALUES ('Oui Fiesta', 'A unique multi-language event', '2022-01-23 12:00 PM', '2h', 3);

INSERT INTO event(name, description, start_date_time, duration, event_organizer)
VALUES ('ShoNuf Corner', 'Find your inner peace', '2021-12-01 5:00 PM', '1h', 4);

INSERT INTO event(name, description, start_date_time, duration, event_organizer)
VALUES ('Original Wonder Ranch', 'Sit with our true crime panelists and discover what happened to the OG wonder ranch', '2021-10-31 8:00 PM', '3h 45m', 4);

INSERT INTO member_event_list(member_id, event_id)
VALUES ((SELECT member.id FROM member WHERE last_name = 'Rodriguez'), (SELECT event.id FROM event WHERE event.name = 'Oh How Come Factor'));

INSERT INTO member_event_list(member_id, event_id)
VALUES ((SELECT member.id FROM member WHERE last_name = 'Rawlins'), (SELECT event.id FROM event WHERE event.name = 'Oh How Come Factor'));

INSERT INTO member_event_list(member_id, event_id)
VALUES ((SELECT member.id FROM member WHERE last_name = 'Opitz'), (SELECT event.id FROM event WHERE event.name = 'Checklist Time'));

INSERT INTO member_event_list(member_id, event_id)
VALUES ((SELECT member.id FROM member WHERE last_name = 'Marshall'), (SELECT event.id FROM event WHERE event.name = 'Checklist Time'));

INSERT INTO member_event_list(member_id, event_id)
VALUES ((SELECT member.id FROM member WHERE last_name = 'Chung'), (SELECT event.id FROM event WHERE event.name = 'Oui Fiesta'));

INSERT INTO member_event_list(member_id, event_id)
VALUES ((SELECT member.id FROM member WHERE last_name = 'Burcham'), (SELECT event.id FROM event WHERE event.name = 'Oui Fiesta'));

INSERT INTO member_event_list(member_id, event_id)
VALUES ((SELECT member.id FROM member WHERE last_name = 'McDowell'), (SELECT event.id FROM event WHERE event.name = 'ShoNuf Corner'));

INSERT INTO member_event_list(member_id, event_id)
VALUES ((SELECT member.id FROM member WHERE last_name = 'Real'), (SELECT event.id FROM event WHERE event.name = 'ShoNuf Corner'));

INSERT INTO member_event_list(member_id, event_id)
VALUES ((SELECT member.id FROM member WHERE last_name = 'Rodriguez'), (SELECT event.id FROM event WHERE event.name = 'Original Wonder Ranch'));

INSERT INTO member_event_list(member_id, event_id)
VALUES ((SELECT member.id FROM member WHERE last_name = 'Rawlins'), (SELECT event.id FROM event WHERE event.name = 'Original Wonder Ranch'));

INSERT INTO member_event_list(member_id, event_id)
VALUES ((SELECT member.id FROM member WHERE last_name = 'Opitz'), (SELECT event.id FROM event WHERE event.name = 'Original Wonder Ranch'));

INSERT INTO member_event_list(member_id, event_id)
VALUES ((SELECT member.id FROM member WHERE last_name = 'Marshall'), (SELECT event.id FROM event WHERE event.name = 'Original Wonder Ranch'));

INSERT INTO member_event_list(member_id, event_id)
VALUES ((SELECT member.id FROM member WHERE last_name = 'Chung'), (SELECT event.id FROM event WHERE event.name = 'Original Wonder Ranch'));

INSERT INTO member_event_list(member_id, event_id)
VALUES ((SELECT member.id FROM member WHERE last_name = 'Burcham'), (SELECT event.id FROM event WHERE event.name = 'Original Wonder Ranch'));

INSERT INTO member_event_list(member_id, event_id)
VALUES ((SELECT member.id FROM member WHERE last_name = 'McDowell'), (SELECT event.id FROM event WHERE event.name = 'Original Wonder Ranch'));

INSERT INTO member_event_list(member_id, event_id)
VALUES ((SELECT member.id FROM member WHERE last_name = 'Real'), (SELECT event.id FROM event WHERE event.name = 'Original Wonder Ranch'));

COMMIT;

/* Bunch of select statements included below to test the database! */

SELECT * FROM member;

SELECT * FROM interestgroup;

SELECT member.last_name, member.first_name, interestgroup.group_name 
FROM member_group
JOIN member ON member_group.member_id = member.id
JOIN interestgroup ON member_group.group_id = interestgroup.id;

SELECT event.id, event.name, event.description, 
to_char(event.start_date_time, 'MM-DD-YYYY HH12:MI PM') AS start_date_time, 
event.duration, interestgroup.group_name AS event_organizer
FROM event
JOIN interestgroup ON event.event_organizer = interestgroup.id;

SELECT event.name, member.first_name || ' ' || member.last_name AS attendee
FROM event
JOIN member_event_list AS list ON event.id = list.event_id
JOIN member ON list.member_id = member.id;

SELECT event.name, COUNT(list.member_id) AS num_attendees
FROM event
JOIN member_event_list AS list ON event.id = list.event_id
JOIN member ON list.member_id = member.id
GROUP BY event.name;