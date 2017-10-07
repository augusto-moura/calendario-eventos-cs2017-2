<?php
  $nome = $_POST ["nomeLogin"];
  $senha = $_POST["senhaLogin"];
//Aqui vai ser onde vai ser validado os dados do user
//Vai ser realizado a pesquisa no banco
  if ($nome == 'q' && $senha == 'q') {
    header("Location:/calendario-eventos-cs2017-2/menu/menu.html");
  }else header("Location: /calendario-eventos-cs2017-2/user/login/login.html");

?>
