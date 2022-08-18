FROM openjdk:11

RUN apt-get update
RUN apt-get install -y curl
RUN wget https://archive.apache.org/dist/maven/maven-3/3.8.3/binaries/apache-maven-3.8.3-bin.tar.gz --no-check-certificate
RUN tar -xvf apache-maven-3.8.3-bin.tar.gz
RUN mv apache-maven-3.8.3 /opt/maven
ENV M2_HOME="/opt/maven"
ENV PATH="$M2_HOME/bin:${PATH}"

COPY . /opt/assurity-qa-e2e
WORKDIR /opt/assurity-qa-e2e