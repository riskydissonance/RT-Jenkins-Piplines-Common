#!/usr/bin/env groovy

def call(String configuration = "Release", String platform = "Any CPU"){
    bat "\"${tool 'MSBuild'}\" ${JOB_NAME}.sln /p:Configuration=${configuration} /p:Platform=\"${platform}\""
}
