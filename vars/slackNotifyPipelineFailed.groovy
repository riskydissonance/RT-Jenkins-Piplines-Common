#!/usr/bin/env groovy

def call(){
    slackNotifyFailure("${JOB_NAME} pipeline failed for ${params.projectId}. <${env.BUILD_URL}|Check build>.")
}
