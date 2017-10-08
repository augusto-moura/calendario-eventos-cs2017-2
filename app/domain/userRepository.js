// @flow

const Sequelize = require('sequelize');
const bcrypt = require('bcryptjs');

const connection = require('./connectionInstance');

const userRepository: Promise<any> = connection.define("user", {
  name: Sequelize.STRING,
  password: Sequelize.STRING,
  salt: Sequelize.STRING
}).sync({ force: true });

/*::
export type User = {
  name: string;
  password: string;
};
*/

const service = {
  createUserHashingPassword(userProps /*: User*/) /*: Promise<void>*/ {
    if (!userProps.name || !userProps.password) {
      throw new Error('Nem todos campos obrigatórios setados');
    }

    return userRepository.then(repository => {
      const userSalt = bcrypt.genSaltSync(10);

      const userCreated = repository.create({
        name: userProps.name,
        salt: userSalt,
        password: bcrypt.hashSync(userProps.password, this.salt)
      });
    });
  }
};

module.exports = service;
