<h1 align="center">Elo 7 - Backend Jr - Tarcisio Miranda</h1>

## Recursos
- [API](#api)
- [Springboot](#Springboot)
- [Swagger](#grafana)
- [Postgres](#Postgres)
- [Nginx](#Nginx)
- [Flask](#Flask)
- [Dozzle](#Dozzle)
- [Instalação](#instalação)
- [Configuração da API](#configuração)
- [Documentação da API](#documentação)
- [Frontend dos Serviços](#FrontEnd)

## API
A API serve para integrar as ferramentas que são utilizadas nesse projeto. Com ela podemos adicionar uma nova sonda, consulta, listar e enviar os comandos para realizar sua viagem sobre o planeta.
## Springboot
O <a href='https://spring.io/projects/spring-boot'>Spring Boot</a> é um framework Java open source que tem como objetivo facilitar esse processo em aplicações Java. Consequentemente, ele traz mais agilidade para o processo de desenvolvimento. Neste projeto foi usado o Wizard <a href='https://start.spring.io/'>Start Spring</a>.

## Swagger
O <a href='https://swagger.io/'>Swagger</a> é um framework que auxilia a descrição, documentação, consumo e visualização de serviços de uma API REST.

## Postgres
O <a href="https://www.postgresql.org/">Postgres</a> é um sistema gerenciador de banco de dados objeto-relacional.

## Nginx
O <a href="https://www.nginx.com/">Nginx</a> é um software de código aberto para servidores web que suporta os principais protocolos do mercado, neste projeto utilizado como Proxy Reverso.

## Flask
O <a href="https://flask.palletsprojects.com/en/2.1.x/">Flask</a> é um micro framework que utiliza a linguagem Python para criar API REST e serviços Web.

## Dozzle
O <a href="https://dozzle.dev/">Dozzle</a> é um aplicativo simples e responsivo que fornece uma interface baseada na web para monitorar seus logs de contêiner do Docker.

## Instalação
Faça a copia do arquivos .env e faça as edições necessarias para dev ou prod
```bash
$ cp docker/.env.example docker/.env
$ docker-compose --env-file=docker/.env up -d
```

## Configuração
É necessário a criação do usuário das sondas para iniciarmos a viagem <br/>

Sonda 1
```
$ curl -X POST "http://[ip]/sondas/" -H  "accept: */*" -H  "Content-Type: application/json" -d "{  \"id\": 1,  \"name\": \"sonda1\",  \"posicao\": \"W\",  \"x\": 3,  \"y\": 1}"
```
Sonda 2
```
$ curl -X POST "http://[ip]/sondas/" -H  "accept: */*" -H  "Content-Type: application/json" -d "{  \"id\": 1,  \"name\": \"sonda1\",  \"posicao\": \"W\",  \"x\": 3,  \"y\": 1}"
```
## Documentação
Abaixo estão as informações necessárias para a utilização da API.

#### Listar Sondas
`GET /sondas/list`
```bash
$ curl http://[ip]/sondas/list
```

#### Listar Sondas por id
`GET /sondas/{id}`
<br/>{id : Integer}
```bash
$ curl http://[ip]/sondas/{id}
```

#### Listar Sondas por nome
`GET /sondas/findByName/{name}`
<br/>{name : String}
```bash
$ curl http://[ip]/sondas/findByName/{name}
```

#### Listar Sondas maiores que o id especificado
`GET /sondas/list/{id}`
<br/>{id : Integer}
```bash
$ curl http://[ip]/sondas/list/{id}
```

#### Realizar viagem com a Sonda
`POST /sondas/trip/{id}` 
<br/>{id : Integer, command : String}
```
$ curl -X POST "http://192.168.28.10:8080/sondas/trip/{id}" -H  "accept: */*" -H  "Content-Type: application/json" -d "{  \"command\": \"LMLMLMLMM\"}"
```

<br/>
<hr/>

## FrontEnd

#### Tela inciar para consumi os serviços e executar as viagens das Sondas

![alt](https://i.imgur.com/7qM0GFL.png)

<br/>

### Listar todas as sondas direto da chamada GET no Sprinboot
- Sondas https://elo7.tarcisio.me/springboot/sondas/list/
### Listar as Sondas pelo Springboot usando o Flask para fazer as chamadas

- Resultado https://elo7.tarcisio.me/resultado/
- Res. Sonda1 https://elo7.tarcisio.me/resultado/sonda1
- Res. Sonda2 https://elo7.tarcisio.me/resultado/sonda2

<br/>

<hr/>

## Author

👤 **Tarcisio Miranda**

- Linkdin: [Linkedin](https://www.linkedin.com/in/tarcisio-miranda-967106229/)
- Email: [eu@tarcisio.me](eu@tarcisio.me)

