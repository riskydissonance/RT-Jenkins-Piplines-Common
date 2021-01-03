#!/usr/bin/env groovy


def call(String configuration = "Release", String platform = "Any CPU", String targetFrameworkVersion="v4.5", String sonarInstance = "Sonarqube", String sonarScannerInstance = "SonarScannerMSBuild"){

    def sonar_msbuild_location = tool sonarScannerInstance

    withSonarQubeEnv(sonarInstance) {
        bat "${sonar_msbuild_location}\\SonarScanner.MSBuild.exe begin -k:\"${JOB_NAME}\" -d:sonar.host.url=${env.SONAR_HOST_URL} -d:sonar.login=${env.SONAR_AUTH_TOKEN}"
        runMsbuild(configuration, platform, targetFrameworkVersion)
        bat "${sonar_msbuild_location}\\SonarScanner.MSBuild.exe end -d:sonar.login=${env.SONAR_AUTH_TOKEN}"
    }
}
