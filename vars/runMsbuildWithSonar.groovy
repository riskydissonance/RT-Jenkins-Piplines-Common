#!/usr/bin/env groovy


def call(String configuration = "Release", String platform = "Any CPU", String targetFrameworkVersion="v4.5", String sonarInstance = "Sonarqube", String sonarScannerInstance = "SonarScannerMSBuild"){

    def sonar_msbuild_location = tool sonarScannerInstance

    withSonarQubeEnv(sonarInstance) {
        def sonar_token = System.getenv("SONAR_TOKEN")
        bat "${sonar_msbuild_location}\\SonarScanner.MSBuild.exe begin -k:\"${JOB_NAME}\" -d:sonar.host.url=${env.SONAR_HOST_URL} -d:sonar.login=${sonar_token}"
        runMsbuild(configuration, platform, targetFrameworkVersion)
        bat "${sonar_msbuild_location}\\SonarScanner.MSBuild.exe end -d:sonar.login=${sonar_token}"
    }
}
