# Steps to run test
After cloning project into your local repository, you need
to launch a container for test project

## Apply below the steps for launching rest-assurred test project container
- Go to root directory of Java Rest-assurred project
- ```docker build -t rest-assurred-test .```
- ```docker run -dp 127.0.0.1:8081:8081 rest-assurred-test```
- Go to container terminal and follow-up the logs produced for test run
