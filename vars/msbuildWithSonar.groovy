#!/usr/bin/env groovy

static String sonar_msbuild_location = "C:\\tools\\sonar-scanner-msbuild-5.0.4.24009-net46\\SonarScanner.MSBuild.exe"

def call(String configuration = "Release", String platform = "Any CPU", String sonarInstance = "Sonarqube"){
    withSonarQubeEnv("${sonarInstance}") {
        bat "${sonar_msbuild_location} begin -k:\"${JOB_NAME}\" -d:sonar.host.url=${env.SONAR_HOST_URL}"
        msbuild(configuration, platform)
        bat "${sonar_msbuild_location} end"
    }
}
