#!/usr/bin/env groovy

def call(String message){
    if("${params.ProjectID}" != "No Project"){
        slackSend(
            teamDomain: System.getenv("SLACK_DOMAIN")
            token: System.getenv("SLACK_TOKEN")
            channel: "#dev-pipeline-failures",
            color: "danger",
            message: message
        )
    }
}
