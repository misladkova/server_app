build:
	mvn assembly:assembly -DdescriptorId=jar-with-dependencies -Dmaven.test.skip=true

run:
	cd target && java -jar serverApp-1.0-SNAPSHOT-jar-with-dependencies.jar

test:
	mvn test

docker_build:
	cp target/serverApp-1.0-SNAPSHOT-jar-with-dependencies.jar docker && cd docker && docker build -t myimage .

docker_push:
	docker tag myimage ${REPO_NAME} && docker login quay.io && docker push ${REPO_NAME}