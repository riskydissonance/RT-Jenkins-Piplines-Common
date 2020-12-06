#!/usr/bin/env groovy

def call(String sonarInstance = "Sonarqube"){
    withSonarQubeEnv(sonarInstance) {
        bat "docker run --rm -e SONAR_HOST_URL=\"${env.SONAR_HOST_URL}\" -v \"%cd%:/usr/src\" sonarsource/sonar-scanner-cli:latest -Dsonar.projectKey=${JOB_NAME}"
    }
}
