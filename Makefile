build:
	mvn assembly:assembly -DdescriptorId=jar-with-dependencies -Dmaven.test.skip=true

run:
	cd target && java -jar testApp-1.0-SNAPSHOT-jar-with-dependencies.jar

test:
	mvn test

docker_build:
	cp target/testApp-1.0-SNAPSHOT-jar-with-dependencies.jar docker && cd docker && docker build .

docker_push:
	docker login quay.io && docker push quay.io/misl/appka