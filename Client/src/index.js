import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import Quiz from './Quiz';
import Quizzes from './Quizzes';
import ResultBoard from './ResultBoard';

import { Router, Route, Link, browserHistory } from 'react-router';

require('!style!css!./main.css');

ReactDOM.render(
	<Router history={browserHistory}>
		<Route path="/" component={App} />
		<Route path="/quizzes" component={Quizzes} />
		<Route path="/quiz/:quizId" component={Quiz}/>
		<Route path="/board/:quizId" component={ResultBoard}/>
	</Router>,
	document.getElementById('root')
);
