#!/usr/bin/env groovy

def call(String sonarInstance = "Sonarqube"){
    withSonarQubeEnv(sonarInstance) {
        def sonar_token = System.getenv("SONAR_TOKEN")
        bat "docker run --rm -e SONAR_HOST_URL=\"${env.SONAR_HOST_URL}\" -v \"%cd%:/usr/src\" sonarsource/sonar-scanner-cli:latest -Dsonar.projectKey=${JOB_NAME} -Dsonar.login=${sonar_token}"
    }
}
