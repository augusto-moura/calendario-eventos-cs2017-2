// @flow

const Sequelize = require("sequelize");
const bcrypt = require("bcryptjs");

const connection = require("./dbConnection");

const userRepository /*: Promise<any>*/ = connection
  .define("user", {
    name: Sequelize.STRING,
    password: Sequelize.STRING,
    salt: Sequelize.STRING
  })
  .sync({ force: true });

/*::
export interface User {
  name: string;
  password: string;
};
*/

const service = {
  createUserHashingPassword(userProps /*: User*/) /*: Promise<void>*/ {
    if (!userProps.name || !userProps.password) {
      throw new Error("Nem todos campos obrigatórios setados");
    }

    return userRepository.then(repository => {
      const userSalt = bcrypt.genSaltSync(10);

      const userCreated = repository.create({
        name: userProps.name,
        salt: userSalt,
        password: bcrypt.hashSync(userProps.password, userSalt)
      });
    });
  },

  passwordMatches(
    userName /*: string*/,
    password /*: string*/
  ) /*: Promise<[boolean, User]>*/ {
    return userRepository
      .then(repository =>
        repository.findOne({
          where: { name: userName }
        })
      )
      .then(user =>
        Promise.all([bcrypt.compare(password, user.password), user])
      );
  }
};

service.createUserHashingPassword({ name: "admin", password: "admin" });

module.exports = service;
