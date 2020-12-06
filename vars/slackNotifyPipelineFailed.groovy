#!/usr/bin/env groovy

def call(){
    slackNotifyFailure("${JOB_NAME} deploy failed for ${params.ProjectID}: *${env.DEPLOY_VERSION}*. <${env.BUILD_URL}|Check build>")
}
