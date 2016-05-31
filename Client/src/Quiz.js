import React, { Component } from 'react';
import { Router, Route, Link, browserHistory } from 'react-router';
import _ from 'lodash';

// TODO: http://localhost:8080/show/1/quiz

const sampleQuiz = {
	id: '1',
	questions: [
		{text: 'what color whas Napoleon\'s white horse?',
		 answers: [{text: 'white'}, {text: 'blue'}, 
		 		   {text: 'green'}, {text: 'dotted'}]}
	]
}

export default class Quiz extends Component {

	componentWillMount() {
		fetch("http://localhost:8080/show/1/quiz")
			.then(console.log.bind(console));

	  	this.setState({quiz: sampleQuiz});
	}

	validateAnswer(qs, sel) {
		_.forEach(qs.answers, a => a.className = 'correct');
		this.forceUpdate();
	}

	render() {

	  const quiz = this.state.quiz;
	  if(!quiz) return null;

	  return (
	    <div>
	    	<ul>
		    	{quiz.questions.map(qs =>
	    		<li className="question" key={qs.text}>
	    			<h1>{qs.text}</h1>
	    			<ul>
	    				{qs.answers.map(a => 
	    					<li key={a.text} className={'answer ' + a.className}
	    						onClick={this.validateAnswer.bind(this, qs, a)}>
	    						<h3 style={{display: 'inline'}}>
	    							<i className='skycon-chevron'></i>{a.text}</h3>
	    					</li>
	    				)}
	    			</ul>
	    		</li>
		    	)}
	    	</ul>
	    </div>
	  )
	}
}