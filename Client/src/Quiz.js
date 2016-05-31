import React, { Component } from 'react';
import { Router, Route, Link, browserHistory } from 'react-router';

export default class Quiz extends Component {

	componentWillMount() {
	  this.setState({user: {name: 'zzzz'}});
	  console.log(this.props.params.quizId)
	};

	render() {
	  return (
	    <div>
	      <h2>{this.state.user.name}</h2>
	      {/* etc. */}
	    </div>
	  )
	}
}