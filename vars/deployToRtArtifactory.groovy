#!/usr/bin/env groovy

def call(String uploadPattern, String targetRepo, String props = "", String artifactoryInstance = "ARTIFACTORY"){

     script {


        bat 'git rev-parse HEAD > commit'
        def commit = readFile('commit').trim()

        def server = Artifactory.server "${artifactoryInstance}"

        if(props?.trim())
        {
            if(!props.endsWith(";")){
                props += ";"
            }
        }
        props += "ProjectID=${params.ProjectID};rev=${commit}"


        def now = new Date()
        targetRepo += now.format("yyyyMMdd-HH:mm:ss.SSS", TimeZone.getTimeZone('UTC')) + "/"

        def uploadSpec =
            """{
                    "files": [
                        {
                            "pattern": \"${uploadPattern}\",
                            "target": \"${targetRepo}\",
                            "props" : \"${props}\"
                        }
                    ]
                }"""

        def buildInfo = server.upload spec: uploadSpec

        server.publishBuildInfo buildInfo
    }
}
