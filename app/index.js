const PORTA = process.env.PORT || 3000;

const express = require('express');
const bodyParser = require('body-parser');
const cookieParser = require('cookie-parser');

const extraRoutes = require('./appRoutes');

const app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded());
app.use(cookieParser());
app.use(express.static(`${__dirname}/public`));

for (const route of extraRoutes) {
  app[route.method](route.path, route.handler);
}

app.listen(PORTA, () => console.log(`Servidor subiu na porta: ${PORTA}`));
