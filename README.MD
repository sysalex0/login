# Login Microservice PRD


## Overview
The login microservice is a simple and efficient microservice that provides user authentication and authorization.


## Features and Requirements
The microservice should implement the following core features:
- User registration: The microservice should allow new users to create an account and store their information in the database.
- User authentication: The microservice should provide a secure and reliable method for authenticating users using JWT.
- Password reset: The microservice should allow users to reset their password if they forget it or need to change it.
- Security: The microservice should implement appropriate security measures, such as encryption and access control, to protect user data and prevent unauthorized access.


### User Interface
The login microservice will have a simple user interface that allows users to register, log in, and reset their password.

## API and Integration
The login microservice API will use RESTful endpoints and JSON data format. The microservice will integrate with other systems using HTTP or HTTPS protocols.


## Testing and Quality Assurance
The login microservice will undergo unit testing and integration testing to ensure that it meets the functional and non-functional requirements. The microservice will also undergo security testing to identify and mitigate potential security vulnerabilities.


## Deployment and Maintenance
The login microservice will be deployed using Docker containers and managed using Kubernetes. The microservice will be monitored for performance and availability using monitoring tools like Prometheus and Grafana. Security patches and updates will be applied regularly to ensure the microservice is secure and up-to-date.By using RabbitMQ as the message broker, the login microservice can process login and authentication requests asynchronously, improve scalability and performance, and ensure that the microservice meets the requirements for user authentication and authorization.

## Technology Stack
The login microservice will be implemented using the following technologies:
- Java: Programming language
- Spring Boot: Framework for building microservices
- Spring Security: Security framework for Java
- JWT (JSON Web Tokens): Token-based authentication mechanism
- Hibernate: Object-Relational Mapping (ORM) framework for Java
- MySQL: Relational database management system
- Gradle or Maven: Build tools for Java
- RabbitMQ: Message queue technology for asynchronous processing of login and authentication requests

## Get started
1. Start kubernetes local cluster in docker
    ```shell
    minikube start --driver=docker
    ```
2. [Windows Only] Allow Kubernetes read your local docker repository

   Run this command to set ENV variable in your current shell
   ```
   minikube docker-env
   ```
   Execute the last line command from the result, to apply the changes according to the ENV variables
   The command should like
   ```
   @FOR /f "tokens=*" %i IN ('minikube -p minikube docker-env --shell cmd') DO @%i
   ```
   Verify the effect by running `docker image ls` and `minikube image ls`, they should show the same images.
   When you want to switch it back to local docker repository, simply restart the shell. As the ENV variables will drop after restart.

3. Build image to minikube's image registry
   ```shell
   mvnw compile jib:dockerBuild  
   ```
4. create service, pods, etc
    ```bash
    kubectl apply -R -f kubernetes/
    ```
5. healthcheck
   ```shell
    kubectl get all
    ```

## Access service(s) through host machine locahost
### N ways to do so
1. through ingress for api server
   ```shell
   minikube tunnel --cleanup
   curl http://localhost/internal/api/actuator/health
   ```
2. port forward kubernetes service port to localhost port for accessing other service
    ```
    kubectl port-forward svc/[service_name] [host_machine_port]:[service_cluster_ip_port]
    ```
   ``` SHELL
    kubectl port-forward svc/login-db 31000:10001
    ```
3. Using minikube command to get the URL from 
   ```shell
   minikube service [service_name] --url
   ```


# Useful links
## Kubernetes 
### K8s structure using ingress --> service --> deployment in local
https://alankrantas.medium.com/%E7%AD%86%E8%A8%98-%E5%9C%A8%E6%9C%AC%E6%A9%9F-kubernetes-%E7%92%B0%E5%A2%83%E4%BD%88%E7%BD%B2%E5%AE%B9%E5%99%A8%E4%B8%A6%E4%B8%B2%E6%8E%A5%E6%9C%8D%E5%8B%99-ingress-%E4%BC%BA%E6%9C%8D%E5%99%A8-%E4%BD%BF%E7%94%A8-minikube-%E8%88%87%E5%96%AE%E4%B8%80-yaml-%E6%AA%94%E5%AF%A6%E4%BD%9C-1d25228e6416

### K8s yaml explain in details with example, including ingress, service, deployment, pod
https://cwhu.medium.com/kubernetes-implement-ingress-deployment-tutorial-7431c5f96c3e

## Application Desgin 
### Event driven auth service reference
https://medium.com/peerone-technology-%E7%9A%AE%E5%81%B6%E7%8E%A9%E4%BA%92%E5%8B%95%E7%A7%91%E6%8A%80/%E5%9F%BA%E6%96%BC-event-driven-architecture-%E7%82%BA%E5%BE%AE%E6%9C%8D%E5%8B%99%E6%9E%B6%E6%A7%8B%E6%89%93%E9%80%A0-auth-service-a81aac364b21

## Others
### Readme content generated by chatGPT and the format generated by
https://mr0grog.github.io/google-docs-to-markdown/
