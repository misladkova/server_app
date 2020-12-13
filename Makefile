build:
	mvn assembly:assembly -DdescriptorId=jar-with-dependencies -Dmaven.test.skip=true

run:
	cd target && java -jar testApp-1.0-SNAPSHOT-jar-with-dependencies.jar

test:
	mvn test

docker_build:
	cp target/testApp-1.0-SNAPSHOT-jar-with-dependencies.jar docker && cd docker && docker build -t abc .

docker_push:
	docker tag abc ${REPO_NAME} && docker login quay.io && docker push ${REPO_NAME}