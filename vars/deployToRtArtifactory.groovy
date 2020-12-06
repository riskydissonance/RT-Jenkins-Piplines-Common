#!/usr/bin/env groovy

def call(String uploadPattern, String targetRepo, String artifactoryInstance = "ARTIFACTORY", ){

     script {

        def server = Artifactory.server "${artifactoryInstance}"

        def uploadSpec =
            """{
                    "files": [
                        {
                            "pattern": \"${uploadPattern}\",
                            "target": \"${targetRepo}\"
                        }
                    ]
                }"""

        def buildInfo = server.upload spec: uploadSpec

        server.publishBuildInfo buildInfo
    }
}
