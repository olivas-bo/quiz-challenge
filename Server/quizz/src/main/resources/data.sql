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