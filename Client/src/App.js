import React, { Component } from 'react';
import { Router, Route, Link, browserHistory } from 'react-router';

export default class App extends Component {

  componentDidMount() {
  	setTimeout(() => browserHistory.push('/quiz/xxxx'), 1000)
  }

  render() {
    return (
      <div>
	      <h1>Hold you horses, loading your quiz</h1>	      
      </div>
    );
  }
}
