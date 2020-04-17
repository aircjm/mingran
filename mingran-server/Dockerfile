## For Java 8, try this
## FROM openjdk:8-jdk-alpine
#
## For Java 11, try this
#FROM adoptopenjdk/openjdk11:alpine-jre
#
## Refer to Maven build -> finalName
#ARG JAR_FILE=target/spring-boot-web.jar
#
## cd /opt/app
#WORKDIR /opt/app
#
## cp target/spring-boot-web.jar /opt/app/app.jar
#COPY ${JAR_FILE} app.jar
#
## java -jar /opt/app/app.jar
#ENTRYPOINT ["java","-jar","app.jar"]


## 基础镜像
#FROM frolvlad/alpine-oraclejdk8:slim
#
## 让容器可以访问宿主机上的目录。
## 在主机/var/lib/docker目录下创建了一个临时文件，并链接到容器的/tmp。
## /tmp目录用来持久化到Docker数据文件夹，因为 Spring Boot 使用的内嵌 Tomcat 容器默认使用/tmp作为工作目录
#VOLUME /tmp
#
## 호스트의 directory를 docker 컨테이너에 연결. 즉 소스코드나 외부 설정파일을 커밋하지 않고 docker container에서 사용가능하도록 함
#RUN mkdir -p /app/
#
## 从源系统上复制文件到目标容器的文件系统。
## 将项目的jar文件复制到到容器中，作为 "app.jar"。
## 注意里面的ADD xxx.jar是你使用maven打包之后的jar包的名称。
#ADD mingran-server-0.0.1-SNAPSHOT.jar app.jar
#RUN ls
#RUN ls /app
#
#
## RUN表示在新创建的镜像中执行一些命令，然后把执行的结果提交到当前镜像。
## 这里使用touch命令来改变文件的修改时间，Docker创建的所有容器文件默认状态都是“未修改”。
## 这对于简单应用来说不需要，不过对于一些静态内容（比如：index.html）的文件就需要一个“修改时间”。
#RUN sh -c 'touch /app.jar'
#
## 容器运行后默认执行的命令：用于执行项目app.jar。
## 为了缩短Tomcat的启动时间，添加一个系统属性指向 "/dev/urandom" 作为EntropySource。
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

FROM openjdk:8-jdk
# 어떤 이미지가 기준인지 지정. 플랫폼 : 버전 형태로 작성
MAINTAINER btc_yh <btc_yh@naver.com>
# Dockerfile을 생성-관리하는 사람
VOLUME /tmp
# 호스트의 directory를 docker 컨테이너에 연결. 즉 소스코드나 외부 설정파일을 커밋하지 않고 docker container에서 사용가능하도록 함
RUN mkdir -p /app/
# 도커 이미지 생성시 실행
ADD mingran-server-0.0.1-SNAPSHOT.jar /app/app.jar
# 파일이나 디렉토리를 docker image로 복사

RUN ls /app

EXPOSE 8080
# 외부에 노출할 포트 지정
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
# docker image가 실행될 때 기본으로 실행될 command