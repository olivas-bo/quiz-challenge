import React, { Component } from 'react';
import { Router, Route, Link, hashHistory } from 'react-router'

export default class Quizzes extends Component {

	componentWillMount() {
	  this.setState({users: []})
	};
 
	render() {
		const users = [];
		return (
		  <div>
		    <h1>Users</h1>
		    <div className="master">
		      <ul>
		        {this.state.users.map(user => (
		          <li key={user.id}><Link to={`/user/${user.id}`}>{user.name}</Link></li>
		        ))}
		      </ul>
		    </div>
		    <div className="detail">
		      {this.props.children}
		    </div>
		  </div>
		)
  }

}