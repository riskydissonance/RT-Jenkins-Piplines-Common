#!/usr/bin/env groovy

def call(){
    slackNotifyFailure("${JOB_NAME} deploy failed for ${params.ProjectID} by ${env.BUILD_USER_ID}: *${env.DEPLOY_VERSION}*. <${env.BUILD_URL}|Check build>")
}
