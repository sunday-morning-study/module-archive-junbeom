# 베이스 이미지 선택 (open JDK 17을 사용하는 경우)
#FROM openjdk:17-jdk-alpine

# 베이스 이미지 선택 (amazon corretto JDK 21을 사용하는 경우)
FROM amazoncorretto:21

# 작업 디렉토리 설정
WORKDIR /app

# Gradle 또는 Maven 빌드 파일을 복사하고 종속성 캐시 활용
COPY build.gradle settings.gradle /app/
COPY src /app/src

# JAR 파일을 컨테이너에 복사
COPY build/libs/*.jar app.jar

# JAR 파일 실행
ENTRYPOINT ["java", "-jar", "/app/app.jar"]