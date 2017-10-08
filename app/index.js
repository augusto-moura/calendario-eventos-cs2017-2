const express = require('express');

const PORTA = process.env.PORT || 3000;

const app = express();

// app.use((req, res, next) => {
//   if (req.headers['x-forwarded-proto'] === 'https') {
//     res.redirect(`http://${req.hostname + req.url}`);
//   } else {
//     next();
//   }
// });

app.use(express.static(`${__dirname}/public`));

app.listen(PORTA, () => console.log(`Servidor subiu na porta: ${PORTA}`));
