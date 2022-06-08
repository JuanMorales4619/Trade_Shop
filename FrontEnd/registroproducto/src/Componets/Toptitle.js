import React, { Component } from "react";

export default class Toptitle extends Component {
  render(props) {
    return (
      <div>
        <h1>{props.title}</h1>
      </div>
    );
  }
}
