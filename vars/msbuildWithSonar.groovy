#!/usr/bin/env groovy


def call(String configuration = "Release", String platform = "Any CPU", String sonarInstance = "Sonarqube", String sonarScannerInstance = "SonarScannerMSBuild"){

    def sonar_msbuild_location = tool sonarScannerInstance

    withSonarQubeEnv(sonarInstance) {
        bat "${sonar_msbuild_location} begin -k:\"${JOB_NAME}\" -d:sonar.host.url=${env.SONAR_HOST_URL}"
        msbuild(configuration, platform)
        bat "${sonar_msbuild_location} end"
    }
}
