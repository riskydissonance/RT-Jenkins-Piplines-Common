#!/usr/bin/env groovy

def call(){
    slackNotifyFailure("${env.STACK_PREFIX} ${JOB_NAME} deploy failed for ${params.ProjectID}: *${env.DEPLOY_VERSION}*. <${env.BUILD_URL}|Check build>")
}
