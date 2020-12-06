#!/usr/bin/env groovy

def call(String configuration = "Release", String platform = "Any CPU"){

    try {
        bat "nuget restore ${JOB_NAME}.sln"
    }(Exception ex) {
        echo "Error running nuget restore, trying to continue...";
    }

    bat "\"${tool 'MSBuild'}\" ${JOB_NAME}.sln /p:Configuration=${configuration} /p:Platform=\"${platform}\""
}
