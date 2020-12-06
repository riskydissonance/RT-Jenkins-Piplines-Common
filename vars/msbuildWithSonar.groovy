#!/usr/bin/env groovy

import local.jmpesp.Constants

def call(String configuration = "Release", String platform = "Any CPU", String sonarInstance = "Sonarqube"){
    withSonarQubeEnv("${sonarInstance}") {
        bat "${Constants.sonar_msbuild_location} begin -k:\"${JOB_NAME}\" -d:sonar.host.url=${env.SONAR_HOST_URL}"
        msbuild(configuration, platform)
        bat "${Constants.sonar_msbuild_location} end"
    }
}
