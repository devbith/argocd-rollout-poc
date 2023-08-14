FROM amazonlinux:2

RUN yum upgrade -y && yum install java-17-amazon-corretto -y && yum clean all && rm -rf /var/cache/yum

COPY /target/greet-test-app-0.0.1-SNAPSHOT.jar ./greet-test.jar

CMD java -jar --enable-preview greet-test.jar
