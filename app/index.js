const userService = require('./domain/userRepository.js');

userService.createUserHashingPassword({
  batata: 12,
  name: 'Augusto',
  password: '123',
});
