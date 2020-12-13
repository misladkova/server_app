## ServerApp

This java application runs on http server, port 8088

### Makefile

build app
```bat
$ make build
```
run app
```bat
$ make run
```
run tests
```bat
$ make test
```
build docker image
```bat
$ make docker_build
```
rename docker image and push it to quay.io registry, REPONAME=e.g. /misl/appka
```bat
$ make docker_push
```

### kubernetes  

creating deployment based on YAML file
```bat
$ kubectl create -f deployment.yaml
```
list the pods in the current namespace
```bat
$ kubectl get pods -o wide
```


