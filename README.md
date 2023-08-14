## Let's Test Argo-Rollout 

This repository contains a sample Spring Boot application named greet-test-app along with Kubernetes configurations in the k8s-config folder. 
The primary purpose of this repository is to try Argo Rollouts for deploying and managing applications.

## Give it a spin on local Minikube Kubernetes playground or take the ultimate challenge and try it on production Kubernetes! 🚀😎

### k8s-config
The k8s-config folder contains Kubernetes configurations for various components used in the deployment process. 

###  Setup
1. Clone this repository to your local machine.
2. Navigate to `k8s-config` directory and follow the `README.md`  

### Experiment
1. `kubectl get service -n localdevelopment`  

Sample output:
```
    NAME                   TYPE           CLUSTER-IP       EXTERNAL-IP      PORT(S)          AGE
    my-greet-app-service   LoadBalancer   10.101.243.159   10.101.243.159   7001:30053/TCP   64m
```

Copy the EXTERNAL-IP and hit `curl 10.101.243.159:7001/greet/1`

2. Edit the k8s manifest `k8s-config/greet-app/1-deployment-manifests.yaml` and change the container image to 

     `dockerbishalthapa/greet-app:pt` or `dockerbishalthapa/greet-app:en`


3. Apply the changes 

    `kubectl apply -f k8s-config/greet-app/1-deployment-manifests.yaml`

4. Watch the rollouts 

     `kubectl argo rollouts get rollout my-greet-app --watch -n localdevelopment` 
 
5. Keep hitting the command `curl 10.101.243.159:7001/greet/1` the request should be forwarded to new pod that is being created.


<i>In the background, the ArgoRollout AnalysisTemplate plays a crucial role. It carefully examines the situation and decides whether 
to proceed with the rollout process upon successful evaluation, or to revert back if there are any issues. </i>



### greet-test-app
The greet-test-app is a Spring Boot application that showcases various features of Spring Boot, including Spring Actuator, Spring Web, and Micrometer with Prometheus registry. This application has been containerized using Docker and the image has been pushed to Docker Hub.

#### How to Run

To run the greet-test-app, follow these steps:

1. Navigate to the greet-test-app directory: `cd greet-test-app`
2. Build the Docker image:
   `docker build -t greet-test-app .`
3. Push the Docker image to Docker Hub (you might need to log in to your Docker Hub account):

 ```
       docker login
       docker push your-dockerhub-username/greet-test-app
```
