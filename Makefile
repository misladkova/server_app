build:
	mvn assembly:assembly -DdescriptorId=jar-with-dependencies -Dmaven.test.skip=true

run:
	cd target && java -jar serverApp-1.0-SNAPSHOT-jar-with-dependencies.jar

test:
	mvn test

docker_build:
	cp target/serverApp-1.0-SNAPSHOT-jar-with-dependencies.jar docker && cd docker && docker build -t myImage .

docker_push:
	docker tag myImage ${REPO_NAME} && docker login quay.io && docker push ${REPO_NAME}