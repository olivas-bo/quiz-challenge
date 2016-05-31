import React, { Component } from 'react';
import { Router, Route, Link, browserHistory } from 'react-router';
import _ from 'lodash';

export default class Quiz extends Component {

	componentWillMount() {
		this.setState({quiz: null})
		// https://github.com/github/fetch
		fetch("http://localhost:8080/show/1/quiz")
			.then(b => b.json())
			.then(q => this.setState({quiz: q}));

		this.setState({questionsAnswered: [], enableFinish: false});
	}

	validateAnswer(qs, sel) {

		this.state.questionsAnswered.push(qs.id);

		_.forEach(qs.answerCollection, a => a.className = '');
		sel.className = 'selected ' + (sel.correct ? 'correct' : 'incorrect');
		this.forceUpdate(); // since we didnt call setState, we need to  force a render

		// /answer/{answerId}/player/{playerId}
		const answerId = sel.id;
		const playerId = 1;
		fetch(`http://localhost:8080/answer/${answerId}/player/${playerId}`, {
		  method: 'POST',
		  body: {}
		});

	}

	render() {
	  const quiz = this.state.quiz;
	  if(!quiz) return null;

	  return (
	    <div className="questions">
	    	<ul>
		    	{quiz.questionCollection.map(qs =>
	    		<li className="question" key={qs.id}>
	    			<h1>{qs.text}</h1>
	    			<ul>
	    				{qs.answerCollection.map(a => 
	    					<li key={a.id} className={'answer ' + a.className + ' ' + (this.state.questionsAnswered.indexOf(qs.id) == -1 ? 'selectable_answer' : '')}
	    						onClick={this.state.questionsAnswered.indexOf(qs.id) == -1 ? this.validateAnswer.bind(this, qs, a) : ''}>
	    						<h3 style={{display: 'inline'}}>
	    							<i className='skycon-chevron'></i>{a.text}
	    						</h3>
	    					</li>
	    				)}
	    			</ul>
	    		</li>
		    	)}
		    	<input type="button" value="finish" disabled={this.state.enableFinish ? '' : 'disabled'} />
	    	</ul>
	    </div>
	  )
	}
}