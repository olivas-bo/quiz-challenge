insert into Show(id, text) values (1, 'Game of Thrones - S6.E7 The Broken Man');

insert into Quiz(id, show_id) values (1, 1);

insert into Question(id, text, quiz_id) values (1, 'What is the name of Jon Snows Direwolf?', 1);

insert into Answer(id, text, question_id, correct) values (1, 'Grey Wind', 1, 0);
insert into Answer(id, text, question_id, correct) values (2, 'Graham', 1, 0);
insert into Answer(id, text, question_id, correct) values (3, 'Ghost', 1, 1);
insert into Answer(id, text, question_id, correct) values (4, 'Gargamel', 1, 0);

insert into Question(id, text, quiz_id) values (2, 'Name the other Stark child: Robb, Brandon, Sansa, Arya. Jon Snow and...?', 1);

insert into Answer(id, text, question_id, correct) values (5, 'Rickon', 2, 1);
insert into Answer(id, text, question_id, correct) values (6, 'Dickon', 2, 0);
insert into Answer(id, text, question_id, correct) values (7, 'Ramsay', 2, 0);
insert into Answer(id, text, question_id, correct) values (8, 'Eddard', 2, 0);

insert into Question(id, text, quiz_id) values (3, 'Whats the name of Lysa Arryns way-too-old-to-be-nursing son?', 1);

insert into Answer(id, text, question_id, correct) values (9, 'Edmore',3,0);
insert into Answer(id, text, question_id, correct) values (10, 'Hoster',3,0);
insert into Answer(id, text, question_id, correct) values (11, 'Robin',3,1);
insert into Answer(id, text, question_id, correct) values (12, 'Nedwell',3,0);

insert into Question(id, text, quiz_id) values (4, 'Which indie band made a cameo appearance at the Purple Wedding?', 1);

insert into Answer(id, text, question_id, correct) values (13, 'Sigur Rós',4,1);
insert into Answer(id, text, question_id, correct) values (14, 'Arcade Fire',4,0);
insert into Answer(id, text, question_id, correct) values (15, 'McBusted',4,0);
insert into Answer(id, text, question_id, correct) values (16, 'The National',4,0);

insert into player(id, name) values(1, 'Bruno');
insert into player(id, name) values(2, 'Tiago');

insert into player_answer(answer_id, player_id) values (3, 1);
insert into player_answer(answer_id, player_id) values (6, 1);
insert into player_answer(answer_id, player_id) values (3, 2);
insert into player_answer(answer_id, player_id) values (5, 2);
