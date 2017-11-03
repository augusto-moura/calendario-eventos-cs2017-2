# Calendário de eventos

Uma agenda de eventos e compromissos.


### Iniciar a aplicação
Para iniciar a aplicação é necessário ter instalado no computador a JDK 8.

Para iniciar a aplicação basta executar no terminal:
Se windows:
````powershell
.\gradlew.bat bootRun
````
Se linux
````bash``
./gradlew bootRun
````

Por padrão a aplicação irá requisitar um usuário em um popup, a senha do usuário é escrita na saída da aplicação (no caso no terminal onde os comandos foram executados), o nome do usário é `user`. A senha estará presente como no exemplo:
```
Using default security password: [senha bem grande aqui]
```

### Executando os testes
Para executar os testes é necessário ter instalado no computador o Groovy 2.4.

Para executar os testes basta executar no terminal:
Se windows:
````powershell
.\gradlew.bat test
````
Se linux
````bash
./gradlew test
````