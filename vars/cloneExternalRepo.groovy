#!/usr/bin/env groovy

def call(String gitURL, String commitHash){
     script {
        try {
            checkout([
                $class: 'GitSCM',
                branches: [[name: "${commitHash}"]],
                doGenerateSubmoduleConfigurations: false,
                extensions: [[$class: 'CleanBeforeCheckout']],
                submoduleCfg: [],
                userRemoteConfigs: [[url: "${gitURL}"]]
            ])
        }
        catch(error) {
            echo "Clone of ${gitURL} failed: ${error} . Retrying."
            retry(5) {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: "${commitHash}"]],
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [[$class: 'CleanBeforeCheckout']],
                    submoduleCfg: [],
                    userRemoteConfigs: [[url: "${gitURL}"]]
                ])
            }
        }
    }
}
