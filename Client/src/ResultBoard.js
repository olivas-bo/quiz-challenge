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
							<th><h1>Player</h1></th>
							<th><h1>Score</h1></th>
						</tr>
					</thead>
					<tbody>
					{Object.keys(scores).map((result, index) => (
						<tr className={index == 0 ? 'winner' : ''} key={result + index}>
							<td><h3>{result}</h3></td>
							<td><h3>{scores[result]}</h3></td>
						</tr>
					))}
					</tbody>
				</table>
	    </div>
	  )
	}
}
