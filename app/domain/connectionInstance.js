const Sequelize = require('sequelize');

const DATABASE /*: string*/ = 'calendario';
const DB_USER /*: string*/ = 'admin';
const DB_PASSWORD /*: string*/ = 'admin@4376$;';

const sqlConnection = new Sequelize(DATABASE, DB_USER, DB_PASSWORD, {
  host: 'localhost',
  dialect: 'postgres',
  pool: {
    max: 5,
    min: 0,
    idle: 10000
  },
});

module.exports = sqlConnection;
