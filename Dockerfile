#FROM maven:3-eclipse-temurin-17 AS build
#WORKDIR /home/app

# 依存関係キャッシュ
#COPY pom.xml .
#RUN mvn dependency:go-offline -B

# ソースコードコピー＆ビルド
#COPY src ./src
#RUN mvn clean package -DskipTests

#FROM eclipse-temurin:17-jre-alpine
#WORKDIR /app

# JAR名を柔軟に
#ARG JAR_FILE=/home/app/target/mikami-gohan-0.0.1-SNAPSHOT.jar
#COPY --from=build ${JAR_FILE} app.jar

# 非rootユーザー
#RUN addgroup -S mikami-gohan && adduser -S general-user -G mikami-gohan
#USER mikami-gohan:general-user

#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "app.jar"]


FROM maven:3-eclipse-temurin-17 AS build
COPY ./ /home/app
RUN cd /home/app && mvn clean package -Dmaven.test.skip=true
FROM eclipse-temurin:17-alpine
COPY --from=build /home/app/target/mikami-gohan-0.0.1-SNAPSHOT.jar /usr/local/lib/mikami-gohan-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/mikami-gohan-0.0.1-SNAPSHOT.jar"]