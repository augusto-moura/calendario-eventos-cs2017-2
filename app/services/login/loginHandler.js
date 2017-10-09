const USER_COOKIE_NAME = "loggeduser";
const AGE_LOGIN_COOKIE_IN_MS = 1000 * 60;

const userRepository = require("../../domain/userRepository");

const isJsonDateStringBefore = (dateString, target = new Date()) => {
  const date = new Date(dateString);
  return date.getTime() <= target.getTime();
};

const createCookieSetter = res => userId => {
  const jsonPayload = JSON.stringify({ userId });

  res.cookie(USER_COOKIE_NAME, jsonPayload, {
    maxAge: AGE_LOGIN_COOKIE_IN_MS
  });
};

const handler = async (req, res, next) => {
  const cookieSetter = createCookieSetter(res);

  const rawUserCookie = req.cookies[USER_COOKIE_NAME];

  let userCookie;
  try {
    userCookie = JSON.parse(rawUserCookie);
  } catch (e) {}

  if (userCookie != undefined && userCookie.userId != undefined) {
    cookieSetter(userCookie.userId);
    return res.send(true);
  }

  const [passwordMatches, user] = await userRepository.passwordMatches(
    req.body.username,
    req.body.password
  );

  if (!passwordMatches) {
    return res.send(error);
  }

  cookieSetter(user.id);
  res.send(passwordMatches);
};

module.exports = handler;
