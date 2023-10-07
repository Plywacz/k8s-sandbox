docker image rm -f server:1.0.0 client:1.0.0
docker build -t client:1.0.0 .\client
docker build -t server:1.0.0 .\server
docker compose up