import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import Quiz from './Quiz';
import Quizzes from './Quizzes';

import { Router, Route, Link, hashHistory } from 'react-router';

ReactDOM.render(
	<Router history={hashHistory}>
		<Route path="/" component={App} />
		<Route path="/quizzes" component={Quizzes} />
		<Route path="/quiz/:quizId" component={Quiz}/>
	</Router>,
	document.getElementById('root')
);