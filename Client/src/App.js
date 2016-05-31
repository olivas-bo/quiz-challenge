import React, { Component } from 'react';
import { Router, Route, Link, browserHistory } from 'react-router';

export default class App extends Component {
  render() {
    return (
      <div>
	      <h1>Hello, world.</h1>
	      <Link to="/quizzes">users</Link>
	      <br/>
	      <Link to={`/quiz/${Math.random()}`}>user</Link>
      </div>
    );
  }
}
