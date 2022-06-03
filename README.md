# Irrigation project
Irrigation system which helps the automatic irrigation of agricultural lands.

#### Run it locally with docker
You juste need docker compose installed in your local machine
In the project directory:
```sh
$ docker-compose up 
```

The dashboard for irrigation system will be available
```sh
localhost:8081
```

Swagger will be available
```sh
localhost:8080/swagger-ui.html
```
#### Run it locally without docker (you will need node & npm)
If you don't have docker compose your can run it separately.
```sh
$ cd irrigation-system 
```

```sh
$ ./mvnw spring-boot:run 
```
And for the dashboard

```sh
$ cd irrigation-system-dashboard
```
```sh
$ npm install 
```
then
```sh
$ ng serve 
```


The dashboard for irrigation system will be available
```sh
localhost:4200
```

Swagger will be available
```sh
localhost:8080/swagger-ui.html
```
