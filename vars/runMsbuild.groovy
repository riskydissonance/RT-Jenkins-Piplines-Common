#!/usr/bin/env groovy

def call(String configuration = "Release", String platform = "Any CPU"){

    try {
        bat "nuget restore ${JOB_NAME}.sln"
    } catch (Exception ex) {
        echo "Error running nuget restore: " + ex.message;
        echo "Trying to continue..."
    }

    bat "\"${tool 'MSBuild'}\" ${JOB_NAME}.sln /p:Configuration=${configuration} /p:Platform=\"${platform}\""
}
