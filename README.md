# test-bp
test de BP

## Para ejecutar el proyecto localmente creando un aimgane Dokcer
- [1] .\mvnw clean package 
- [2]  docker build -t recachipuendo/app:0.0.1 .
- [3]  docker run -p 8080:8080 recachipuendo/app:0.0.1

## Para realizar una prueba, ejecutar en un postam el siguiente endpoint

- [] http://localhost:8080/auth/authenticate
### Con las siguientes Credenciales en el body:
- [] {
	"username": "rcachipuendo",
	 "password": "Admin1234"
}
