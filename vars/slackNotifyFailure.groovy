#!/usr/bin/env groovy

def call(String message){
    slackSend(
        teamDomain: System.getenv("SLACK_DOMAIN"),
        token: System.getenv("SLACK_TOKEN"),
        channel: "#dev-pipeline-failures",
        color: "danger",
        message: message
    )
}
