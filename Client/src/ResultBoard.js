import React, { Component } from 'react';
import { Router, Route, Link, browserHistory } from 'react-router';
import _ from 'lodash';

export default class ResultBoard extends Component {

	componentWillMount() {
		this.setState({scores: null})
		// https://github.com/github/fetch
		fetch("http://localhost:8080/player/scores")
			.then(b => b.json())
			.then(q => this.setState({scores: q}));
	}


	render() {
	  const scores = this.state.scores;
	  if(!scores) return null;

	  return (
	    <div className="scores">
				<table>
					<thead>
						<tr>
							<th>Player</th>
							<th>Score</th>
						</tr>
					</thead>
					<tbody>
					{Object.keys(scores).map(result => (
						<tr key={result}><td>{result}</td><td>{scores[result]}</td></tr>
					))}
					</tbody>
				</table>
	    </div>
	  )
	}
}
