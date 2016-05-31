import React, { Component } from 'react';
import { Router, Route, Link, browserHistory } from 'react-router';
import _ from 'lodash';

export default class Quiz extends Component {

	componentWillMount() {
		this.setState({quiz: null})
		fetch("http://localhost:8080/show/1/quiz")
			.then(b => b.json())
			.then(q => this.setState({quiz: q}));
	}

	validateAnswer(qs, sel) {
		_.forEach(qs.answerCollection, a => a.className = '');
		sel.className = 'selected ' + (sel.correct ? 'correct' : 'incorrect');
		this.forceUpdate();

		//TODO post answer
	}

	render() {
	  const quiz = this.state.quiz;
	  if(!quiz) return null;

	  return (
	    <div>
	    	<ul>
		    	{quiz.questionCollection.map(qs =>
	    		<li className="question" key={qs.id}>
	    			<h1>{qs.text}</h1>
	    			<ul>
	    				{qs.answerCollection.map(a => 
	    					<li key={a.id} className={'answer ' + a.className}
	    						onClick={this.validateAnswer.bind(this, qs, a)}>
	    						<h3 style={{display: 'inline'}}>
	    							<i className='skycon-chevron'></i>{a.text}
	    						</h3>
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