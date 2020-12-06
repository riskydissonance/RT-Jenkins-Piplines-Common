#!/usr/bin/env groovy

def call(String configuration = "Release", String platform = "Any CPU"){
    bat 'nuget restore SolutionName.sln'
    bat "\"${tool 'MSBuild'}\" ${JOB_NAME}.sln /p:Configuration=${configuration} /p:Platform=\"${platform}\""
}
