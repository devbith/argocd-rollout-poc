## Instruction to build the docker image

- Build docker image

`docker build -t greet-app .`

- Add a tag to docker image with  

`docker tag greet-app:latest {dockerhub-id}/greet-app:pt`


`docker tag greet-app:latest dockerbishalthapa/greet-app:pt`

- Push docker iamge 

`docker push dockerbishalthapa/greet-app:pt`


