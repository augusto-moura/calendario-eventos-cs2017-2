const Sequelize = require('sequelize');
const sqlConnection = new Sequelize('calendario', 'postgres', '');

module.exports = sqlConnection;
