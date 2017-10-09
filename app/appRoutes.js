const loginHandler = require('./services/login/loginHandler.js');

/*::
export interface Route {
  method: 'get' | 'post' | 'put' | 'delete';
  path: string | RegExp;
  handler: (req: any, res: any, next: Function) => void;
}
*/

const routes /*: Route[]*/ = [
  {
    method: "post",
    path: "/usuarios/login",
    handler: loginHandler,
  }
];

module.exports = routes;
