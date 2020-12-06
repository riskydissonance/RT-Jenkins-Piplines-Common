#!/usr/bin/env groovy

import local.jmpesp.Constants

def msbuild(String configuration = "Release", String platform = "Any CPU"){
    bat "\"${tool 'MSBuild'}\" ${JOB_NAME}.sln /p:Configuration=${configuration} /p:Platform=\"${platform}\""
}

def msbuild_with_sonar(String configuration = "Release", String platform = "Any CPU", String sonarInstance = "Sonarqube"){
    withSonarQubeEnv("${sonarInstance}") {
        bat "${Constants.sonar_msbuild_location} begin -k:\"${JOB_NAME}\" -d:sonar.host.url=${env.SONAR_HOST_URL}"
        msbuild(configuration, platform)
        bat "${Constants.sonar_msbuild_location} end"
    }
}
