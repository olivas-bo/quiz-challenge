insert into Show(id, text) values (1, 'Game of Thrones - S6.E7 The Broken Man');

insert into Quiz(id, show_id) values (1, 1);

insert into Question(id, text, quiz_id) values (1, 'Dummy Sample question 1', 1);
-- insert into Question(id, text, quizId) values (2, 'Dummy Sample question 2', 1);
-- insert into Question(id, text, quizId) values (3, 'Dummy Sample question 3', 1);

insert into Answer(id, text, question_id, correct) values (1, 'Answer 1', 1, 0);
insert into Answer(id, text, question_id, correct) values (2, 'Answer 2', 1, 0);
insert into Answer(id, text, question_id, correct) values (3, 'Answer 3', 1, 0);
insert into Answer(id, text, question_id, correct) values (4, 'Answer 4', 1, 1);