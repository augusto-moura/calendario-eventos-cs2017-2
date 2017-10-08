// @flow
const { STRING } = require('sequelize');

const sqlConnection = require('./connection-instance');

const User = sqlConnection.define('user', {
  username: STRING,
  password: STRING,
});
