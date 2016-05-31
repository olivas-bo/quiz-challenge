import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import Quiz from './Quiz';
import Quizzes from './Quizzes';

import { Router, Route, Link, browserHistory } from 'react-router';

require('!style!css!./main.css');

ReactDOM.render(
	<Router history={browserHistory}>
		<Route path="/" component={App} />
		<Route path="/quizzes" component={Quizzes} />
		<Route path="/quiz/:quizId" component={Quiz}/>
	</Router>,
	document.getElementById('root')
);