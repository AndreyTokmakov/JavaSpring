curl http://0.0.0.0:8080/v1/mongodbapp/books
curl -X POST http://0.0.0.0:8080/v1/mongodbapp/books  --header "Content-Type: application/json" --data '{"title":"aaaa","author":"xyz","isbn":"xyz"}' 