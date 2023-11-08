# Steps to run test
After cloning projects(dummy server and test project) into your local repository, you need
to launch two containers; one for dummy server the other one for actual test project

## Apply below the steps for launching a dummy server container
- Go to root directory of Node project(https://github.com/ozgurcubuk/node-mock-api.git)
- ```docker build -t node-mock-api .```
- ```docker run -dp 127.0.0.1:8080:8080 node-mock-api```
- Go to container terminal and verify that to mock node api is launched

## Apply below the steps for launching rest-assurred test project container
- Go to root directory of Java Rest-assurred project
- ```docker build -t rest-assurred-test .```
- ```docker run -dp 127.0.0.1:8081:8081 rest-assurred-test```
- Go to container terminal and follow-up the logs produced for test run
